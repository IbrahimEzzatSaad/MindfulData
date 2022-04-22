package Algorithms.BinarySearch


/*Binary search is one of the most efficient searching algorithms with a time
    complexity of O(log n). This is comparable with searching for an element inside a
    balanced binary search tree.
    Two conditions need to be met before you can use binary search:

    *  The collection must be able to perform index manipulation in constant time.
       Kotlin collections that can do this include the Array and the ArrayList.

    *  The collection must be sorted.

    Here is an example compare to the linear search
    https://devopedia.org/images/article/28/2951.1490520804.gif*/

//You want binarySearch to be available on any ArrayList, so you define it as a generic extension function.
fun <T : Comparable<T>> ArrayList<T>.binarySearch(value: T, range: IntRange = indices): Int? {
    // 1-First, you check if the range contains at least one element. If it doesn’t, the search has failed and you return null.
    if (range.first > range.last) {
        return null
    }

    // 2-Now that you’re sure you have elements in the range, you find the middle index in the range.
    val size = range.last - range.first + 1
    val middle = range.first + size / 2

    return when {
        // 3-You then compare the value at this index with the value you’re searching for. If they match, you return the middle index.
        this[middle] == value -> middle
        // 4-If not, you recursively search either the left or right half of the collection, excluding the middle item in both cases.
        this[middle] > value -> binarySearch(value, range.first until middle)
        else -> binarySearch(value, (middle + 1)..range.last)
    }
}


/*-------------Challenge 1: Find the range-------------
* Write a function that searches a sorted ArrayList and finds the range of indices for a particular element.
* ---------------Solution----------------
* The time complexity of this solution is O(n), which may not seem to be a cause for
concern. However, you can optimize the solution to an O(_log n) time complexity
solution.

* Binary search is an algorithm that identifies values in a sorted collection, so keep
that in mind whenever the problem promises a sorted collection. The binary search
you implemented in the theory chapter is not powerful enough to reason whether
the index is a start or end index. You’ll modify that binary search to accommodate for this new rule.

* This time, findIndices will use specialized binary searches. startIndex and
endIndex will be the ones that do the heavy lifting with a customized binary search.
You’ll modify binary search so that it also inspects whether the adjacent value —
depending on whether you’re looking for the start or end index — is different from
the current value.*/
fun <T : Comparable<T>> ArrayList<T>.findIndices(value: T): IntRange? {
    val startIndex = startIndex(value, indices) ?: return null
    val endIndex = endIndex(value, indices) ?: return null

    return startIndex until endIndex
}

private fun <T : Comparable<T>> ArrayList<T>.startIndex(
    value: T,
    range: IntRange
): Int? {
    // 1-You start by calculating the middle value of the indices contained in range.
    val middleIndex = range.start + (range.last - range.start + 1) / 2

    /* 2-This is the base case of this recursive function. If the middle index is the first or
        last accessible index of the array, you don’t need to call binary search any further.
        You’ll determine whether or not the current index is a valid bound for the given value.*/
    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) {
            middleIndex
        } else {
            null
        }
    }

    /* 3-Here, you check the value at the index and make your recursive calls. If the value
        at middleIndex is equal to the value you’re given, you check to see if the
        predecessor is also the same value. If it isn’t, you know that you’ve found the
        starting bound. Otherwise, you’ll continue by recursively calling startIndex.*/
    return if (this[middleIndex] == value) {
        if (this[middleIndex - 1] != value) {
            middleIndex
        } else {
            startIndex(value, range.start until middleIndex)
        }
    } else if (value < this[middleIndex]) {
        startIndex(value, range.start until middleIndex)
    } else {
        startIndex(value, (middleIndex + 1)..range.last)
    }
}

private fun <T : Comparable<T>> ArrayList<T>.endIndex(
    value: T,
    range: IntRange
): Int? {
    val middleIndex = range.start + (range.last - range.start + 1) / 2

    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) {
            middleIndex + 1
        } else {
            null
        }
    }

    return if (this[middleIndex] == value) {
        if (this[middleIndex + 1] != value) {
            middleIndex + 1
        } else {
            endIndex(value, (middleIndex + 1)..range.last)
        }
    } else if (value < this[middleIndex]) {
        endIndex(value, range.start until middleIndex)
    } else {
        endIndex(value, (middleIndex + 1)..range.last)
    }
}