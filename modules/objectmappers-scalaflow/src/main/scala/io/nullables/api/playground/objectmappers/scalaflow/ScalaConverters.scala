package io.nullables.api.playground.objectmappers.scalaflow

import java.util.function.{BiFunction => JFunction2, BinaryOperator => JBinaryOperator, Function => JFunction, Predicate => JPredicate, Supplier => JSuppiler}

import io.nullables.api.playground.objectmappers.scalaflow.Iso.<~>

import scala.annotation.implicitNotFound

/**
  * Useful for converting Fugue types to Scala and vice-versa.
  *
  * to use, simply `import ScalaConverters._` and then add `.toScala` and `.toJava` as required.
  *
  * Note: that the Fugue side will have Java types such as `java.lang.Integer` and the Scala
  * side will have the Scala equivalents such as `Int`. It will pass reference types though unchanged.
  *
  * Also note that a `Function[Pair[A, B], C]` converts to an `((A, B)) => C` – note the inner parens,
  * it converts to a tupled (1 arg that is a tuple) function. You can turn that into an
  * `(A, B) => C` with `scala.Function.untupled _'
  *
  * Note: The class was moved from package io.atlassian.fugue to io.atlassian.fugue.converters in 2.4, where
  * 'toScala', 'toJava' has been replaced by 'toScala', 'toJava'
  *
  */
object ScalaConverters extends LowerPriorityConverters {

  import Iso.<~>

  implicit class ToJavaSyntax[A](val a: A) extends AnyVal {
    def toJava[B](implicit iso: B <~> A): B = iso asA a
  }

  implicit class ToScalaSyntax[A](val a: A) extends AnyVal {
    def toScala[B](implicit iso: A <~> B): B = iso asB a
  }

  implicit def SupplierIso[A, AA](implicit ev: A <~> AA): <~>[JSuppiler[A], () => AA] =
    Iso[JSuppiler[A], () => AA] { a => () =>
      a.get.toScala
    } { a =>
      new JSuppiler[A] {
        def get: A = a().toJava
      }
    }

  implicit def FunctionIso[A, AA, B, BB](implicit eva: A <~> AA, evb: B <~> BB): Iso[JFunction[A, B], AA => BB] =
    Iso[JFunction[A, B], AA => BB] { f => a =>
      f(a.toJava).toScala
    } { f => (a: A) =>
      f(a.toScala).toJava
    }

  implicit def JBinaryOperatorIso[A, AA](implicit ia: A <~> AA): <~>[JBinaryOperator[A], (AA, AA) => AA] =
    Iso[JBinaryOperator[A], (AA, AA) => AA] { f =>
      {
        case (a, b) => f(a.toJava, b.toJava).toScala
      }
    } { f => (a1: A, a2: A) =>
      f(a1.toScala, a2.toScala).toJava
    }

  implicit def PredicateIso[A, AA](implicit eva: A <~> AA): <~>[JPredicate[A], (AA) => Boolean] =
    Iso[JPredicate[A], AA => Boolean] { f => a =>
      f.test(a.toJava)
    } { f => (a: A) =>
      f(a.toScala)
    }
}

trait LowerPriorityConverters extends LowestPriorityConverters {

  import Iso.<~>
  import ScalaConverters.{ToJavaSyntax, ToScalaSyntax}

  implicit def Function2Iso[A, AA, B, BB, C, CC](
    implicit ia: A <~> AA,
    ib: B <~> BB,
    ic: C <~> CC
  ): <~>[JFunction2[A, B, C], (AA, BB) => CC] =
    Iso[JFunction2[A, B, C], (AA, BB) => CC] { f =>
      {
        case (a, b) => f(a.toJava, b.toJava).toScala
      }
    } { f => (a: A, b: B) =>
      f(a.toScala, b.toScala).toJava
    }

}

trait LowestPriorityConverters {

  implicit def AnyRefIso[A <: AnyRef]: A <~> A =
    Iso.id[A]
}

/**
  * Isomorphism/Bijection between Java and Scala types.
  *
  * Must be natural and a proper bijection, cannot be partial.
  */
@implicitNotFound(
  msg = """Cannot find Iso instance
  from: ${A}
    to: ${B}

– usually this is because Scala can't infer one of the types correctly, try specifying the type parameters directly with:

     toScala[OutType]
     toJava[OutType]

  Alternately there may not be an Iso for your type.

  If you need to construct one that simply passes the type through to the other side otherwise side use:

    implicit val MyTypeIso = Iso.id[MyType]
    """
)
sealed trait Iso[A, B] {
  def asB(a: A): B

  def asA(s: B): A
}

object Iso {

  /**
    * Construct an Iso that passes through the type to be used on both sides
    */
  def id[A] = same[A, A]

  type <~>[A, B] = Iso[A, B]

  def apply[A, B](f: A => B)(g: B => A): A <~> B =
    new (A <~> B) {
      def asB(a: A): B = f(a)

      def asA(b: B): A = g(b)
    }

  def same[A, B](implicit asB: A =:= B, asA: B =:= A) = Iso(asB)(asA)
}
