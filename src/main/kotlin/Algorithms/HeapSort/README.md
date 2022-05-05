
# What is Heap Sort???
![enter image description here](https://miro.medium.com/max/400/1*bPHK3V9y1EZnr6z5ZiIncQ.jpeg)\
Heapsort is another comparison-based algorithm that sorts an array in ascending order using a heap. This chapter builds on the heap concepts.
Heapsort takes advantage of a heap being, by definition, a partially sorted binary tree 
with the following qualities:
1.   In a max heap, all parent nodes are larger than their children.
2.   In a min heap, all parent nodes are smaller than their children.

The diagram below shows a heap with parent node values underlined:
![enter image description here](https://assets.alexandria.raywenderlich.com/books/dsk/images/bb2f31cfaca0d50ec54e076e6c969af86fbf37d88bb9710cfd382cf638e014ee/original.png)\
[Click here to see it in video!](https://www.youtube.com/watch?v=MtQL_ll5KhQ)
## ⏲ Time Complexity
Even though you get the benefit of in-memory sorting, the performance of heap sort is O(n log n) for its best, worse and average cases. 

This is because you have to traverse the whole array once and, every time you swap elements, you must perform a sift down, which is an O(log n) operation.

Heap sort is also not a stable sort because it depends on how the elements are laid out and put into the heap. If you were heap sorting a deck of cards by their rank, for example, you might see their suite change order with respect to the original deck.
## Key points
-  Heap sort leverages the max-heap data structure to sort elements in an array.
-  Heap sort sorts its elements by following a simple pattern: swap the first and last element, perform a sift-down, decrease the array size by one; then repeat.
-  The performance of heap sort is O(n log n) for its best, worse and average cases.
## 📒 References 
[RayWenderLich - heapsort](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/17-heap-sort)\
[GeeksForGeeks - Youtube heap sort](https://www.youtube.com/watch?v=MtQL_ll5KhQ)
