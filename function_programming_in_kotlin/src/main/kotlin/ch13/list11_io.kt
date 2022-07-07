package ch13


interface NaiveIO{
    fun run(): Unit
}

fun stdout(msg: String): NaiveIO =
    object : NaiveIO{
        override fun run() {
            println(msg)
        }
    }

fun contest(p1: Player, p2: Player) : NaiveIO =
    stdout(winnerMsg(winner(p1, p2)))

fun main(args : Array<String>){
    contest(Player("a", 1), Player("b", 2))
        .run()
}