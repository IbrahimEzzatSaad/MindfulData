package Algorithms.RadixSort

import java.lang.Math.pow

/*----------------Challenge 1: Most signiﬁcant sort------------
* Your task is to implement a most significant digit (MSD) radix sort.
This sorting behavior is called lexicographical sorting and is also used for String sorting.
* -----------------------Solution--------------------
* MSD radix sort is closely related to LSD radix sort, in that both use bucket sort.
* The difference is that MSD radix sort needs to curate subsequent passes of the bucket sort carefully.
* In LSD radix sort, bucket sort ran repeatedly using the whole list for every pass.
* In MSD radix sort, you run bucket sort with the entire list only once. Subsequent passes will sort each bucket recursively.*/

/*digits is a computed property that returns the number of digits that the Int has.
For example, the value of 1024 has four digits.*/
fun Int.digits(): Int {
    var count = 0
    var num = this
    while (num != 0) {
        count += 1
        num /= 10
    }
    return count
}

/*digit(atPosition:) returns the digit at a given position. Like lists, the leftmost
position is zero. Thus, the digit for position zero of the value 1024 is 1. The digit for
position three is 4. Since there are only four digits, the digit for position five will return null.*/
fun Int.digit(atPosition: Int): Int? {
    val correctedPosition = (atPosition + 1).toDouble()
    if (correctedPosition > digits()) return null

    var num = this
    while (num / (pow(10.0, correctedPosition).toInt()) != 0) {
        num /= 10
    }
    return num % 10
}


/*lexicographicalSort() is the user-facing API for MSD radix sort.
msdRadixSorted() is the meat of the algorithm and will be used to recursively apply MSD radix sort to the list.*/
fun MutableList<Int>.lexicographicalSort() {
    val newList = msdRadixSorted(this, 0)
    this.clear()
    this.addAll(newList)
}

private fun msdRadixSorted(list: MutableList<Int>, position: Int): MutableList<Int> {
    //This ensures that if the position is equal or greater than the list’s maxDigits, you’ll terminate the recursion.
    if (position >= list.maxDigits()) return list

    // 1-Similar to LSD radix sort, you instantiate a two-dimensional list for the buckets.
    val buckets = MutableList<MutableList<Int>>(10) { mutableListOf() }
    // 2-The priorityBucket is a special bucket that stores values with fewer digits than the current position. Values that go in the priorityBucket are sorted first.
    val priorityBucket = arrayListOf<Int>()
    // 3-For every number in the list, you find the digit of the current position and place the number in the appropriate bucket.
    list.forEach { number ->
        val digit = number.digit(position)
        if (digit == null) {
            priorityBucket.add(number)
            return@forEach
        }
        buckets[digit].add(number)
    }

    /*you need to recursively apply MSD radix sort for each of the individual buckets.
    * This statement calls reduce(into:) to collect the results of the recursive sorts and
      appends them to the priorityBucket. That way, the elements in the priorityBucket always go first. */
    val newValues = buckets.reduce { result, bucket ->
        if (bucket.isEmpty()) return@reduce result
        result.addAll(msdRadixSorted(bucket, position + 1))
        result
    }
    priorityBucket.addAll(newValues)

    return priorityBucket
}

/*As with all recursive operations, you need to set a terminating condition that stops
the recursion. Recursion should halt if the current position you’re inspecting is
greater than the number of significant digits of the largest value inside the list.*/
private fun List<Int>.maxDigits(): Int {
    return this.maxOrNull()?.digits() ?: 0
}