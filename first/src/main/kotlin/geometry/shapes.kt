package geometry.shape

import java.util.Random

class Rectangle(val height: Int, val width: Int) {
    val isSqure: Boolean
        get() = height == width
}

fun createRandomRectangle() : Rectangle {
    var random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
