import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.Image

val sourceImage = Image()

lateinit var context: CanvasRenderingContext2D

fun main() {
    window.onload = {
        val canvas: HTMLCanvasElement = document.getElementById("canvas") as HTMLCanvasElement
        context = canvas.getContext("2d") as CanvasRenderingContext2D
        context.scale(3.0, 3.0)
        context.fillStyle = "#7974FF"
        context.fillRect(0.0, 0.0, 762.0, 720.0)

        sourceImage.src = TILES_IMAGE
        sourceImage.onload = {
            render()
        }
        Unit
    }
}

const val CELL_SIZE = 16.0

fun drawSprite(sprite: Sprite, x: Double, y: Double) {
    context.drawImage(
        sourceImage,
        sx = sprite.si * CELL_SIZE + 1 / 3.0,
        sy = sprite.sj * CELL_SIZE + 1 / 3.0,
        sw = sprite.w * CELL_SIZE - 2 / 3.0,
        sh = sprite.h * CELL_SIZE - 2 / 3.0,
        dw = sprite.w * CELL_SIZE,
        dh = sprite.h * CELL_SIZE,
        dx = x * CELL_SIZE,
        //dy = y * CELL_SIZE,
        dy = (13 - y - sprite.h) * CELL_SIZE,
    )
}

fun drawSprite(sprite: Sprite, i: Int, j: Int) {
    drawSprite(sprite, i.toDouble(), j.toDouble())
}

//fun drawCloud(i: Int, j: Int) {
//    drawSprite(cloudSprite, i, j)
//}

fun drawCloud(i: Int, j: Int, length: Int) {
    drawSprite(cloudSprite[0], i = i, j = j) // left side
    for (n in i + 1..i + 1 + length) {
        drawSprite(cloudSprite[1], i = n, j = j) // middle
    }
    drawSprite(cloudSprite[2], i = i + length + 2, j = j) // right side
}

fun drawFloor() {
    var i: Int
    var j: Int
    for (j in -1 downTo -2) {
        for (i in 0..15) {
            drawSprite(floorSprite, i, j)
        }
    }
}

fun drawBush(i: Int, length: Int) {
    drawSprite(bushSprites[0], i = i, j = 0) // left side
    for (n in i + 1..i + length - 2) {
        drawSprite(bushSprites[1], i = n, j = 0) // middle
    }
    drawSprite(bushSprites[2], i = i + length - 1, j = 0) // right side
}

fun drawHillSection(i: Int, j: Int, size: Int) {
    for (cell in 1..size) {
        when (cell) {
            1 -> drawSprite(hillSprites[0], i, j)
            size -> drawSprite(hillSprites[2], i + size - 1, j)
            else -> drawSprite(hillSprites[4], i + cell - 1, j)
        }
    }
}

fun drawHill(i: Int, height: Int) {
    for (j in 0..<height) {
        val size = 3 + height - j * 2 // calculate section size
        drawHillSection(i + j, j, size)
    }
    drawSprite(hillSprites[1], i = i + height, j = height) // top
}

fun render() {
    drawCloud(7, 8, 2)
    drawFloor()
    val lengthBush = 5
    drawBush(15 - lengthBush + 1, lengthBush)
    //drawHillSection(1, 3, 5)
    drawHill(0, 2)
}