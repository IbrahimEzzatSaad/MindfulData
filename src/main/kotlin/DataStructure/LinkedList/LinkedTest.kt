package DataStructure.LinkedList

import LinkedList
import Node
import example

/*---------------Key points---------------
   *   Linked lists are linear and unidirectional. As soon as you move a reference from one node to another, you can’t go back.
   *   Linked lists have a O(1) time complexity for head-first insertions. Arrays have O(n) time complexity for head-first insertions.
   *   Conforming to Kotlin collection interfaces, such as Iterable and Collection, offers a host of helpful methods for a reasonably small amount of requirements.*/
fun main() {


    "adding nodes manually" example{
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)
        node1.next = node2
        node2.next = node3
        println(node1)
    }


    "Without interface push" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println(list)
    }


    "Push with fluent interface pattern" example{
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        println(list)
    }



    "Appending - This adds a value at the end of the list, which is known as tail-end insertion." example{
        val list = LinkedList<Int>()
        list.append(1).append(2).append(4)
        println(list)
    }


    "Insertion" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before inserting: $list")
        var middleNode = list.nodeAt(1)!!
        for (i in 1..3) {
                middleNode = list.insert(-1 * i, middleNode)
        }
        println("After inserting: $list")
    }


    "Pop" example{
     // Removing a value at the front of the list is often referred to as pop
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before popping list: $list")
        val poppedValue = list.pop()
        println("After popping list: $list")
        println("Popped value: $poppedValue")
    }



    "Removing the last node of the list is somewhat inconvenient." example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before removing last node: $list")
        val removedValue = list.removeLast()

        println("After removing last node: $list")
        println("Removed value: $removedValue")
    }



    "Remove operations" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before removing at particular index: $list")
        val index = 1
        val node = list.nodeAt(index - 1)!!
        val removedValue = list.removeAfter(node)

        println("After removing at index $index: $list")
        println("Removed value: $removedValue")
    }



    "Iterating through elements" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println(list)

        for (item in list) {
                println("Double: ${item * 2}")
        }
        }



    //**------------------------------------------------------------------------------------------**/


    "removing elements" example{
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)

        println(list)
        list.remove(0)
        println(list)
    }



    "retaining elements" example{
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        list.retainAll(listOf(3, 4, 5))
        println(list)
    }

    "remove all elements" example{
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        list.removeAll(listOf(3, 4, 5))
        println(list)
    }


    "Challenge 1: Reverse a linked list" example{
    //The time complexity of this algorithm is O(n) since you have to traverse each node of the list.
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        list.printInReverse()
    }


    "Challenge 2: The item in the middle" example{
    /*The time complexity of this algorithm is O(n) since you traversed the list in a single pass.
    The runner technique helps solve a variety of problems associated with the linked list.*/

        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        println(list.getMiddle()?.value)
    }


    "Challenge 3: Reverse a linked list" example{
    /*To reverse a linked list, you need to visit each node and update the next reference to point in the other direction.
      This can be a tricky task since you’ll need to manage multiple references to multiple nodes.
      To do this, you would also need access to the head and tail of your liked list. Since you’re implementing an extension function, you won’t have access to these variables.
      Luckily, there’s a simpler solution that has a small drawback discussed later.
      You can easily reverse a list by using a recursive function that goes to the end of the list and then starts copying the nodes when it returns, in a new linked list.*/
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println("Original: $list")
        println("Reversed: ${list.reversed()}")
    }


    "Challenge 4: Merging two linked lists" example {
     /*Create a function that takes two sorted linked lists and merges them into a single sorted linked list
     Your goal is to return a new linked list that contains the nodes from two lists in sorted order.
     This algorithm has a time complexity of O(m + n), where m is the # of nodes in the first list, and n is the # of nodes in the second list.*/

         val list = LinkedList<Int>()
         list.add(1)
         list.add(2)
         list.add(3)
         list.add(4)
         list.add(5)

         val other = LinkedList<Int>()
         other.add(-1)
         other.add(0)
         other.add(2)
         other.add(2)
         other.add(7)

         println("Left: $list")
         println("Right: $other")
         println("Merged: ${list.mergeSorted(other)}")
    }

}


/*----Challenge 1: Reverse a linked list----
Create an extension function that prints out the elements of a linked list in reverse order. Given a linked list, print the nodes in reverse order.
A straightforward way to solve this problem is to use recursion. Since recursion allows you to build a call stack, you need to call the print statements as the call stack unwinds.
Your first task is to define an extension function for LinkedList. Add the following helper function to your solution file*/
fun <T> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}


fun <T> Node<T>.printInReverse() {
    print(this.value.toString())
    this.next?.printInReverse()

    // 1- First, you check if you’ve reached the end of the list. That’s the beginning of the reverse printing, and you’ll not add an arrow there.
    // The arrows start with the second element of the reverse output. This is just for pretty formatting.
    if (this.next != null) {
        print(" -> ")
    }
    // 2- As the recursive statements unravel, the node data gets printed.
    print(this.value.toString())
}


/*----Challenge 2: The item in the middle----
One solution is to have two references traverse down the nodes of the list where one is twice as fast as the other.
Once the faster reference reaches the end, the slower reference will be in the middle. Write the following function:*/
fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)


    //In the while declaration, you bind the next node to fast. If there’s a next node, you update fast to the next node of fast, effectively traversing down the list twice.
    //slow is updated only once. This is also known as the runner technique.
    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}


/*----Challenge 3: Reverse a linked list----
To reverse a linked list, you need to visit each node and update the next reference to point in the other direction.
This can be a tricky task since you’ll need to manage multiple references to multiple nodes.
To do this, you would also need access to the head and tail of your liked list. Since you’re implementing an extension function, you won’t have access to these variables.
Luckily, there’s a simpler solution that has a small drawback discussed later.
You can easily reverse a list by using a recursive function that goes to the end of the list and then starts copying the nodes when it returns, in a new linked list.*/
private fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    // 1- Get the next node of the list, starting from the one you’ve received as a parameter.
    val next = node.next
    if (next != null) {
        // 2- If there’s a following node, recursively call the same function; however, now the starting node is the one after the current node.
        addInReverse(list, next)
    }
    // 3-When you reach the end, start adding the nodes in the reverse order.
    list.append(node.value)

    //O(n) time complexity, short and sweet! The only drawback is that you need a new list, which means that the space complexity is also O(n).
}


//This extension creates a new LinkedList and fills it with nodes by calling DataStructure.LinkedList.addInReverse(), passing in the first node of the current list.
fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}


/*Challenge 4: Merging two linked lists
 The solution to this problem is to continuously pluck nodes from the two sorted lists and add them to a new list.
 Since the two lists are sorted, you can compare the next node of both lists to see which one should be the next one to add to the new list.
 You’ll begin by checking the cases where one or both of the lists are empty.*/
fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    //-If one is empty, you return the other. You also introduce a new reference to hold a new LinkedList.
    // The strategy is to merge the nodes in this and otherList into result in sorted order.
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()
    // 1- You start with the first node of each list.
    var left = nodeAt(0)
    var right = otherList.nodeAt(0)
    // 2- The while loop continues until one of the lists reaches its end.
    while (left != null && right != null) {
        // 3- You compare the first nodes left and right to DataStructure.LinkedList.append to the result.
        //Since this loop depends on both left and right, it will terminate even if there are nodes left in either list.
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }


    //to handle the remaining nodes
    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}


//a helper function that adds the current node to the result list and returns the next node.
// You’ll use this function in your algorithm multiple times, so it’s useful to have it extracted:
private fun <T : Comparable<T>> append(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}








