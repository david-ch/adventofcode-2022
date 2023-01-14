package day11.math

import java.math.BigInteger

interface Operand {
    fun value(oldValue: BigInteger): BigInteger
}

data class Const(private val value: BigInteger): Operand {
    override fun value(oldValue: BigInteger) = value
}

class OldValue: Operand {
    override fun value(oldValue: BigInteger) = oldValue
}