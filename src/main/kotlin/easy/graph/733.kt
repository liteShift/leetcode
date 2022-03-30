package easy.graph

class Solution733 {
    private val visited = mutableSetOf<Pair<Int, Int>>()
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        visited.add(Pair(sr, sc))
        getEdges(image, sr, sc).forEach {
            if (image[it.first][it.second] == image[sr][sc] && it !in visited) floodFill(
                image,
                it.first,
                it.second,
                newColor
            )
        }
        image[sr][sc] = newColor
        return image
    }

    private fun getEdges(image: Array<IntArray>, sr: Int, sc: Int): List<Pair<Int, Int>> {
        val points = mutableListOf<Pair<Int, Int>>()
        if (sr + 1 < image.size) points.add(Pair(sr + 1, sc))
        if (sr - 1 >= 0) points.add(Pair(sr - 1, sc))
        if (sc + 1 < image.first().size) points.add(Pair(sr, sc + 1))
        if (sc - 1 >= 0) points.add(Pair(sr, sc - 1))
        return points
    }
}

fun main() {
    val test = arrayOf(arrayOf(0,0,0).toIntArray(), arrayOf(0, 0, 0).toIntArray())
    val sol = Solution733()
    sol.floodFill(test, 1, 1, 2).forEach {
        println(it.contentToString())
    }

}