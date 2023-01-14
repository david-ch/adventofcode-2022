package day11

import java.math.BigInteger


typealias ManageWorry = (BigInteger) -> BigInteger

fun reliefAfterEachTurn(reliefFactor: BigInteger): ManageWorry =
    { worryLevel -> worryLevel / reliefFactor }

fun manageRidiculousLevelsOfWorry(modulo: BigInteger): ManageWorry =
    { worryLevel -> worryLevel.mod(modulo) }