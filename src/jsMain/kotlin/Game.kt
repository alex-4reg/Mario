import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.Image

fun main() {
    window.onload = {
        val canvas = document.getElementById("canvas") as HTMLCanvasElement
        val context = canvas.getContext("2d") as CanvasRenderingContext2D
        context.fillStyle = "#7974FF"
        context.fillRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())

        val image = Image()
        image.src = "mario.jpg"
        image.onload = {
            val imageWidth = image.width
            val imageHeight = image.height

            val canvasWidth = canvas.width.toDouble()
            val canvasHeight = canvas.height.toDouble()

            val imageX = (canvasWidth - imageWidth) / 2
            val imageY = (canvasHeight - imageHeight) / 2

            //println("$imageX\n$imageY")

            context.drawImage(image, imageX, imageY)
            //context.drawImage(image, 0.0, 0.0)
        }
        Unit
    }
}