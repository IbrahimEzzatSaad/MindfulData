
# What is O(n2) Algorithms??
![enter image description here](https://miro.medium.com/max/552/0*DPKL62mAZbrS5qyt.jpg)\
O(n²) time complexity is not great performance, but the sorting algorithms in this category are easy to understand and useful in some scenarios. These algorithms are space efficient, and they only require constant O(1) additional memory space. For small data sets, these sorts compare favorably against more complex sorts. It’s usually not recommended to use O(n²) in production code, but you’ll need to start somewhere, and these algorithms are a great place to start.
In this chapter, you’ll look at the following sorting algorithms:
-  Bubble sort.
-  Selection sort.
-  Insertion sort.

All of these are comparison-based sorting methods. In other words, they rely on a comparison method, such as the less than operator, to order elements. You measure a sorting technique’s general performance by counting the number of times this comparison gets called.
![enter image description here](https://qph.fs.quoracdn.net/main-qimg-58dc29bc4966efe3ac20c6ae66088a12)

You will see the merge sort and heap and others in the next packages.

## Bubble Sort
One of the simplest sorts is the bubble sort. The bubble sort repeatedly compares adjacent values and swaps them, if needed, to perform the sort. The larger values in the set will, therefore, bubble up to the end of the collection.

### Working of Bubble Sort
Suppose we are trying to sort the elements in  **ascending order**.

**1. First Iteration (Compare and Swap)**

1.  Starting from the first index, compare the first and the second elements.
2.  If the first element is greater than the second element, they are swapped.
3.  Now, compare the second and the third elements. Swap them if they are not in order.
4.  The above process goes on until the last element.

**2. Remaining Iteration**

The same process goes on for the remaining iterations.

After each iteration, the largest element among the unsorted elements is placed at the end.
![enter image description here](https://www.resultswebdev.com/wp-content/themes/results-website-design/uploads/bubble-sort-animation2.gif)


## Selection sort
Selection sort follows the basic idea of bubble sort but improves upon this 
algorithm by reducing the number of swapAt operations. Selection sort only swaps at the end of each pass. 
![enter image description here](https://user-images.githubusercontent.com/56377217/145599472-aac4bd2f-d841-4ab1-945b-33b42c447dd5.gif)

## Insertion sort
Insertion sort is a more useful algorithm. Like bubble sort and selection sort, 
insertion sort has an average time complexity of O(n²), but the performance of 
insertion sort can vary. 

The more the data is already sorted, the less work it needs to do. Insertion sort has a best time complexity of O(n) if the data is already sorted.

![enter image description here](https://www.arabicprogrammer.com/images/548/4d4a4ee96b360815ba654de710a7c7a4.gif)

## ⏲ Time Complexity
### Bubble Sort Complexity
![enter image description here](https://i.imgur.com/WI7LML4.png)

### Selection Sort Complexity
![enter image description here](https://i.imgur.com/WO7F8ag.png)

### Insertion Sort Complexity
![enter image description here](https://i.imgur.com/a5N6NIw.png)
## Key points
- n² algorithms often have a terrible reputation, but some of these algorithms usually have some redeeming points. insertionSort can sort in O(n) time if the collection is already in sorted order and gradually scales down to O(n²).
- insertionSort is one of the best sorts in situations wherein you know ahead of time that your data is in sorted order.
- Design your algorithms to be as generic as possible without hurting the 
performance.


## 📒 References 
[Programiz - Bubble sort](https://www.programiz.com/dsa/bubble-sort)\
[Programiz - Selection sort](https://www.programiz.com/dsa/selection-sort)\
[Programiz - Insertion sort](https://www.programiz.com/dsa/insertion-sort)
