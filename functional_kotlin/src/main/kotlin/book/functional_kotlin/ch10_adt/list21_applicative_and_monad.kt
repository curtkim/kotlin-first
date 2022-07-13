package book.functional_kotlin.ch10_adt

fun <T, R> List<T>.ap(fab: List<(T) -> R>): List<R> = fab.flatMap { f -> this.map(f) }

fun main(args: Array<String>){
    val numbers = listOf(1,2,3)
    val functions = listOf<(Int)->Int>({i -> i*2}, {i-> i+3})
    val result = numbers.flatMap {
            number -> functions.map{ f-> f(number)}
    }.toString()
    println(result)

    val result2 = numbers.ap(functions).toString()
    println(result2)
}