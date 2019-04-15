# jmh


### JMH 分析结果
#### Mode
Mode 表示 JMH 进行 Benchmark 时所使用的模式。通常是测量的维度不同，或是测量的方式不同。目前 JMH 共有四种模式：

* Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
* AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
* SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
* SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。

---
通过result进行查看接口平均耗时。

Warmup 是指在实际进行 benchmark 前先进行预热的行为。为什么需要预热？因为 JVM 的 JIT 机制的存在，如果某个函数被调用多次之后，JVM 会尝试将其编译成为机器码从而提高执行速度。所以为了让 benchmark 的结果更加接近真实情况就需要进行预热。