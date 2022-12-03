package day3

typealias ItemIndex = Long

fun indexItems(items: String): ItemIndex =
    items.chars()
        .mapToLong { it.toLong() }
        .reduce(0L) { a, b -> a.addItem(Char(b.toInt())) }

fun ItemIndex.addItem(item: Char) =
    this or (1L shl item - 'A')

fun ItemIndex.containsItem(item: Char) =
    this and (1L shl item - 'A') > 0

fun ItemIndex.intersecion(anotherIndex: ItemIndex) =
    this and anotherIndex

fun ItemIndex.getSingleIndexedItem(): Char {
    var testBit = 1L
    var position = 1

    while (testBit and this == 0L) {
        testBit = testBit shl 1
        position++
    }

    return (position + 'A'.code - 1).toChar()
}