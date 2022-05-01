package Algorithms.On2Sorting

import Algorithms.On2Sorting.bubblesort.bubbleSort
import Algorithms.On2Sorting.challenges.biggestDuplicate
import Algorithms.On2Sorting.challenges.rev
import Algorithms.On2Sorting.challenges.rightAlign
import example
import Algorithms.On2Sorting.insertionsort.insertionSort
import Algorithms.On2Sorting.selectionsort.selectionSort


/*---------------------Key Points--------------------
* n² algorithms often have a terrible reputation, but some of these algorithms
usually have some redeeming points. insertionSort can sort in O(n) time if the
collection is already in sorted order and gradually scales down to O(n²).
* insertionSort is one of the best sorts in situations wherein you know ahead of time that your data is in sorted order.
* Design your algorithms to be as generic as possible without hurting the performance.*/
fun main(){


    "bubble sort" example {

        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.bubbleSort(true)
        println("Bubble sorted: $list")
    }
    "selection sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.selectionSort(true)
        println("Bubble sorted: $list")
    }
    "insertion sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.insertionSort(true)
        println("Bubble sorted: $list")
    }
    "align right" example  {
        val list = mutableListOf(3, 4, 134, 3, 3, 5, 6, 3, 5, 6, 1, 0)
        println("Original: $list")
        val element = 3
        list.rightAlign(element)
        println("Right align element $element: $list")
    }
    "biggest duplicate" example  {
        val list = mutableListOf(3, 4, 14, 23, 134, 5, 36, 31, 15, 6, 1, 0)
        println("Original: $list")
        val element = list.biggestDuplicate()
        println("Biggest duplicate element: $element")
    }

    "reverse" example  {
        val list = mutableListOf(3, 4, 14, 0, 23, 134, 5, 36, 31, 15, 6, 1, 0)
        println("Original: $list")
        list.rev()
        println("Reverse: $list")
    }
}