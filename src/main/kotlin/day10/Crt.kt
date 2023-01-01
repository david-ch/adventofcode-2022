package day10

private const val ROWS = 6
private const val COLS = 40

class Crt(private val pixels: List<MutableList<Boolean>>) {

    private var rayPositionRow = 0
    private var rayPositionCol = 0

    fun drawSprite(position: Int) {
        if (rayPositionCol in position - 1..position + 1) {
            pixels[rayPositionRow][rayPositionCol] = true
        }

        goToNextPosition()
    }

    private fun goToNextPosition() {
        if (rayPositionCol == COLS - 1) {
            rayPositionRow++
            rayPositionCol = 0
        }
        else {
            rayPositionCol++
        }
    }

    fun print(): String = pixels.joinToString("\n") { rowPixels ->
        rowPixels
            .map { if (it) '#' else '.' }
            .joinToString("")
    }
}

fun createScreen(): Crt {
    return Crt(
        List(ROWS) {
            MutableList(COLS) { false }
        }
    )
}