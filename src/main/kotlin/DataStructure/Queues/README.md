
# What is Queues??
We’re all familiar with waiting in line. Whether you’re in line to buy tickets to your favorite movie or waiting for a printer to print a file, these real-life scenarios mimic the queue data structure.

![Queues](https://camo.githubusercontent.com/46ebac23737eb3d50697777449d714468a10757c47e5c7578c2df3c1cf205ec6/687474703a2f2f692e67697068792e636f6d2f3130306d684554714b594a4e66322e676966)
Queues use FIFO or first in, first out ordering, meaning the first element that was added will always be the first one removed. Queues are handy when you need to maintain the order of your elements to process later.

In programming terms, putting items in the queue is called  **enqueue**, and removing items from the queue is called  **dequeue**.


In this package you will find Queues implementation in different various ways.
Each implementation has a different time complexity.
•  Using an array based list
•  Using a doubly linked list
•  Using a ring buffer
•  Using two stacks
## Basic Operations of Queues
A queue is an object (an abstract data structure - ADT) that allows the following operations:

-   **Enqueue**: Add an element to the end of the queue
-   **Dequeue**: Remove an element from the front of the queue
-   **IsEmpty**: Check if the queue is empty
-   **IsFull**: Check if the queue is full
-   **Peek**: Get the value of the front of the queue without removing it
![Carbon here](https://i.imgur.com/oTW007a.png)
## ⏲ Queue Time Complexity

### Array - Strengths and weaknesses
Here’s a summary of the algorithmic and storage complexity of the ArrayList based queue implementation. Most of the operations are constant time except for dequeue(), which takes linear time. Storage space is also linear.
![Array-based](https://assets.alexandria.raywenderlich.com/books/dsk/images/c15c2bc2e699d4edd2a0672a19138cedfbe2db27d8267796622e39a266e624a6/original.png)
Enqueue is very fast, thanks to an  _O_(1) append operation.

There are some shortcomings to the implementation. Removing an item from the front of the queue can be inefficient, as removal causes all elements to shift up by one. This makes a difference for very large queues. Once the list gets full, it has to resize and may have unused space. This could increase your memory footprint over time. Is it possible to address these shortcomings? Let’s look at a linked list-based implementation and compare it to an  `ArrayListQueue`.

### LinkedList - Strengths and weaknesses

Time to summarize the algorithmic and storage complexity of the implementation based on a doubly linked list.

![](https://assets.alexandria.raywenderlich.com/books/dsk/images/d509e4b840159746506a709f304c58a672a4bde827872861e1d629f85c6f8944/original.png)

One of the main problems with  `ArrayListQueue`  is that dequeuing an item takes linear time. With the linked list implementation, you reduced it to a constant operation,  _O_(1). All you needed to do was update the node’s  `previous`  and  `next`  pointers.

The main weakness with  `LinkedListQueue`  is not apparent from the table. Despite  _O_(1) performance, it suffers from high overhead. Each element has to have extra storage for the forward and back reference. Moreover, every time you create a new element, it requires a relatively expensive dynamic allocation. By contrast,  `ArrayListQueue`  does bulk allocation, which is faster.

Can you eliminate allocation overhead and preserve  _O_(1) dequeues? If you don’t have to worry about your queue ever growing beyond a fixed size, you can use a different approach like the  **ring buffer**. For example, you might have a game of  _Monopoly_  with five players. You can use a queue based on a ring buffer to keep track of whose turn is coming up next.


### RingBuffer - Strengths and weaknesses

How does the ring-buffer implementation compare? Let’s look at a summary of the algorithmic and storage complexity.

![](https://assets.alexandria.raywenderlich.com/books/dsk/images/a2f9ece55f108c9585d2a748dde0a89a5a8e318215a16378e0f29d5f46f56a02/original.png)

The ring-buffer-based queue has the same time complexity for enqueue and dequeue as the linked-list implementation. The only difference is the space complexity. The ring buffer has a fixed size, which means that enqueue can fail.

So far, you’ve seen three implementations: an array, a doubly linked-list and a ring-buffer.

Although they appear to be eminently useful, you’ll next look at a queue implemented using two stacks.

### Double Stack - Strengths and weaknesses

Here’s a summary of the algorithmic and storage complexity of your two-stack-based implementation.

![](https://assets.alexandria.raywenderlich.com/books/dsk/images/9200faa2c532ae7970ef7166f0e1e6c5e3bcb0475ffbd96e569f2d77083f0942/original.png)

Compared to the list-based implementation, by leveraging two stacks, you were able to transform  `dequeue()`  into an amortized  _O_(1) operation.

Moreover, your two-stack implementation is fully dynamic and doesn’t have the fixed size restriction that your ring-buffer-based queue implementation has.

Finally, it beats the linked list in terms of spatial locality. This is because list elements are next to each other in memory blocks. So a large number of elements will be loaded in a cache on first access.

Compare the two images on the following page; one has elements in a contiguous array, the other has elements scattered all over memory:

![Elements in a contiguous array.](https://assets.alexandria.raywenderlich.com/books/dsk/images/e04a3c4918ef543bcd4a68bf31275ab234344c3c43b0e37fff799064de6ea67e/original.png "Elements in a contiguous array.")

Elements in a contiguous array.

![Elements in a linked list, scattered all over memory.](https://assets.alexandria.raywenderlich.com/books/dsk/images/049b9da346150db61e96bf046902c0b5aa9a6571109396a974d85997586bbd4a/original.png "Elements in a linked list, scattered all over memory.")

Elements in a linked list, scattered all over memory.

In a linked list, elements aren’t in contiguous blocks of memory. This could lead to more cache misses, which will increase access time.

## Pros & Cons
**Advantages of the queue :**

-   Queues have the advantages of being able to manage large amounts of data, as well as being quick and flexible.

-   Queues have the benefit of being able to handle a variety of data kinds and being both flexible and speedy.

**Disadvantages of the queue :**

-   Queue disadvantages include the need to delete other elements in order to add a new element to the queue.

-   There is no easy way to search the queue.

-   It's also difficult to add or remove pieces from the midst of the queue.


## Key points

-   Queue takes a FIFO strategy, an element added first must also be removed first.
-   Enqueue inserts an element to the back of the queue.
-   Dequeue removes the element at the front of the queue.
-   Elements in an array are laid out in contiguous memory blocks, whereas elements in a linked list are more scattered with potential for cache misses.
-   A ring buffer based queue implementation is useful for queues with a fixed size.
-   Compared to other data structures, leveraging two stacks improves the  `dequeue()`  time complexity to an amortized  _O_(1) operation.
-   The double-stack implementation beats linked list in terms of spatial locality.

## 📒 References 
[Programiz - Queue](https://www.programiz.com/dsa/queue)\
[GeeksForGeeks - Queue](https://www.geeksforgeeks.org/queue-data-structure/?ref=gcse)\
[Raywenderlich - Queue](https://www.raywenderlich.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/5-queues#toc-chapter-008-anchor-001)
