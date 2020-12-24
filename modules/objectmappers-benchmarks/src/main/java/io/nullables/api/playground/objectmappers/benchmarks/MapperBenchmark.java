/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.benchmarks;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.beanmapper.GeneralBeanMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.beanutils.BeanUtilsMapper;
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

@Slf4j
@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(value = 1, warmups = 1, jvmArgs = "-XX:-StackTraceInThrowable")
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.All)
public class MapperBenchmark {

    @Param({
        "BeanMapper",
        "BeanUtilsMapper",
        "Bull",
        "Converter",
        "Datus",
        "Dozer",
        "MapStruct",
        "ModelMapper",
        "Orika",
        "ReMap",
        "Selma"
    })
    private String type;

    private OrderMapper mapper;
    private OrderEntity order;

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
            log.info("API replied benchmark score: " + r.getScore() + " " + r.getScoreUnit() + " over " + r.getStatistics().getN() + " iterations");
        }
    }

    @Setup(Level.Trial)
    public void setup() {
        switch (this.type) {
            case "BeanMapper":
                this.mapper = new GeneralBeanMapper();
                break;
            case "BeanUtilsMapper":
                this.mapper = new BeanUtilsMapper();
                break;
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
