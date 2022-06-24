import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CollectionTest {

    @Test
    fun `slice success`() {
        val theList = listOf("one", "two", "three")
        val resultList = theList.slice(1..2)

        assertEquals(listOf("two", "three"), resultList)
    }

    @Test
    fun `drop success`() {
        val theList = listOf("one", "two", "three", "four")
        val resultList = theList.drop(2)

        assertEquals(2, resultList.size)
        assertFalse(resultList.contains("one"))
        assertFalse(resultList.contains("two"))
    }

    @Test
    fun `dropWhile success`() {
        val theList = listOf("one", "two", "three", "four")
        val resultList = theList.dropWhile{ it.length < 4 }

        assertEquals(2, resultList.size)
        assertFalse(resultList.contains("one"))
        assertFalse(resultList.contains("two"))
    }
    @Test
    fun `groupBy success`() {
        val theList = listOf( 2, 3, 5, 6)
        val resultMap = theList.groupBy{ it % 3}

        assertEquals(2, resultMap.size)
        assertFalse(resultMap.contains(1))
        assertEquals(2, resultMap[0]!!.size)
        assertEquals(2, resultMap[2]!!.size)
    }

    @Test
    fun `chunked success`() {
        val theList = listOf(1, 2, 3, 4, 5)
        val chunked = theList.chunked(2)

        assertThat(chunked.size).isEqualTo(3)
        assertThat(chunked.first()).contains(1, 2)
        assertThat(chunked[1]).contains(3, 4)
        assertThat(chunked.last()).contains(5)
    }

    @Test
    fun `chunked joinToString success`() {
        val theList = listOf(1, 2, 3, 4, 5)
        val chunked = theList.chunked(3) { it.joinToString(", ") }

        assertThat(chunked.size).isEqualTo(2)
        assertThat(chunked.first()).isEqualTo("1, 2, 3")
        assertThat(chunked.last()).isEqualTo("4, 5")
    }

    @Test
    fun whenApplyingWindowed_thenShouldCreateSlidingWindowsOfElements() {
        val theList = (1..6).toList()
        val windowed = theList.windowed(3)

        assertThat(windowed.size).isEqualTo(4)
        assertEquals(windowed.first(), listOf(1, 2, 3))
        assertEquals(windowed[1], listOf(2, 3, 4))
        assertThat(windowed[2]).contains(3, 4, 5)
        assertThat(windowed.last()).contains(4, 5, 6)
    }

    @Test
    fun `map iterate`() {
        val theMap = mapOf(1 to "one", 2 to "two", 3 to "three")
        val theMutableMap = mutableMapOf(1 to "one", 2 to "two", 3 to "three")

        theMap.forEach { (key, value) ->
            print("$key : $value")
        }
    }

    @Test
    fun first(){
        assertEquals(4, (1..6).first { it > 3})
        assertNull((1..6).firstOrNull() { it > 10})
    }
}