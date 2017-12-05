package advent.of.code



import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
internal class MazeOfTwistyTrampolinesKtTest {

    @Test
    fun `it calculates the number of steps needed to get out the maze`() {
        val maze = mutableListOf(0, 3, 0, 1, -3)

        assertThat(calculateMaze(maze)).isEqualTo(10)
    }
}