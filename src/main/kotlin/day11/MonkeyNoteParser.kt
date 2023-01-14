package day11

import day11.math.*
import java.lang.Integer.parseInt
import java.lang.Long.parseLong
import java.math.BigInteger
import java.math.BigInteger.ZERO

private const val MONKEY_DESCRIPTION_NOTE_LINES_NUM = 7
private const val ITEMS_LINE_STARTER = "  Starting items: "
private const val OPERATION_LINE_STARTER = "  Operation: new = "
private const val LOGIC_DIVISOR_LINE_STARTER = "  Test: divisible by "
private const val LOGIC_TRUE_MONKEY_LINE_STARTER = "    If true: throw to monkey "
private const val LOGIC_FALSE_MONKEY_LINE_STARTER = "    If false: throw to monkey "

fun Sequence<String>.parseMonkeyNotes() = this
    .chunked(MONKEY_DESCRIPTION_NOTE_LINES_NUM)
    .map { parseMonkeyNote(it) }

private fun parseMonkeyNote(lines: List<String>) = Monkey(
    parseItems(lines[1]),
    parseExpression(lines[2]),
    parseMonkeyLogic(lines),
    itemsInspected = ZERO
)

private fun parseItems(line: String): List<Item> = line
    .substring(ITEMS_LINE_STARTER.length)
    .split(",")
    .map { Item(BigInteger.valueOf(parseLong(it.trim()))) }

private fun parseExpression(line: String): Expression = line
    .substring(OPERATION_LINE_STARTER.length)
    .split(" ")
    .let {
        Expression(
            parseOperand(it[0]),
            parseOperand(it[2]),
            parseOperation(it[1])
        )
    }

private fun parseOperand(str: String): Operand = when (str) {
    "old" -> OldValue()
    else -> Const(BigInteger.valueOf(parseLong(str)))
}

private fun parseOperation(str: String): Operation = when (str) {
    "*" -> Multiplication()
    "+" -> Sum()
    else -> throw IllegalArgumentException("Not supported operation $str")
}

private fun parseMonkeyLogic(lines: List<String>) = MonkeyLogic(
    BigInteger.valueOf(parseLong(lines[3].substring(LOGIC_DIVISOR_LINE_STARTER.length))),
    parseInt(lines[4].substring(LOGIC_TRUE_MONKEY_LINE_STARTER.length)),
    parseInt(lines[5].substring(LOGIC_FALSE_MONKEY_LINE_STARTER.length)),
)