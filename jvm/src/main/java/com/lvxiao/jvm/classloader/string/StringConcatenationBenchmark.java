package com.lvxiao.jvm.classloader.string;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * java基准测试:
 * http://www.pellegrino.link/2015/08/22/string-concatenation-with-java-8.html
 *
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/14 8:54 下午
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@Measurement(batchSize = 100000, iterations = 20)
@Warmup(batchSize = 100000, iterations = 10)
@Fork(5)
public class StringConcatenationBenchmark {
    private String string;
    private String stringConcat;
    private StringBuilder stringBuilder;
    private StringBuffer stringBuffer;

    @Setup(Level.Iteration)
    public void setup() {
        string = "";
        stringConcat = "";
        stringBuilder = new StringBuilder();
        stringBuffer = new StringBuffer();
    }

    @Benchmark
    public void stringConcatenation() {
        string += "some more data";
    }

    @Benchmark
    public void stringConcatConcatenation() {
        stringConcat = stringConcat.concat("some more data");
    }

    @Benchmark
    public void stringBuilderConcatenation() {
        stringBuilder.append("some more data");
    }

    @Benchmark
    public void stringBufferConcatenation() {
        stringBuffer.append("some more data");
    }

    public static void main(String[] args) {
        Options options = new OptionsBuilder()
                .include(StringConcatenationBenchmark.class.getSimpleName())
                .output("/Users/lvxiao/Downloads/benchmark.log")
                .build();
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
