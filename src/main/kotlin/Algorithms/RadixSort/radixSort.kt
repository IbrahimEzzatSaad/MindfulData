package Algorithms.RadixSort

/*Radix sort is a non-comparative algorithm for sorting integers in linear time. There
are many implementations of radix sort that focus on different problems. To keep
things simple, you’ll focus on sorting base 10 integers while investigating the least
significant digit (LSD) variant of radix sort.

https://www.youtube.com/watch?v=nu4gDuFabIM

Radix sort is one of the fastest sorting algorithms. The average time complexity of
radix sort is O(k ×n), where k is the number of significant digits of the largest
number, and n is the number of integers in the list.

Radix sort works best when k is constant, which occurs when all numbers in the list
have the same count of significant digits. Its time complexity then becomes O(n).
Radix sort also incurs an O(n) space complexity, as you need space to store each bucket.*/

//Here, you’ve added radixSort() to MutableList of integers via an extension function.
fun MutableList<Int>.radixSort() {
    // 1-You’re sorting base 10 integers in this instance. Since you’ll use this value many times in the algorithm, you store it in a constant base.
    val base = 10
    /*2-You declare two variables to track your progress. Radix sort works in many
      passes, so done serves as a flag that determines whether the sort is complete.
      The digits variable keeps track of the current digit you’re looking at.*/
    var done = false
    var digits = 1
    while (!done) {
        done = true
        //1-You instantiate the buckets using a two-dimensional list. Because you’re using base 10, you need ten buckets.
        val buckets = MutableList<MutableList<Int>>(base) { mutableListOf() }
        //2-You place each number in the correct bucket.
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)

            if (remainingPart > 0) {
                done = false
            }
        }
        /*3-You update digits to the next digit you want to inspect and update the list using
            the contents of buckets. flatten() flattens the two-dimensional list to a one-
            dimensional list, as if you’re emptying the buckets into the list.*/
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }
}
