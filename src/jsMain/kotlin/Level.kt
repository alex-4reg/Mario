class Level {

    private var entities = setOf<Entity>()

    fun render() {
        for (entity in entities) {
            drawSprite(entity.sprite, entity.x, entity.y)
        }
    }

    fun addFloor() {
        for (j in -1 downTo -2) {
            for (i in 0..15) {
                entities += Entity(i, j, floorSprite)
            }
        }
    }

    fun addBush(i: Int, size: Int) {
        entities += Entity(i, 0, bushSprites[0])
        for (n in i + 1..i + size - 2) {
            entities += Entity(n, 0, bushSprites[1]) // middle
        }
        entities += Entity(i + size - 1, 0, bushSprites[2]) // right side
    }

    fun addCloud(i: Int, j: Int, size: Int) {
        entities += Entity(i, j, cloudSprite[0]) // left side
        for (n in i + 1..i + 1 + size) {
            entities += Entity(n, j, cloudSprite[1]) // middle
        }
        entities += Entity(i + size + 2, j, cloudSprite[2]) // right side
    }

    private fun drawHillSection(i: Int, j: Int, size: Int) {
        for (cell in 1..size) {
            when (cell) {
                1 -> entities += Entity(i, j, hillSprites[0])
                size -> entities += Entity(i + size - 1, j, hillSprites[2])
                else -> entities += Entity(i + cell - 1, j, hillSprites[4])
            }
        }
    }

    fun addHill(i: Int, height: Int) {
        for (j in 0..<height) {
            val size = 3 + height - j * 2 // calculate section size
            drawHillSection(i + j, j, size)
        }
        drawSprite(hillSprites[1], i = i + height, j = height) // top
    }
}