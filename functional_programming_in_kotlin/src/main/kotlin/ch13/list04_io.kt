package ch13

interface IO<A> {
    fun run(): A

    fun <B> map(f: (A)-> B) : IO<B> =
        object : IO<B>{
            override fun run(): B = f(this@IO.run())
        }

    fun <B> flatMap(f: (A)-> IO<B>) : IO<B> =
        object : IO<B>{
            override fun run(): B = f(this@IO.run()).run()
        }

    infix fun <B> assoc(io: IO<B>): IO<Pair<A, B>> =
        object : IO<Pair<A, B>> {
            override fun run(): Pair<A, B> = this@IO.run() to io.run()
        }



    companion object {
        fun <A> unit(a: ()->A) = object : IO<A> {
            override fun run(): A = a()
        }
        operator fun <A> invoke(a: ()-> A) = unit(a)
    }
}
