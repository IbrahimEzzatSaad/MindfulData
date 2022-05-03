
## What is a LinkedList??
I have thought about explaning it in real life example but I couldn't find better than this.
![enter image description here](https://mir-s3-cdn-cf.behance.net/project_modules/disp/0d8f8410905773.560ed8d7374db.gif)
Did you ever saw how trains car connected? Each car holding the next one and there a Head of the train and there's a tail as well right? so when we add more cars to it we add from the tail and the new one becomes the new tail (last car)


A linked list is a linear data structure that includes a series of connected nodes. Here, each node stores the **data** and the **address** of the next node.
![enter image description here](https://cdn.programiz.com/sites/tutorial2program/files/linked-list-concept.png)
Linked lists can be of multiple types: **singly**, **doubly**, and **circular linked list**. In this article, we will focus on the **singly linked list**.

> **Note:** You might have played the game Treasure Hunt, where each clue includes the information about the next clue. That is how the linked list operates.

LinkedList have operations like append, push, remove(removelast, removeat, pop), insert.

The Time Complexity for LinkedList

- Search: O(n)
- Insert: O(1)
- Deletion: O(1)
- Space Complexity: O(n)

If you don't know what Time Complexity is, I suggest you read [this](https://www.geeksforgeeks.org/understanding-time-complexity-simple-examples/).

The implementation for this data strcuture  you will find in this package and I suggest reading the comments on each code to understand the code more and be able to imagine how things work.


## Pros & Cons
**Advantages Of Linked List:**

-   **Dynamic data structure:**  A linked list is a dynamic arrangement so it can grow and shrink at runtime by allocating and  [deallocating memory](https://www.geeksforgeeks.org/how-to-deallocate-memory-without-using-free-in-c/). So there is no need to give the initial size of the linked list.
-   **No memory wastage:**  In the Linked list, efficient memory utilization can be achieved since the size of the linked list increase or decrease at run time so there is no memory wastage and there is no need to pre-allocate the memory.
-   **Implementation:**  Linear data structures like stack and queues are often easily implemented using a linked list.
-   **Insertion and Deletion Operations:**  Insertion and deletion operations are quite easier in the linked list. There is no need to shift elements after the insertion or deletion of an element only the address present in the next pointer needs to be updated.

**Disadvantages Of Linked List:**

-   **Memory usage:**  More memory is required in the linked list as compared to an array. Because in a linked list, a  [pointer](https://www.geeksforgeeks.org/pointers-in-c-and-c-set-1-introduction-arithmetic-and-array/)  is also required to store the address of the next element and it requires extra memory for itself.
-   **Traversal:**  In a  [Linked list traversal](https://www.geeksforgeeks.org/recursive-insertion-and-traversal-linked-list/)  is more time-consuming as compared to an array. Direct access to an element is not possible in a linked list as in an array by index. For example, for accessing a node at position n, one has to traverse all the nodes before it.
-   **Reverse Traversing:**  In a singly linked list reverse traversing is not possible, but in the case of a  [doubly-linked list](https://www.geeksforgeeks.org/doubly-linked-list/), it can be possible as it contains a pointer to the previously connected nodes with each node. For performing this extra memory is required for the back pointer hence, there is a wastage of memory.
-   **Random Access:**  Random access is not possible in a linked list due to its  [dynamic memory allocation](https://www.geeksforgeeks.org/what-is-dynamic-memory-allocation/).

## 📒 References

[Programiz - LinkedList](https://www.programiz.com/dsa/linked-list)
[GeeksForGeeks - LinkedList](https://www.geeksforgeeks.org/data-structures/linked-list/)
[Stackabuse- Interview Questions LinkedList](https://stackabuse.com/linked-list-programming-interview-questions/)
[GeeksForGeeks - Advantages and Disadvantages of LinkedList](https://www.geeksforgeeks.org/advantages-and-disadvantages-of-linked-list/)