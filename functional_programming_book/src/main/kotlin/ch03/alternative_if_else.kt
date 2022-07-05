package ch03

import kotlin.random.Random


fun main(args: Array<String>) {
    val x = Random.nextInt(-10, 10)
    val y: String =
        when {
            x == 0 -> "x is zero"
            x > 0 -> "x is positive"
            else -> "x is nagative"
        }

    println(x)
    println(y)
}
