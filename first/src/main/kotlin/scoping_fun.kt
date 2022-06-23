package my

data class Person(
    var name: String? = null,
    var age: Int? = null
)

fun main(args : Array<String>) {
    val person: Person = Person("bob", 12)
    println(person.name)
    println(person.age)

    // with
    with(person) {
        println(name)
        println(age)
    }

    // apply
    val peter = Person().apply {
        // apply 의 블록 에서는 오직 프로퍼티 만 사용합니다!
        name = "Peter"
        age = 18
    }
    println(peter.name)


}
