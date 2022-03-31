package easy.graph

class Solution200 {
    /**
     * given a [grid] of '1's (land) and '0's (water) find the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     */
    val visited = mutableSetOf<Pair<Int, Int>>()
    fun numIslands(grid: Array<CharArray>): Int {
        var numIslands = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j)
                    numIslands++
                }
            }
        }
        return numIslands
    }

    private fun visit(grid: Array<CharArray>, i: Int, j: Int) {
        visited.add(Pair(i, j))
        grid[i][j] = '0'
        getVerticesToVisit(grid, i, j).forEach {
            if (it !in visited) visit(grid, it.first, it.second)
        }

    }

    private fun getVerticesToVisit(grid: Array<CharArray>, i: Int, j: Int): List<Pair<Int, Int>> {
        val points = mutableListOf<Pair<Int, Int>>()
        if (i + 1 < grid.size && grid[i + 1][j] == '1') points.add(Pair(i + 1, j))
        if (i - 1 >= 0 && grid[i - 1][j] == '1') points.add(Pair(i - 1, j))
        if (j + 1 < grid.first().size && grid[i][j + 1] == '1') points.add(Pair(i, j + 1))
        if (j - 1 >= 0 && grid[i][j - 1] == '1') points.add(Pair(i, j - 1))
        return points
    }
}

fun main() {
    val testCase = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    println(Solution200().numIslands(testCase))
}