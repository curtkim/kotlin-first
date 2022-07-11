import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

interface Dao {
    suspend fun getValue(key: String) : String
}

class SyncDao : Dao{
    override suspend fun getValue(key: String): String {
        return "sync $key"
    }
}
class AsyncDao : Dao {
    override suspend fun getValue(key: String): String {
        delay(1)
        return "async $key"
    }
}

fun main(args : Array<String>){
    val syncDao = SyncDao()
    val asyncDao = AsyncDao()

    runBlocking {
        println(syncDao.getValue("myid"))
        println(asyncDao.getValue("myid"))
    }
}