package day11

import java.math.BigInteger
import java.math.BigInteger.ZERO

data class Item(val worryLevel: BigInteger) {

    init {
        check(worryLevel >= ZERO)
    }
}