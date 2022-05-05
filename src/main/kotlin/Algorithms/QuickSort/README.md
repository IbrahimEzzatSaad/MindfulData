
# What is QuickSort???
![enter image description here](https://i.imgur.com/LmrZQOI.png)
Quicksort is  [a sorting algorithm](https://www.programiz.com/dsa/sorting-algorithm)  based on the  **divide and conquer approach**  where

1.  An array is divided into subarrays by selecting a  **pivot element**  (element selected from the array).  
      
    While dividing the array, the pivot element should be positioned in such a way that elements less than pivot are kept on the left side and elements greater than pivot are on the right side of the pivot.
2.  The left and right subarrays are also divided using the same approach. This process continues until each subarray contains a single element.
3.  At this point, elements are already sorted. Finally, elements are combined to form a sorted array.

----------

### Working of Quicksort Algorithm

[GeeksForGeeks - video](https://www.youtube.com/watch?v=PgBzjlCcFvc)
**1. Select the Pivot Element**

There are different variations of quicksort where the pivot element is selected from different positions. Here, we will be selecting the rightmost element of the array as the pivot element.

![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/7qpYqe1UtqYbKzIBY_W8ljqkUz9iS6jZGobim6LDhtM/mtime:1582112622/sites/tutorial2program/files/quick-sort-0.1_0.png "Selection of rightmost element")

Select a pivot element

**2. Rearrange the Array**

Now the elements of the array are rearranged so that elements that are smaller than the pivot are put on the left and the elements greater than the pivot are put on the right.

![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/1Xn_e4xeHQjOsXExVhTgVbggPgpMk9WV4Z8gxmZgdyg/mtime:1582112622/sites/tutorial2program/files/quick-sort-0.2_0.png "pivoting")

Put all the smaller elements on the left and greater on the right of pivot element

Here's how we rearrange the array:

1.  A pointer is fixed at the pivot element. The pivot element is compared with the elements beginning from the first index.
    
    ![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/zaN86RZ0WfV0PhWpWDhis-f9lWlfgKJt_liYoGjZAIk/mtime:1617189498/sites/tutorial2program/files/quick-sort-partition-first-step.png "Quick Sort Steps")
    
    Comparison of pivot element with element beginning from the first index
    
2.  If the element is greater than the pivot element, a second pointer is set for that element.
    
    ![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/RzFeResnC88JRu9IFh2YqUKZMXltQ51EeiioINCMcEA/mtime:1617189487/sites/tutorial2program/files/quick-sort-partition-second-step.png "Quick Sort Steps")
    
    If the element is greater than the pivot element, a second pointer is set for that element.
    
3.  Now, pivot is compared with other elements. If an element smaller than the pivot element is reached, the smaller element is swapped with the greater element found earlier.
    
    ![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/QA-TsXFkcz3cNyJikcbIWxepFVDu8ntl220KzlG8zdw/mtime:1617189492/sites/tutorial2program/files/quick-sort-partition-third-step.png "Quick Sort Steps")
    
    Pivot is compared with other elements.
    
4.  Again, the process is repeated to set the next greater element as the second pointer. And, swap it with another smaller element.
    
    ![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/tMmdAbX5gev9K20XI1kzQ3n932vSjnN1MszZouHV7Yc/mtime:1617189469/sites/tutorial2program/files/quick-sort-partition-fourth-step.png "Quick Sort Steps")
    
    The process is repeated to set the next greater element as the second pointer.
    
5.  The process goes on until the second last element is reached.
    
    ![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/MNYV977xf4N3cgCpAtkB1KDyPqyG9OvlKSkHSdd0kys/mtime:1617189475/sites/tutorial2program/files/quick-sort-partition-fifth-step.png "Quick Sort Steps")
    
    The process goes on until the second last element is reached.
    
6.  Finally, the pivot element is swapped with the second pointer.
    
    ![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/lAMcHRRzL8TJEh7bjY3rAufTTy3y5-o4Nt0z5L1AB8A/mtime:1617189481/sites/tutorial2program/files/quick-sort-partition-sixth-step.png "Quick Sort Steps")
    
    Finally, the pivot element is swapped with the second pointer.
    

**3. Divide Subarrays**

Pivot elements are again chosen for the left and the right sub-parts separately. And,  **step 2**  is repeated.

![Quick Sort Steps](https://cdn.programiz.com/cdn/farfuture/dK3pGyiHqFZOYklwABPBZ4zq_VZU1dMWBIbWhHJ-Rgw/mtime:1617189464/sites/tutorial2program/files/quick-sort_1.png "Quick Sort Steps")

Select pivot element of in each half and put at correct place using recursion

The subarrays are divided until each subarray is formed of a single element. At this point, the array is already sorted.
## ⏲ Time Complexity
Even though you get the benefit of in-memory sorting, the performance of heap sort is O(n log n) for its best, worse and average cases.

This is because you have to traverse the whole array once and, every time you swap elements, you must perform a sift down, which is an O(log n) operation.

Heap sort is also not a stable sort because it depends on how the elements are laid out and put into the heap. If you were heap sorting a deck of cards by their rank, for example, you might see their suite change order with respect to the original deck.
## Key points
-  Heap sort leverages the max-heap data structure to sort elements in an array.
-  Heap sort sorts its elements by following a simple pattern: swap the first and last element, perform a sift-down, decrease the array size by one; then repeat.
-  The performance of heap sort is O(n log n) for its best, worse and average cases.
## 📒 References 
[Programiz - Quick Sort](https://www.programiz.com/dsa/quick-sort)
