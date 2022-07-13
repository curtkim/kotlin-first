package ch13

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

fun winner(p1: Player, p2: Player): Option<Player> =
    when {
        p1.score > p2.score -> Some(p1)
        p1.score < p2.score -> Some(p2)
        else -> None
    }

fun winnerMsg(op: Option<Player>): String =
    when (op) {
        is Some -> "${op.t.name} is the winner"
        is None -> "It's a draw"
    }