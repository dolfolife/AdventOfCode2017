package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

internal class RecursiveCircusKtTest {
    lateinit var programs: List<Program>

    @Before
    fun setUp() {
        val testFile = "src/test/resources/RecursiveCircus.txt"
        programs = calculateRoots(testFile)
    }

    @Test
    fun `it calculate the root of the programs`() {
        val rootProgram = programs.filter { it.root }
        assertThat(rootProgram.size).isEqualTo(1)
        assertThat(rootProgram.first().name).isEqualTo("tknk")
    }

    @Test
    fun `calculates delta to make the tree balance`() {
        assertThat(calculateBalanceWeight(programs)).isEqualTo(60)
    }
}