package Algorithms.RadixSort

import example

/*-----------------Key Points-----------------
* Radix sort is a non-comparative sort that doesn’t rely on comparing two values.
Instead, it leverages bucket sort, which is like a sieve for filtering values. A helpful
analogy is how some of the vending machines accept coins — the coins are distinguished by size.

* This chapter covered the least significant digit radix sort. Another way to
implement radix sort is the most significant digit form. This form sorts by
prioritizing the most significant digits over the lesser ones and is best illustrated
by the sorting behavior of the String type.*/
fun main() {
    "radix sort" example {
        val list = arrayListOf(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted: $list")
    }

    "digits" example {
        val kb = 1024
        println("$kb has ${1024.digits()} digits")
        println("and the 3rd digit is ${1024.digit(3)}")
    }

    "MSD radix sort" example {
        val list = (0..10).map { (Math.random() * 10000).toInt() }.toMutableList()
        println("Original: $list")
        list.lexicographicalSort()
        println("Radix sorted: $list")
    }
}