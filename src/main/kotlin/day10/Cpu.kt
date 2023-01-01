package day10

data class Cpu(val x: Int)

fun Sequence<Command>.processUsing(cpu: Cpu) = sequence {
    var lastCpu = cpu

    yield(lastCpu)
    forEach {
        when (it) {
            is NoopCommand -> yield(lastCpu)
            is AddxCommand -> {
                yield(lastCpu)
                lastCpu = Cpu(lastCpu.x + it.operand)
                yield(lastCpu)
            }
        }
    }
}