fun main(args: Array<String>) {
    val myLazyVal : String by lazy {
        println("just initialized")
        "My Lazy var"
    }

    println("Not yet initialised")
    println(myLazyVal)
}