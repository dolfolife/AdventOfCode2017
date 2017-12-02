package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


internal class InverseCaptchaKtTest {


    @Test
    fun `1122 produces a sum of 3 (1 + 2) - Part 1`() {
        assertThat(3).isEqualTo("1122".inverseCaptchaPart1())
    }

    @Test
    fun `1111 produces 4 - Part 1`() {
        assertThat(4).isEqualTo("1111".inverseCaptchaPart1())
    }

    @Test
    fun `1234 produces 0 - Part 1`() {
        assertThat(0).isEqualTo("1234".inverseCaptchaPart1())
    }

    @Test
    fun `91212129 produces 9 - Part 1`() {
        assertThat(9).isEqualTo("91212129".inverseCaptchaPart1())
    }

    @Test
    fun `1212 produces 6 - Part 2`() {
        assertThat(6).isEqualTo("1212".inverseCaptchaPart2())
    }

    @Test
    fun `1221 produces 0 - Part 2`() {
        assertThat(0).isEqualTo("1221".inverseCaptchaPart2())
    }

    @Test
    fun `123425 produces 4 - Part 2`() {
        assertThat(4).isEqualTo("123425".inverseCaptchaPart2())
    }

    @Test
    fun `123123 produces 12 - Part 2`() {
        assertThat(12).isEqualTo("123123".inverseCaptchaPart2())
    }

    @Test
    fun `12131415 produces 4 - Part 2`() {
        assertThat(4).isEqualTo("12131415".inverseCaptchaPart2())
    }
}