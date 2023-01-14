package day11.math

import java.math.BigInteger

data class Expression(
    private val left: Operand,
    private val right: Operand,
    private val operation: Operation
) {
    fun exec(oldValue: BigInteger) = operation.exec(left.value(oldValue), right.value(oldValue))
}
