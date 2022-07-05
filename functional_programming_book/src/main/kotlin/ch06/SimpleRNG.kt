package ch06

interface RNG {
    fun nextInt(): Pair<Int, RNG>
}

data class SimpleRNG(val seed: Long) : RNG {
    override fun nextInt(): Pair<Int, RNG> {
        val newSeed =
            (seed * 0x5DEECE66DL + 0xBL) and
                    0xFFFFFFFFFFFFL
        val nextRNG = SimpleRNG(newSeed)
        val n = (newSeed ushr 16).toInt()
        return n to nextRNG
    }
}
fun main(args: Array<String>) {
    var rng = SimpleRNG(42)
    val (n1, rng2) = rng.nextInt()
    println("n1:$n1; rng2:$rng2")       // 16159453

    val (n2, rng3) = rng2.nextInt()
    println("n2:$n2; rng3:$rng3")       // -1281479697
}
