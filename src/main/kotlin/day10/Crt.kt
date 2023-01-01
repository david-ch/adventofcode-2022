package day10

private const val ROWS = 6
private const val COLS = 40

class Crt(private val pixels: List<MutableList<Boolean>>) {

    private var rayPositionRow = 0
    private var rayPositionCol = 0

    fun draw(sprite: Sprite) {
        if (sprite.withinSprite(rayPositionCol)) {
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

data class Sprite(private val position: Int) {
    fun withinSprite(col: Int) = col in position - 1..position + 1
}