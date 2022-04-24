package DataStructure.PriorityQueues

import example

fun main(){


    "Max priority queue" example {
        // When you run the code, notice the elements are removed largest to smallest.

        // 1-Create a ComparablePriorityQueueImpl<Int> using Int as generic type value which is Comparable<Int>.
        val priorityQueue = ComparablePriorityQueueImpl<Int>()
        // 2-Enqueue the value from an unsorted array into the priority queue.
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        // 3-Dequeue all of the values from the priority queue.
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }



    "Min priorityQueue" example{
    // When you run the code, you’ll see this output where the String objects are sorted from the longest to the shortest.
        // 1-Create a Comparator<String> implementation that compares String based on the length from the longest to the shortest.
        val stringLengthComparator = object : Comparator<String> {
            override fun compare(o1: String?, o2: String?): Int {
                val length1 = o1?.length ?: -1
                val length2 = o2?.length ?: -1
                return length1 - length2
            }
        }
        // 2-Create a ComparatorPriorityQueueImpl using the previous comparator in the constructor.
        val priorityQueue = ComparatorPriorityQueueImpl(stringLengthComparator)
        // 3-Enqueue value from an unsorted array as String into the priority queue.
        arrayListOf("one", "two", "three", "forty", "five", "six", "seven", "eight", "nine").forEach {
            priorityQueue.enqueue(it)
        }
        // 4-Dequeue all the values from the priority queue.
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }


    "Max priority array list based queue" example{
        val priorityQueue = CustomPriorityQueueArrayList<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        priorityQueue.enqueue(5)
        priorityQueue.enqueue(0)
        priorityQueue.enqueue(10)
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }



    "Challenge 2: Sorting: Concert line" example{
        val p1 = Person("Josh", 21, true)
        val p2 = Person("Jake", 22, true)
        val p3 = Person("Clay", 28, false)
        val p4 = Person("Cindy", 28, false)
        val p5 = Person("Sabrina", 30, false)
        val priorityQueue =
            ComparatorPriorityQueueImpl(MilitaryPersonComparator)
        arrayListOf(p1, p2, p3, p4, p5).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }

}