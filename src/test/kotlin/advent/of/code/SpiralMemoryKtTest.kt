package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class SpiralMemoryKtTest {

    @Test
    fun `Data from square 1 is carried 0 step`() {
        assertThat(calculateStepsFor(1)).isEqualTo(0)
    }

    @Test
    fun `Data from square 12 is carried 3 steps`() {
        assertThat(calculateStepsFor(12)).isEqualTo(3)
    }

    @Test
    fun `Data from square 17 is carried 4 steps`() {
        assertThat(calculateStepsFor(17)).isEqualTo(4)
    }

    @Test
    fun `Data from square 22 is carried 3 steps`() {
        assertThat(calculateStepsFor(22)).isEqualTo(3)
    }

    @Test
    fun `Data from square 23 is carried only 2 steps`() {
        assertThat(calculateStepsFor(23)).isEqualTo(2)
    }

    @Test
    fun `Data from square 1024 must be carried 31 steps`() {
        assertThat(calculateStepsFor(1024)).isEqualTo(31)
    }
}