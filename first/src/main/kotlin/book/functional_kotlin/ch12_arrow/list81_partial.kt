package book.functional_kotlin.ch12_arrow

//import arrow.core.PartialFunction


fun main(args: Array<String>) {
    val upper: (String?) -> String = { s:String? -> s!!.toUpperCase()}

    //val partialUpper: PartialFunction<String?, String> = PartialFunction(definedAt = {s -> s != null}, f = upper)
    //Partial function, it can't transform null
    listOf("one", "two", null, "four").map(upper).forEach(::println) //NPE
}
