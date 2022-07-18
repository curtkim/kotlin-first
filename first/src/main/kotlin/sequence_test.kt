fun main(args: Array<String>) {
    val fruits = listOf("apple", "banana", "kiwi", "cherry")
    fruits.asSequence()
        .filter {
            println("checking the length of $it")
            it.length > 5
        }
        .map {
            println("mapping to the length of $it")
            "${it.length}"
        }
        .take(1)
        .forEach { println(it) }


    fruits.filter {
        println("checking the length of $it")
        it.length > 5
    }
        .map {
            println("mapping to the length of $it")
            "${it.length}"
        }
        .take(1)
        .forEach { println(it) }


    listOf(1, 2, 3).asSequence()
        .flatMap {
            println("flatmap " + it)
            listOfElementAndLength(it, it)
        }
        .forEach { println(it) }

    listOf(1, 2, 3)
        .flatMap {
            println("flatmap " + it)
            listOfElementAndLength(it, it)
        }
        .forEach { println(it) }

}