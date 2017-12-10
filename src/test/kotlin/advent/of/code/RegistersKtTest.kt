package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

internal class RegistersKtTest {
    private val testFile = "src/test/resources/instructions.txt"

    private lateinit var registries: Set<Registry>
    private var  maxValue: Int = 0

    @Before
    fun setUp() {
        val (registries, maxValue) = calculateRegisters(testFile)
        this.registries = registries
        this.maxValue = maxValue
    }

    @Test
    fun `it calculates the max value of all register after instructions`() {
        assertThat(registries.maxBy { it.value }?.value).isEqualTo(1)
    }

    @Test
    fun `calculates the max value needed to allocate in registries`() {
        assertThat(maxValue).isEqualTo(10)
    }
}