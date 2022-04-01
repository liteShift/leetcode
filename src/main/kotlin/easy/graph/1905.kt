package easy.graph

class Solution1905 {
    private val water = 0
    private val land = 1
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        var flag = true
        fun dfs(grid: Array<IntArray>, i: Int, j: Int) {
            if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j].isWater()) return
            if (grid1[i][j].isWater()) flag = false
            grid[i][j] = water
            dfs(grid, i + 1, j)
            dfs(grid, i - 1, j)
            dfs(grid, i, j + 1)
            dfs(grid, i, j - 1)


        }

        var numSubIslands = 0
        for (i in grid2.indices) {
            for (j in grid2[0].indices) {
                if (grid2[i][j].isLand()) {
                    dfs(grid2, i, j)
                    if (flag) numSubIslands++
                    flag = true
                }
            }
        }

        return numSubIslands
    }


    private fun Int.isLand() = this == land
    private fun Int.isWater() = this == water
}