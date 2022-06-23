import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

data class User(val name: String, val age: Int, val habits: List<String>)

class Collection_toMap {

    val user1 = User("John", 18, listOf("Hiking"))
    val user2 = User("Sara", 25, listOf("Chess"))
    val user3 = User("Dave", 34, listOf("Games"))

    @Test
    fun givenList_whenConvertToMap_thenResult() {
        val myList = listOf(user1, user2, user3)
        val myMap = myList.map { it.name to it.age }.toMap()

        assertTrue(myMap.get("John") == 18)
    }
}