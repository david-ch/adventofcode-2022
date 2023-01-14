package day11

import day11.math.Expression
import java.math.BigInteger
import java.math.BigInteger.ZERO

data class Monkey(
    val items: List<Item>,
    val operation: Expression,
    val logic: MonkeyLogic,
    val itemsInspected: BigInteger
) {

    fun playWithItems(manageWorry: ManageWorry): Monkey = copy(
        items = items.map { inspectItem(it, manageWorry) },
        itemsInspected = itemsInspected + BigInteger.valueOf(items.size.toLong())
    )

    fun throwItems(): Pair<Monkey, List<MonkeyThrowDecision>> = Pair(
        copy(items = listOf()),
        items.map { logic.decide(it) }
    )

    fun receive(item: Item): Monkey = copy(items = items + item)

    private fun inspectItem(item: Item, manageWorry: ManageWorry) = Item(
        manageWorry(operation.exec(item.worryLevel))
    )
}

data class MonkeyLogic(
    val testDivisor: BigInteger,
    private val trueMonkeyNum: Int,
    private val falseMonkeyNum: Int
) {

    fun decide(item: Item) =
        if (item.worryLevel % testDivisor == ZERO)
            MonkeyThrowDecision(item, trueMonkeyNum)
        else
            MonkeyThrowDecision(item, falseMonkeyNum)
}

data class MonkeyThrowDecision(val item: Item, val toMonkey: Int)