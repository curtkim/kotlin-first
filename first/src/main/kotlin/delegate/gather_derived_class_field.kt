package delegate

import kotlin.reflect.KProperty


data class Man(public var name: String?, public val age: Int)


abstract class Family {
    private val _members = arrayListOf<Man>()

    protected operator fun Man.provideDelegate(thisRef: Family, prop: KProperty<*>) : Man =
        also {
            if (it.name == null) {
                it.name = prop.name
            }
           _members.add(it)
        }
    protected operator fun Man.getValue(thisRef: Family, prop: KProperty<*>): Man = this


    fun printAll(){
        _members.forEach(::println)
    }
}

class KimsFamily : Family() {
    val father by Man(null, 45)
    val sun by Man(null, 20)
}

fun main(args : Array<String>){
    val kimsFamily = KimsFamily()
    kimsFamily.printAll()
}