package Algorithms.BinarySearch

import example

/*  Binary search is a powerful algorithm to learn, and it comes up often in
    programming interviews.

    * Whenever you read something along the lines of “Given a
      sorted array...”, consider using the binary search algorithm. Also, if you’re given a
      problem that looks like it’s going to be O(n²) to search, consider doing some upfront
      sorting. With upfront sorting, you can use binary searching to reduce complexity to
      the cost of the sort at O(n log n).


      -----------------------Key Points--------------------
      * 1-Binary search is only a valid algorithm on sorted collections.
      * 2-Sometimes, it may be beneficial to sort a collection just to leverage the binary search capability for looking up elements.
      * 3-The indexOf method of arrays uses linear search, which has an O(n) time
          complexity. Binary search has an O(log n) time complexity, which scales much better for large data sets.*/
fun main(){

    "Searching for a number in the array" example{
    val array = arrayListOf(1, 5, 15, 17, 19, 22, 24, 31, 105, 150)
    val search31 = array.indexOf(31)
    val binarySearch31 = array.binarySearch(31)
    println("indexOf(): $search31")
    println("binarySearch(): $binarySearch31")
    }



    "binary search for a range" example{
        val array = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
        val indices = array.findIndices(3)
        println(indices)
    }
}