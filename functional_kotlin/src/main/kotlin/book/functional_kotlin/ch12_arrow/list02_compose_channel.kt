package book.functional_kotlin.ch12_arrow

import arrow.core.andThen


data class Quote(val value: Double, val client: String, val item: String,
                 val quantity: Int)
data class Bill(val value: Double, val client: String)
data class PickingOrder(val item: String, val quantity: Int)


fun calculatePrice(quote: Quote) = Bill(quote.value * quote.quantity,
    quote.client) to PickingOrder(quote.item, quote.quantity)

fun filterBills(billAndOrder: Pair<Bill, PickingOrder>): Pair<Bill,
        PickingOrder>? {
    val (bill, _) = billAndOrder
    return if (bill.value >= 100) {
        billAndOrder
    } else {
        null
    }
}
fun warehouse(order: PickingOrder) {
    println("Processing order = $order")
}
fun accounting(bill: Bill) {
    println("processing = $bill")
}

fun splitter(billAndOrder: Pair<Bill, PickingOrder>?) {
    if (billAndOrder != null) {
        warehouse(billAndOrder.second)
        accounting(billAndOrder.first)
    }
}

fun main(args: Array<String>) {
    val salesSystem:(Quote) -> Unit = ::calculatePrice andThen ::filterBills andThen ::splitter

    salesSystem(Quote(20.0, "Foo", "Shoes", 1))
    salesSystem(Quote(20.0, "Bar", "Shoes", 200))
    salesSystem(Quote(2000.0, "Foo", "Motorbike", 1))
}
