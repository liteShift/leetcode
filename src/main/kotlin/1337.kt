class Solution1337 {
    /**
     * m x n binary matrix where for each row, all 1s will appear before all 0s
     *
     * a row is weaker than another row if any of the following are true:
     *      the number of soldiers in row i is less than the number of soldiers in row j
     *      both rows have the same number of soldiers and i < j
     *
     *      the row's index increases its number of sliders
     *
     * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest
     */
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val scoreMap = mutableMapOf<Int, MutableList<Int>>()
        mat.forEachIndexed { rowIndex, row ->
            val score = scoreRow(row)
            scoreMap[score]?.add(rowIndex) ?: with(mutableListOf(rowIndex)) {
                scoreMap[score] = this
            }
        }

        val kWeakestRows = mutableListOf<Int>()
        for (i in 0..mat[0].size) {
            if (kWeakestRows.size == k) break
            scoreMap[i]?.take(k - kWeakestRows.size)?.forEach {
                kWeakestRows.add(it)
            }
        }
        return kWeakestRows.toIntArray()
    }

    private fun scoreRow(row: IntArray): Int {
        return row.count { it == 1 }
    }
}

fun main() {
    val mat = arrayOf(
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(1, 1, 1, 1, 0),
        arrayOf(1, 0, 0, 0, 0),
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(1, 1, 1, 1, 1)
    ).map {
        it.toIntArray()
    }.toTypedArray()

    val solution = Solution1337()
    val kWeakestRows = solution.kWeakestRows(mat, 3)
    kWeakestRows.forEach {
        println(it)
    }

}