package advent.of.code


import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class HighEntropyPassphrasesKtTest {

    @Test
    fun `valid passphrases filters bad passphrases`() {

        val listOfPassphrases = listOf(
                listOf("aa", "bb", "cc", "dd", "ee"),
                listOf("aa", "bb", "cc", "dd", "aa"),
                listOf("aa", "bb", "cc", "dd", "aaa")
        )

        assertThat(listOfPassphrases.findValidPassphrases().size).isEqualTo(2)
    }

    @Test
    fun `valid passphrases filters bad passphrases including anagrams`() {

        val listOfPassphrases = listOf(
                listOf("abcde", "fghij"),
                listOf("abcde", "xyz", "ecdab"),
                listOf("a", "ab", "abc", "abd", "abf", "abj"),
                listOf("iiii", "oiii", "ooii", "oooi","oooo"),
                listOf("oiii", "ioii", "iioi", "iiio")
        )

        assertThat(listOfPassphrases.findValidPassphrases().size).isEqualTo(3)
    }
}