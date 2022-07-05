fun simple(): Sequence<Int> = sequence {
    for(i in 1..3){
        Thread.sleep(100)
        yield(i)
    }
}

fun main(args : Array<String>) {
    simple().forEach { println(it) }
}