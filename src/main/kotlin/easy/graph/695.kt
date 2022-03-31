package easy.graph

import kotlin.math.max

class Solution695 {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea: Int = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) maxArea = max(bfs(grid, i, j), maxArea)

            }
        }
        return maxArea
    }

    private fun bfs(grid: Array<IntArray>, i: Int, j: Int): Int {
        return if (i >= 0 && i < grid.size && j >= 0 && j < grid[0].size && grid[i][j] != 0) {
            grid[i][j] = 0
            1 + bfs(grid, i + 1, j) + bfs(grid, i - 1, j) + bfs(grid, i, j + 1) + bfs(grid, i, j - 1)
        } else {
            0
        }
    }
}

fun main() {
    val testCase = arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1)
    )

    println(Solution695().maxAreaOfIsland(testCase))
}