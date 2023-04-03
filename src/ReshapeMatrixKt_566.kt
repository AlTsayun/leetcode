class ReshapeMatrixSolutionKt {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        if (m * n != r * c) {
            return mat
        }
        val res = Array(r) { IntArray(c) }
        for (i in 0 until m * n) {
            res[i / c][i % c] = mat[i / n][i % n]
        }
        return res
    }
}


fun main() {
    val start = System.currentTimeMillis()
    println(ReshapeMatrixSolutionKt().matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1, 4).contentDeepToString())
    println(ReshapeMatrixSolutionKt().matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 4, 1).contentDeepToString())
    println(ReshapeMatrixSolutionKt().matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 2, 4).contentDeepToString())
    println(System.currentTimeMillis() - start)
}