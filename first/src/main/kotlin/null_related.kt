// https://tourspace.tistory.com/114

fun strlenSafe(str: String?): Int =
    if(str != null) str.length else 0

// by Elvis operator
fun strlenSafe2(str: String?): Int =
    str?.length ?: 0


fun printUpperCase(str: String?){
    // ?. 왼쪽항이 null이면 바로 null을 반환한다
    val upper: String? = str?.uppercase()
    println(upper)
}

data class Employee(
    val name: String,
    val manager: Employee?
)
fun managerName(employee: Employee): String? = employee.manager?.name


fun ignoreNull(str: String?) {
    // !! not null을 선언함
    val s: String = str!!   // throw NullPointerException
    println(s.length)
}

fun String?.isNullOrBlank1(): Boolean =
    this == null || this.isBlank()

fun verifyUserInput(input: String?) {
    // NPE이 발생하지 않는다.
    if (input.isNullOrBlank1()) {
        println("Please fill in the required fields")
    }
}

// generic
fun <T: Any> printHashCode(t: T) {
    println(t.hashCode())
}

fun main(args : Array<String>) {
    val x : String? = null
    println(strlenSafe(x))
    println(strlenSafe("123"))
    println(strlenSafe2(x))

    printUpperCase("abc")
    printUpperCase(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    verifyUserInput(null)

    ignoreNull("abc")
    ignoreNull(null)

    // null을 허락하지 않는다.
    //printHashCode(null)
}