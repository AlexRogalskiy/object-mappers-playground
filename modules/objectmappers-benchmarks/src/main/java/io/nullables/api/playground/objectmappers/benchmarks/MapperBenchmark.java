package io.nullables.api.playground.objectmappers.benchmarks;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.converter.ConverterMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.dozer.DozerMapper;
//import io.nullables.api.playground.objectmappers.benchmarks.mapper.jmapper.JMapperMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.mapstruct.MapStructMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.modelmapper.ModelMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.orika.OrikaMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.selma.SelmaMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderFactory;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;

@Slf4j
@State(Scope.Benchmark)
public class MapperBenchmark {

    private final OrderMapper dozerMapper = new DozerMapper();
    private final OrderMapper orikaMapper = new OrikaMapper();
    private final OrderMapper modelMapper = new ModelMapper();
    private final OrderMapper mapStructMapper = new MapStructMapper();
    private final OrderMapper selmaMapper = new SelmaMapper();
//    private final OrderMapper jMapper = new JMapperMapper();
    private final OrderMapper manualMapper = new ConverterMapper();

    @Benchmark
    public void dozer() {
        this.dozerMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void orika() {
        this.orikaMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void modelMapper() {
        this.modelMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void mapStruct() {
        this.mapStructMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void selma() {
        this.selmaMapper.map(OrderFactory.buildOrder());
    }

//    @Benchmark
//    public void jmapper() {
//        this.jMapper.map(OrderFactory.buildOrder());
//    }

    @Benchmark
    public void manual() {
        this.manualMapper.map(OrderFactory.buildOrder());
    }

    public static void main(final String... args) throws Exception {
        final Options opts = new OptionsBuilder()
            .include(".*")
            .warmupIterations(2)
            .measurementIterations(2)
            .jvmArgs("-server")
            .forks(1)
            .resultFormat(ResultFormatType.TEXT)
            .build();

        final Collection<RunResult> results = new Runner(opts).run();
        for (final RunResult result : results) {
            final Result<?> r = result.getPrimaryResult();
            log.info("API replied benchmark score: "
                + r.getScore() + " "
                + r.getScoreUnit() + " over "
                + r.getStatistics().getN() + " iterations");
        }
    }
}
