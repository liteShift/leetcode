class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        // binary matrix m x n
        // the 1s appear before the 0s in each row (to the left)

        // a row is weaker than another row if the one of the following are true:

        /**
         * the number of soldiers in row i is less than the number of soldiers in row j
         * both rows have the same number of soldiers and i < j
         *
         * the row's index increases its number of sliders
         *
         * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest
         */

    }

    fun scoreRow(row: IntArray)
}