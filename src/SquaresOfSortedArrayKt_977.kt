class SquaresOfSortedArraySolutionKt {
    class Solution {
        fun sortedSquares(nums: IntArray): IntArray {
            val res = IntArray(nums.size)
            var i = 0
            var j = nums.size - 1
            var k = nums.size - 1
            while (i <= j) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                    res[k] = nums[i] * nums[i]
                    i++
                } else {
                    res[k] = nums[j] * nums[i]
                    j--
                }
                k--
            }
            return res
        }
    }
}

fun main() {
    println(SquaresOfSortedArraySolutionKt.Solution().sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
}