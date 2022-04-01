package easy.graph

class Solution1020 {
    /**
     * go on the edges and traversal all islands reachable from there and turn the islands into water
     *
     * then go iterate Through the inner matrix and count the number of cells that = 1
     *
     */
    private val water = 0
    private val land = 1
    fun numEnclaves(grid: Array<IntArray>): Int {
        val numRows = grid.size
        val numCols = grid[0].size

        for (i in grid.indices) {
            if (grid[i][0] == land) islandToWater(grid, i, 0)
            if (grid[i][numCols - 1] == land) islandToWater(grid, i, numCols - 1)
        }

        for (j in grid[0].indices) {
            if (grid[0][j] == land) islandToWater(grid, 0, j)
            if (grid[numRows - 1][j] == land) islandToWater(grid, numRows - 1, j)
        }

        var numLandCells = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == land) numLandCells++
            }
        }
        return numLandCells
    }

    private fun islandToWater(grid: Array<IntArray>, i: Int, j: Int) {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == water) return
        grid[i][j] = water
        islandToWater(grid, i + 1, j)
        islandToWater(grid, i - 1, j)
        islandToWater(grid, i, j + 1)
        islandToWater(grid, i, j - 1)
    }
}