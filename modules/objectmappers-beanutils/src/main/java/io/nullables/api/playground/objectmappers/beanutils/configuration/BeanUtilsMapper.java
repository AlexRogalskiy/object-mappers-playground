package io.nullables.api.playground.objectmappers.beanutils.configuration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class BeanUtilsMapper<S, T> {

    private final Class<T> targetClass;
    private final List<BiConsumer<S, T>> operations;

    private BeanUtilsMapper(final BeanUtilsMapperBuilder<S, T> builder) {
        this.targetClass = builder.getTargetClass();
        this.operations = builder.getOperations();
    }

    public static <S, T> BeanUtilsMapperBuilder<S, T> newBuilder(final Class<T> targetClass) {
        return new BeanUtilsMapperBuilder<>(targetClass);
    }

    private static <T> T newInstance(final Class<T> clazz, final Object... args) {
        try {
            final Class<?>[] parameterTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
            return clazz.getConstructor(parameterTypes).newInstance(args);
        } catch (Throwable ex) {
            log.error("Cannot initialize new instance from class: {} by arguments: {}", clazz, args, ex);
            throw new IllegalArgumentException(ex);
        }
    }

    public T map(final S source) {
        final T target = newInstance(this.targetClass);
        this.operations.forEach(op -> op.accept(source, target));
        return target;
    }

    @Getter
    public static class BeanUtilsMapperBuilder<S, T> {

        private final Class<T> targetClass;
        private final BeanUtilsBean mapper;
        private final List<BiConsumer<S, T>> operations;

        private BeanUtilsMapperBuilder(final Class<T> targetClass) {
            this.targetClass = targetClass;
            this.mapper = BeanUtilsBean2.getInstance();
            this.operations = new ArrayList<>();
        }

        public <V> BeanUtilsMapperBuilder<S, T> map(final String propertyName, final Function<S, V> mapper) {
            this.operations.add((source, target) -> this.map(target, propertyName, mapper.apply(source)));
            return this;
        }

        public <V> BeanUtilsMapperBuilder<S, T> map(final Supplier<V> supplier) {
            this.operations.add((source, target) -> this.map(target, source));
            return this;
        }

        public BeanUtilsMapper<S, T> build() {
            return new BeanUtilsMapper<>(this);
        }

        private <V> void map(final T target, final String propertyName, final V value) {
            try {
                this.mapper.copyProperty(target, propertyName, value);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                log.error("Error: cannot map source property: {} to target entity: {}", propertyName, target, ex);
            }
        }

        private void map(final T target, final S source) {
            try {
                this.mapper.copyProperties(target, source);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                log.error("Error: cannot map source entity: {} to target entity: {}", source, target, ex);
            }
        }
    }
}
