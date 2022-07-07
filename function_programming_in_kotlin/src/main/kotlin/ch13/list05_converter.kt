package ch13

fun main(args: Array<String>) {

    fun fahrenheitToCelsius(df: Double): Double {
        return df
    }

    fun stdin(): IO<String> = IO { readLine().orEmpty() }
    fun stdout(msg: String): IO<Unit> = IO { println(msg) }

    fun converter(): IO<Unit> =
        stdout("Enter: ").flatMap {
            stdin().map { it.toDouble() }.flatMap { df ->
                stdout("Degreee Celsius: ${fahrenheitToCelsius(df)}")
            }
        }

    converter().run()

    val echo: IO<Unit> = stdin().flatMap(::stdout)
    val readInt: IO<Int> = stdin().map { it.toInt() }
    var readInts :IO<Pair<Int, Int>> = readInt assoc readInt

}