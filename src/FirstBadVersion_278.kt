/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */
class FirstBadVersionSolutionKt {
    abstract class VersionControl(private val badVersion: Int) {
        fun isBadVersion(n: Int) = n >= badVersion
        abstract fun firstBadVersion(n: Int): Int
    }
    class Solution(badVersion: Int): VersionControl(badVersion) {
        override fun firstBadVersion(n: Int) : Int {
            var min = 1
            var max = n
            var middle: Int
            while (min < max) {
                middle = min + (max - min) / 2
                if (isBadVersion(middle)) {
                    max = middle
                } else {
                    min = middle + 1
                }
            }
            return min
        }
    }
}


fun main() {
    println(FirstBadVersionSolutionKt.Solution(4).firstBadVersion(12))
}