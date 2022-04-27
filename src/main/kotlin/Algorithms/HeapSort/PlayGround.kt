package Algorithms.HeapSort

fun main() {
    "Heap sort" example {
        val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        array.heapSort(ascending)
        print(array.joinToString())
    }

    "Heap sort descending" example {
        val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        array.heapSort(descending)
        print(array.joinToString())
    }
}