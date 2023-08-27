class Sprites {
    data class Sprite(var src: String, val si: Int, val sj: Int, val w: Int = 1, val h: Int = 1)

    companion object {
        const val TILES_IMAGE = "sprites/tiles.png"
    }
}