package day2

import day2.Outcome.*
import day2.Shape.*

fun play(their: Shape, mine: Shape): Outcome = when (mine) {
    their -> DRAW
    their.winner() -> WIN
    else -> LOSE
}

private val loserWinner = mapOf(
    ROCK to PAPER,
    PAPER to SCISSORS,
    SCISSORS to ROCK
)

private val winnerLoser = loserWinner.entries.associate { (k, v) -> v to k }

fun Shape.winner(): Shape = loserWinner[this]!!

fun Shape.loser(): Shape = winnerLoser[this]!!