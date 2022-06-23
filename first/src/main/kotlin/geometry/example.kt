package geometry.example

import geometry.shape.createRandomRectangle

fun main(args : Array<String>){
    val rect = createRandomRectangle()
    println(rect.isSqure)
    println(rect.height)
    println(rect.width)

}