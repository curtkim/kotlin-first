package ch02

import org.junit.jupiter.api.Test


val <T> List<T>.tail: List<T>
    get() = drop(1)
val <T> List<T>.head: T
    get() = first()

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun go(x: A, xs: List<A>): Boolean {
        return if (xs.isEmpty()) true
        else if (!order(x, xs.head)) false
        else go(xs.head, xs.tail)
    }

    return aa.isEmpty() || go(aa.head, aa.tail)
}

class Ex02 {

    @Test
    fun `isSorted Int`(){
        isSorted(
            listOf(1, 2, 3)
        ) { a, b -> b > a }
    }

    @Test
    fun `isSorted String`(){
        isSorted(
            listOf("a", "b", "c")
        ) { a, b -> b > a }
    }
}