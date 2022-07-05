import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun simple_flow(): Flow<Int> = flow {
   for(i in 1..3) {
       delay(100)
       emit(i)
   }
}

fun main(args : Array<String>) = runBlocking {
    launch {
        for(i in 1..3){
            println("I'm not blocked $i")
            delay(100)
        }
    }
    simple_flow().collect { println(it)}
}