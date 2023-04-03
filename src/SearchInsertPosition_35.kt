class SearchInsertPositionKt {
    class Solution {
        fun searchInsert(nums: IntArray, target: Int): Int {
            var min = 0
            var max = nums.size - 1
            var middle = (min + max) / 2
            while (min < max) {
                if (nums[middle] == target) {
                    return middle;
                }

                if (nums[middle] < target) {
                    min = middle + 1
                } else {
                    max = middle
                }
                middle = (min + max) / 2
            }
            return min
        }
    }
}

fun main() {
    println(SearchInsertPositionKt.Solution().searchInsert(intArrayOf(-4, -1, 0, 3, 10), 1))
    println(SearchInsertPositionKt.Solution().searchInsert(intArrayOf(1, 3, 5, 6), 0))
    println(SearchInsertPositionKt.Solution().searchInsert(intArrayOf(1, 3, 5, 6), 1))
    println(SearchInsertPositionKt.Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(SearchInsertPositionKt.Solution().searchInsert(intArrayOf(1, 3, 5, 6), 6))
    println(SearchInsertPositionKt.Solution().searchInsert(intArrayOf(1, 3, 5, 6), 7))
}