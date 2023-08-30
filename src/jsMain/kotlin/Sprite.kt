data class Sprite(var src: String, val si: Int, val sj: Int, val w: Int = 1, val h: Int = 1)

const val TILES_IMAGE = "sprites/tiles.png"

//val cloudSprite = Sprite(TILES_IMAGE, si = 0, sj = 20, w = 3, h = 2)

val cloudSprite = listOf(
    Sprite(TILES_IMAGE, si = 0, sj = 20, w = 1, h = 2),
    Sprite(TILES_IMAGE, si = 1, sj = 20, w = 1, h = 2),
    Sprite(TILES_IMAGE, si = 2, sj = 20, w = 1, h = 2),
)

val floorSprite = Sprite(TILES_IMAGE, si = 0, sj = 0, w = 1, h = 1)

val bushSprites = listOf(
    Sprite(TILES_IMAGE, si = 11, sj = 9),
    Sprite(TILES_IMAGE, si = 12, sj = 9),
    Sprite(TILES_IMAGE, si = 13, sj = 9),
)

val hillSprites = listOf(
    Sprite(TILES_IMAGE, si = 8, sj = 10), // Left slope
    Sprite(TILES_IMAGE, si = 9, sj = 10), // Peak
    Sprite(TILES_IMAGE, si = 10, sj = 10), // Right slope
    Sprite(TILES_IMAGE, si = 8, sj = 11), // Left spotted part
    Sprite(TILES_IMAGE, si = 9, sj = 11), // Clean part
    Sprite(TILES_IMAGE, si = 10, sj = 11), // Right spotted part
)





