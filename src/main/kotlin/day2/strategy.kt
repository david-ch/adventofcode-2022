package day2

import day2.Outcome.*

fun selectMine(their: Shape, desiredOutcome: Outcome): Shape = when (desiredOutcome) {
    LOSE -> their.loser()
    DRAW -> their
    WIN -> their.winner()
}