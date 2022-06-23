import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun whenAdd1and2_thenAnswerIs3(){
        Assertions.assertEquals(3, 1+2);
    }

    @Test
    fun `Adding 1 and 3 should be equal to 4`() {
        Assertions.assertEquals(4, 1+ 3)
    }

    @Test
    fun `0으로 나누면 DivideByZeroException 예외를 던져야 한다`() {
        // TODO
    }

    @Test
    fun `isEmpty should return true for empty lists`() {
        val list = listOf<String>()
        Assertions.assertTrue(list::isEmpty)
    }
}