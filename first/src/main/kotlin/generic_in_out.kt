
// constraint
fun <T : Comparable<T>> greaterThan(lhs: T, rhs: T): Boolean {
    return lhs > rhs
}

// multiple upper bounds
fun <T> sort(xs: List<T>) where T : CharSequence, T : Comparable<T> {
    // sort the collection in place
}

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return value
    }
}

class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

fun main(args : Array<String>){
    // String -> Any
    val parameterizedProducer = ParameterizedProducer("string")
    val ref1: ParameterizedProducer<Any> = parameterizedProducer
    assert(ref1 is ParameterizedProducer<Any>)


    // Number -> Double
    val parameterizedConsumer = ParameterizedConsumer<Number>()
    val ref2: ParameterizedConsumer<Double> = parameterizedConsumer
    assert(ref2 is ParameterizedConsumer<Double>)
}