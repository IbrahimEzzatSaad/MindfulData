
# What is BinarySearch???
![enter image description here](https://preview.redd.it/z8g8xg2dekk51.jpg?auto=webp&s=74eb5607d552bf67c19535a2b7c23ea5da415f13)\
As the photo suggest this binary search get the half of the list and it has to be stored cause he will see which half is bigger or smaller than the value its searching for.

Binary search is one of the most efficient searching algorithms with a time 
complexity of O(log n). This is comparable with searching for an element inside a balanced binary search tree.
Two conditions need to be met before you can use binary search:
-  The collection must be able to perform index manipulation in constant time. 
Kotlin collections that can do this include the Array and the ArrayList.
-  The collection must be sorted.

![enter image description here](https://c.tenor.com/Jl0YrqxnHmAAAAAd/binary-search-sequence-search.gif)


## Pros & Cons
**Advantages**:

-   Compared to linear search (checking each element in the array starting from the first), binary search is much faster. Linear search takes, on average N/2 comparisons (where N is the number of elements in the array), and worst case N comparisons. Binary search takes an average and worst-case log2(N)log2(N) comparisons. So for a million elements, linear search would take an average of 500,000 comparisons, whereas binary search would take 20.
-   It’s a fairly simple algorithm, though people get it wrong all the time.
-   It’s well known and often implemented for you as a library routine.

**Disadvantages**:

-   It’s more complicated than linear search, and is overkill for very small numbers of elements.
-   It works only on lists that are sorted and kept sorted. That is not always feasable, especially if elements are constantly being added to the list.
-   It works only on element types for which there exists a less-than relationship. Some types simply cannot be sorted (though this is rare).
-   There is a great lost of efficiency if the list does not support random-access. You need, for example, to immediately jump to the middle of the list. If your list is a plain array, that’s great. If it’s a linked-list, not so much. Depending on the cost of your comparison operation, the cost of traversing a non-random-access list could dwarf the cost of the comparisons.
-   There are even faster search methods available, such as hash lookups. However a hash lookup requires the elements to be organized in a much more complicated data structure (a hash table, not a list).

## Key points
-  Binary search is only a valid algorithm on sorted collections.
-  Sometimes, it may be beneficial to sort a collection just to leverage the binary search capability for looking up elements.
-  The indexOf method of arrays uses linear search, which has an O(n) time 
complexity. Binary search has an O(log n) time complexity, which scales much better for large data sets.

## 📒 References 
[GeeksForGeeks - BinarySearch](https://www.geeksforgeeks.org/binary-search/)\
[Quora - Advantages and disadvantages](https://www.quora.com/What-are-the-advantages-and-disadvantages-of-binary-search)\
[Programiz - BinarySearch](https://www.programiz.com/dsa/binary-search)
