package Algorithms.QuickSort

/*A problem with Lomuto’s and Hoare’s algorithms is that they don’t handle duplicates
really well. With Lomuto’s algorithm, duplicates end up in the less than partition and
aren’t grouped together. With Hoare’s algorithm, the situation is even worse as duplicates can be all over the place.

A solution to organize duplicate elements is using Dutch national flag partitioning.
This technique is named after the Dutch flag, which has three bands of colors: red, white and blue.
This is similar to how you create three partitions.

Dutch national flag partitioning is a good technique to use if you have a lot of duplicate elements.

You’ll adopt the same strategy as Lomuto’s partition by choosing the last element as the pivotIndex.*/
fun<T: Comparable<T>> MutableList<T>.partitionDutchFlag(low: Int, high: Int, pivotIndex: Int): Pair<Int, Int> {
    val pivot = this[pivotIndex]
    /*1- Whenever you encounter an element that is less than the pivot, move it to index smaller.
     This means that all elements that come before this index are less than the pivot.*/
    var smaller = low
    /*2- Index equal points to the next element to compare. Elements that are equal to
    the pivot are skipped, which means that all elements between smaller and equal are equal to the pivot.*/
    var equal = low
    /*3-Whenever you encounter an element that is greater than the pivot, move it to index larger.
     This means that all elements that come after this index are greater than the pivot.*/
    var larger = high

    /*4- The main loop compares elements and swaps them if needed.
     This continues until index equal moves past index larger, meaning all elements have been moved to their correct partition.*/
    while (equal <= larger) {
        if (this[equal] < pivot) {
            this.swapAt(smaller, equal)
            smaller += 1
            equal += 1
        } else if (this[equal] == pivot) {
            equal += 1
        } else {
            this.swapAt(equal, larger)
            larger -= 1
        }
    }
    /*5- The algorithm returns indices smaller and larger. These point to the first and last elements of the middle partition.*/
    return Pair(smaller, larger)
}


/*Notice how recursion uses the middleFirst and middleLast indices to determine
the partitions that need to be sorted recursively. Because the elements equal to the
pivot are grouped together, they can be excluded from the recursion.*/
fun<T: Comparable<T>> MutableList<T>.quicksortDutchFlag(low:
                                                        Int, high: Int) {
    if (low < high) {val middle = partitionDutchFlag(low, high, high)
        this.quicksortDutchFlag(low, middle.first - 1)
        this.quicksortDutchFlag(middle.second + 1, high)
    }
}