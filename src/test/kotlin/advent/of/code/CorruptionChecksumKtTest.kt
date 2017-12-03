package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CorruptionChecksumKtTest {

    @Test
    fun `For each row, determine the difference between the largest value and the smallest value`() {
        val input = listOf<Collection<Int>>(
                listOf(5,1,9,5),
                listOf(7,5,3),
                listOf(2,4,6,8)
        )

        assertThat(18).isEqualTo(input.checkSum())
    }

    @Test
    fun `find the only two numbers in each row where one evenly divides the other`() {
        val input = listOf<Collection<Int>>(
                listOf(5,9,2,8),
                listOf(9,4,7,3),
                listOf(3,8,6,5)
        )

        assertThat(9).isEqualTo(input.checkEvenSum())
    }
}