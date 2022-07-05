package ch02

import kotlin.math.abs

fun factorial(i: Int): Int {
    fun go(n: Int): Int {
        if (n <= 0)
            return 1
        return n * go(n - 1)
    }
    return go(i)
}

fun fib(i: Int): Int {
    fun go(n: Int): Int {
        return if (n <= 0)
            0
        else if (n == 1)
            1
        else
            go(n - 1) + go(n - 2)
    }
    return go(i)
}

fun formatResult(name: String, n: Int, f: (Int) -> Int) = "The %s of %d is %d.".format(name, n, f(n))

fun main(args: Array<String>) {
    //println(factorial(5))
    //println(fib(3))
    println(formatResult("factorial", 7, ::factorial))
    println(formatResult("absolute value", -42, ::abs))
}
