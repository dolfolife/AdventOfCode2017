package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class MemoryReallocationKtTest {

    @Test
    fun `it cycles blocks to distribute all the packages on the biggest block`() {
        val input = listOf(0,2,7,0)

        assertThat(whenIsTheNextCycle(input).result).isEqualTo(5)
    }

    @Test
    fun `second part - find the second cycle of occurrence`() {
        val input = listOf(0,2,7,0)
        val solution1 = whenIsTheNextCycle(input)
        assertThat(whenIsTheNextCycle(solution1.found).result).isEqualTo(4)
    }
}