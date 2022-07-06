package book.functional_kotlin.ch12_arrow

//import arrow.syntax.function.pipe


fun main(args: Array<String>) {

    val q = Quote(20.0, "Foo", "Shoes", 10)
    splitter(filterBills(calculatePrice(q)))

    //q pipe ::calculatePrice pipe ::filterBills pipe ::splitter
}
