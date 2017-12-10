package advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class StreamProcessingKtTest {

    @Test
    fun `calculates scores of streams`(){
        assertThat(calculateStreamScore("{}").first).isEqualTo(1)
        assertThat(calculateStreamScore("{{{}}}").first).isEqualTo(6)
        assertThat(calculateStreamScore("{{},{}}").first).isEqualTo(5)
        assertThat(calculateStreamScore("{{{},{},{{}}}}").first).isEqualTo(16)
        assertThat(calculateStreamScore("{<a>,<a>,<a>,<a>}").first).isEqualTo(1)
        assertThat(calculateStreamScore("{{<ab>},{<ab>},{<ab>},{<ab>}}").first).isEqualTo(9)
        assertThat(calculateStreamScore("{{<!!>},{<!!>},{<!!>},{<!!>}}").first).isEqualTo(9)
        assertThat(calculateStreamScore("{{<a!>},{<a!>},{<a!>},{<ab>}}").first).isEqualTo(3)
    }

    @Test
    fun `calculate garbage space`() {
        assertThat(calculateStreamScore("<>").second).isEqualTo(0)
        assertThat(calculateStreamScore("<random characters>").second).isEqualTo(17)
        assertThat(calculateStreamScore("<<<<>").second).isEqualTo(3)
        assertThat(calculateStreamScore("<{!>}>").second).isEqualTo(2)
        assertThat(calculateStreamScore("<!!>").second).isEqualTo(0)
        assertThat(calculateStreamScore("<!!!>>").second).isEqualTo(0)
        assertThat(calculateStreamScore("<{o\"i!a,<{i<a>").second).isEqualTo(10)
    }
}