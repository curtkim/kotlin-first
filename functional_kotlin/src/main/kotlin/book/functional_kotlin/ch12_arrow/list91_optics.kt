package book.functional_kotlin.ch12_arrow

typealias GB = Int
data class Memory(val size: GB)
data class MotherBoard(val brand: String, val memory: Memory)
data class Laptop(val price: Double, val motherBoard: MotherBoard)

fun main(args: Array<String>) {
    val laptopX8 = Laptop(500.0, MotherBoard("X", Memory(8)))

    val laptopX16 = laptopX8.copy(
        price = 780.0,
        motherBoard = laptopX8.motherBoard.copy(
            memory = laptopX8.motherBoard.memory.copy(
                size = laptopX8.motherBoard.memory.size*2
            )
        )
    )

    println("laptopX16 = $laptopX16")
}
