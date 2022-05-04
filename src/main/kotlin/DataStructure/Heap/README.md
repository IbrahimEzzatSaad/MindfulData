# What is Heap????

![enter image description here](https://miro.medium.com/max/1240/1*bwRWOhFtfK9xdVbpIGOm4A.png)\
Heap data structure is  [a complete binary tree](https://www.programiz.com/dsa/complete-binary-tree)  that satisfies  **the heap property**, where any given node is

-   always greater than its child node/s and the key of the root node is the largest among all other nodes. This property is also called  **max heap property**.
-   always smaller than the child node/s and the key of the root node is the smallest among all other nodes. This property is also called  **min heap property**.
![Max Heap](https://cdn.programiz.com/cdn/farfuture/OTLuUbQZmYPjHkXgmCfzHr8nNCkoi2Je9y9ZzIl1vuI/mtime:1582112622/sites/tutorial2program/files/maxheap_1.png)

> Max Heap

![Min Heap](https://cdn.programiz.com/cdn/farfuture/tVzREVaraXbOKPPJtMbcQ10N2QkxiAJcNOIfxPYlVR0/mtime:1582112622/sites/tutorial2program/files/minheap_0.png)
> Min Heap



## Heap applications
Some useful applications of a heap include:
-  Calculating the minimum or maximum element of a collection.
-  Heap sort.
-  Implementing a priority queue.
-  Supporting graph algorithms, like Prim’s or Dijkstra’s, with a priority queue.

**Common heap operations**
![enter image description here](https://i.imgur.com/TFXOclU.png)

Here you have a generic Collection interface with the basic property count which returns the number of elements and the boolean property isEmpty which just tests if the count is 0.
It also contains the classical operations of inserting and deletion.


## Pros & Cons
![enter image description here](https://i.imgur.com/2TwCDpG.png)

## Key points
- Here’s a summary of the algorithmic complexity of the heap operations implemented in this package:
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/60c605f35bc4d8eeb918e823645d47529e29ba5ca655516fbde640d3bd7d3c44/original.png)
-  The heap data structure is good for maintaining the highest or lowest priority element.
- Every time you insert or remove items from the heap, you must check to see if it satisfies the rules of the priority.
## 📒 References 
[Stack Vs Heap - Advantages and disadvantages](https://drasticcode.com/stack-vs-heap-what-is-stack/#Advantages_and_disadvantages_of_heap)\
[GeeksForGeeks - Heap](https://www.geeksforgeeks.org/heap-data-structure/)\
[Programiz -  Heap](https://www.programiz.com/dsa/heap-data-structure)
