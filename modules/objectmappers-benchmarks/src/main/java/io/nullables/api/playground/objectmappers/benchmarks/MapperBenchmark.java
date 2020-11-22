package io.nullables.api.playground.objectmappers.benchmarks;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.bull.BullMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.converter.ConverterMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.datus.DatusMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.dozer.DozerMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.mapstruct.MapStructMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.modelmapper.ModelMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.orika.OrikaMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.remap.ReMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.selma.SelmaMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderFactory;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Slf4j
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.All)
@Measurement(iterations = 5)
public class MapperBenchmark {

    @Param({"Bull", "Converter", "Datus", "Dozer", "MapStruct", "ModelMapper", "Orika", "ReMap", "Selma"})
    private String type;

    private OrderMapper mapper;
    private OrderEntity order;

    public static void main(final String... args) throws Exception {
        final Options opts = new OptionsBuilder().include(".*").warmupIterations(2).measurementIterations(2)
            .jvmArgs("-server").forks(1).resultFormat(ResultFormatType.TEXT).build();

        final Collection<RunResult> results = new Runner(opts).run();
        for (final RunResult result : results) {
            final Result<?> r = result.getPrimaryResult();
            log.info("API replied benchmark score: " + r.getScore() + " " + r.getScoreUnit() + " over "
                + r.getStatistics().getN() + " iterations");
        }
    }

    @Setup(Level.Trial)
    public void setup() {
        switch (this.type) {
            case "Bull":
                this.mapper = new BullMapper();
                break;
            case "Converter":
                this.mapper = new ConverterMapper();
                break;
            case "Datus":
                this.mapper = new DatusMapper();
                break;
            case "Dozer":
                this.mapper = new DozerMapper();
                break;
//            case "JMapper":
//                this.mapper = new JMapperMapper();
//                break;
            case "MapStruct":
                this.mapper = new MapStructMapper();
                break;
            case "ModelMapper":
                this.mapper = new ModelMapper();
                break;
            case "Orika":
                this.mapper = new OrikaMapper();
                break;
            case "ReMap":
                this.mapper = new ReMapper();
                break;
            case "Selma":
                this.mapper = new SelmaMapper();
                break;
            default:
                throw new IllegalStateException("Unknown type: " + this.type);
        }
    }

    @Setup(Level.Iteration)
    public void preInit() {
        this.order = OrderFactory.buildOrder();
    }

    @Benchmark
    @Group("simpleTest")
    public OrderDto mapper() {
        return this.mapper.map(this.order);
    }
}
