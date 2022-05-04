
# What is Priority Queues??
![enter image description here](https://www.memecreator.org/static/images/memes/3529510.jpg)\
A priority queue is a  **special type of queue**  in which each element is associated with a  **priority value**. And, elements are served on the basis of their priority. That is, higher priority elements are served first.

However, if elements with the same priority occur, they are served according to their order in the queue.

**Assigning Priority Value**

Generally, the value of the element itself is considered for assigning the priority. For example,

The element with the highest value is considered the highest priority element. However, in other cases, we can assume the element with the lowest value as the highest priority element.

We can also set priorities according to our needs.

![enter image description here](https://cdn.programiz.com/sites/tutorial2program/files/Introduction.png)
> Removing Highest Priority Element

### Difference between Priority Queue and Normal Queue

In a queue, the  **first-in-first-out rule**  is implemented whereas, in a priority queue, the values are removed  **on the basis of priority**. The element with the highest priority is removed first.

## Implementation of Priority Queue

Priority queue can be implemented using an array, a linked list, a heap data structure, or a binary search tree. Among these data structures, heap data structure provides an efficient implementation of priority queues.

Hence, we will be using the heap data structure to implement the priority queue in this package.

## Applications
Some useful applications of a priority queue include:
-  Dijkstra’s algorithm: Uses a priority queue to calculate the minimum cost.
-  A* pathfinding algorithm: Uses a priority queue to track the unexplored routes that will produce the path with the shortest length.
- Heap sort: Many heap sorts use a priority queue.
- Huffman coding: Useful for building a compression tree. A min-priority queue is used to repeatedly find two nodes with the smallest frequency that don’t yet have a parent node.
Priority queues have many more applications and practical uses; the list above represents only a handful.

## ⏲ Queue Time Complexity
![enter image description here](https://i.imgur.com/UwFSjY0.png)

## Key points
-  A priority queue is often used to find the element in priority order.
-  The AbstractPriorityQueue<T> implementation creates a layer of abstraction by focusing on key operations of a queue and leaving out additional functionality provided by the heap data structure.
-  This makes the priority queue’s intent clear and concise. Its only job is to enqueue and dequeue elements, nothing else.
-  The AbstractPriorityQueue<T> implementation is another good example of 
Composition over (implementation) inheritance.


## 📒 References 
[Programiz - Priority Queue](https://www.programiz.com/dsa/priority-queue)\
[GeeksForGeeks - Priority Queue](https://www.geeksforgeeks.org/priority-queue-set-1-introduction/)
