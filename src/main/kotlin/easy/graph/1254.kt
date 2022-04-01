package easy.graph

class Solution1254 {
    private val land = 0
    private val water = 1
    fun closedIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val numRows = grid.size;
        val numCols = grid[0].size

        fun turnIslandToWater(x: Int, y: Int) {
            if (x < 0 || x >= numRows || y < 0 || y >= numCols || grid[x][y] != land) return
            grid[x][y] = water
            turnIslandToWater(x + 1, y)
            turnIslandToWater(x - 1, y)
            turnIslandToWater(x, y + 1)
            turnIslandToWater(x, y - 1)
        }

        for (i in 0 until numRows) {
            if (grid[i][0] == land) turnIslandToWater(i, 0)
            if (grid[i][numCols - 1] == land) turnIslandToWater(i, numCols - 1)
        }

        for (i in 0 until numCols) {
            if (grid[0][i] == land) turnIslandToWater(0, i)
            if (grid[numRows - 1][i] == land) turnIslandToWater(numRows - 1, i)
        }

        var nums = 0
        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                if (grid[i][j] == land) {
                    turnIslandToWater(i, j)
                    nums++
                }
            }
        }
        return nums
    }
}

fun main() {
    val testCase = arrayOf(
        intArrayOf(0, 0, 1, 1, 0, 1, 0, 0, 1, 0),
        intArrayOf(1, 1, 0, 1, 1, 0, 1, 1, 1, 0),
        intArrayOf(1, 0, 1, 1, 1, 0, 0, 1, 1, 0),
        intArrayOf(0, 1, 1, 0, 0, 0, 0, 1, 0, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 1, 1, 1, 0),
        intArrayOf(0, 1, 0, 1, 0, 1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1, 1, 0, 0, 0, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 0, 0, 1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 0)
    )
    println(Solution1254().closedIsland(testCase))
}

