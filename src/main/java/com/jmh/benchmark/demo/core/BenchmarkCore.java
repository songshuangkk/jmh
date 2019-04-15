package com.jmh.benchmark.demo.core;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class BenchmarkCore {

  @Benchmark
  public int sleepAWhile() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      // ignore
    }
    return 0;
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(BenchmarkCore.class.getSimpleName())
        .forks(1)
        .warmupIterations(5)
        .measurementIterations(5)
        .build();

    new Runner(opt).run();
  }
}
