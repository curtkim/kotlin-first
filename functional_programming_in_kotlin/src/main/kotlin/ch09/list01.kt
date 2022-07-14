package ch09

import arrow.core.Either

interface Parsers<PE> {
    interface Parser<A>

    fun char(c: Char): Parser<Char>
    fun string(s: String): Parser<String>
    fun orString(s1: String, s2: String): Parser<String>

    fun <A> or(pa: Parser<A>, pb: Parser<A>): Parser<A>
    infix fun String.or(other: String) : Parser<String> = or(string(this), string(other))

    fun <A> listOfN(n: Int, p: Parser<A>): Parser<List<A>>

    fun <A> run(p: Parser<A>, input: String) : Either<PE, A>

}

fun main(args : Array<String>){

    run(listOfN(3, "ab" or "cad"), "ababab") == Either.Right("ababab")
}