package ch13

data class Player(val name: String, val score: Int)

fun contest_with_sideeffect(p1: Player, p2: Player): Unit =
    when {
        p1.score > p2.score ->
            println("${p1.name} is the winner!")
        p1.score < p2.score ->
            println("${p2.name} is the winner!")
        else ->
            println("It's a draw!")
    }