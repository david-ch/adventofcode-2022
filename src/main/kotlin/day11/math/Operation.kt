package day11.math

import java.math.BigInteger

interface Operation {

    fun exec(left: BigInteger, right: BigInteger): BigInteger
}

class Multiplication: Operation {

    override fun exec(left: BigInteger, right: BigInteger): BigInteger = left * right
}

class Sum: Operation {

    override fun exec(left: BigInteger, right: BigInteger): BigInteger = left + right
}