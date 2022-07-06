import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

data class Item(val name:String)

interface MyObject {
    suspend fun getItem() : Item
}

class MyObjectImpl(private val item:Item) : MyObject {
    override suspend fun getItem(): Item {
        return item
    }
}

suspend fun loadItem(id: Int) : Item{
    delay(100)
    return Item("${id}_item")
}

class LazyMyObjectImpl(private val id: Int) : MyObject{
    override suspend fun getItem(): Item {
        return loadItem(id)
    }
}

fun main(args : Array<String>) = runBlocking {
    val item = Item("my_item")
    println(MyObjectImpl(item).getItem())

    println(LazyMyObjectImpl(1).getItem())
}
