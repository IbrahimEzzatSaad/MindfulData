
# What is Merge Sort???
![enter image description here](https://pics.me.me/thumb_0-bubble-sort-you-guys-always-act-like-youre-better-45912067.png)\
Merge Sort is one of the most popular  [sorting algorithms](https://www.programiz.com/dsa/sorting-algorithm)  that is based on the principle of  [Divide and Conquer Algorithm](https://www.programiz.com/dsa/divide-and-conquer).

Here, a problem is divided into multiple sub-problems. Each sub-problem is solved individually. Finally, sub-problems are combined to form the final solution.
![enter image description here](https://www.ejneer.com/post/mergesort_files/figure-html/plot-mergesort-1.gif)

## Divide and Conquer Strategy

Using the  **Divide and Conquer**  technique, we divide a problem into subproblems. When the solution to each subproblem is ready, we 'combine' the results from the subproblems to solve the main problem.

Suppose we had to sort an array  A. A subproblem would be to sort a sub-section of this array starting at index  p  and ending at index  r, denoted as  A[p..r].

**Divide**

If q is the half-way point between p and r, then we can split the subarray  A[p..r]  into two arrays  A[p..q]  and  A[q+1, r].

**Conquer**

In the conquer step, we try to sort both the subarrays  A[p..q]  and  A[q+1, r]. If we haven't yet reached the base case, we again divide both these subarrays and try to sort them.

**Combine**

When the conquer step reaches the base step and we get two sorted subarrays  A[p..q]  and  A[q+1, r]  for array  A[p..r], we combine the results by creating a sorted array  A[p..r]  from two sorted subarrays  A[p..q]  and  A[q+1, r].
## ⏲ Time Complexity
The best, worst and average time complexity of merge sort is O(n log n), which isn’t too bad. If you’re struggling to understand where n log n comes from, think about 
how the recursion works:
-  As you recurse, you split a single list into two smaller lists. This means a list of size 2 will need one level of recursion, a list of size 4 will need two levels, a list of size 8 will need three levels, and so on. If you had a list of 1,024 elements, it would take 10 levels of recursively splitting in two to get down to 1024 single element lists. In general, if you have a list of size n, the number of levels is log2(n).
-  A single recursion level will merge n elements. It doesn’t matter if there are many small merges or one large one; the number of elements merged will still be n at each level. This means the cost of a single recursion is O(n). 

This brings the total cost to O(log n) ×O(n) = O(n log n).

The previous chapter’s sort algorithms were in-place and used swapAt to move elements around. Merge sort, by contrast, allocates additional memory to do its work. How much? There are log2(n) levels of recursion, and at each level, n elements are used. That makes the total O(n log n) in space complexity. Merge sort is one of 
the hallmark sorting algorithms. It’s relatively simple to understand, and serves as a great introduction to how to divide and conquer algorithms work. Merge sort is O(n log n), and this implementation requires O(n log n) of space. If you’re clever with your bookkeeping, you can reduce the memory required to O(n) by discarding the 
memory that is not actively being used.
## Key points
-  Merge sort is in the category of the divide and conquer algorithms.
-  There are many implementations of merge sort, and you can have different performance characteristics depending on the implementation.
- To do a comparison, in this chapter you sorted objects implementing the Comparable<T> interface but the same can be done providing a different implementation of Comparator<T>.

## 📒 References 
[Programiz - merge sort](https://www.programiz.com/dsa/merge-sort)\
[GeeksForGeeks - Merge Sort](https://www.geeksforgeeks.org/merge-sort/)
What is Merge Sort???
enter image description here
Merge Sort is one of the most popular sorting algorithms that is based on the principle of Divide and Conquer Algorithm.

Here, a problem is divided into multiple sub-problems. Each sub-problem is solved individually. Finally, sub-problems are combined to form the final solution.
enter image description here

Divide and Conquer Strategy
Using the Divide and Conquer technique, we divide a problem into subproblems. When the solution to each subproblem is ready, we ‘combine’ the results from the subproblems to solve the main problem.

Suppose we had to sort an array A. A subproblem would be to sort a sub-section of this array starting at index p and ending at index r, denoted as A[p…r].

Divide

If q is the half-way point between p and r, then we can split the subarray A[p…r] into two arrays A[p…q] and A[q+1, r].

Conquer

In the conquer step, we try to sort both the subarrays A[p…q] and A[q+1, r]. If we haven’t yet reached the base case, we again divide both these subarrays and try to sort them.

Combine

When the conquer step reaches the base step and we get two sorted subarrays A[p…q] and A[q+1, r] for array A[p…r], we combine the results by creating a sorted array A[p…r] from two sorted subarrays A[p…q] and A[q+1, r].

⏲ Time Complexity
The best, worst and average time complexity of merge sort is O(n log n), which isn’t too bad. If you’re struggling to understand where n log n comes from, think about
how the recursion works:

As you recurse, you split a single list into two smaller lists. This means a list of size 2 will need one level of recursion, a list of size 4 will need two levels, a list of size 8 will need three levels, and so on. If you had a list of 1,024 elements, it would take 10 levels of recursively splitting in two to get down to 1024 single element lists. In general, if you have a list of size n, the number of levels is log2(n).
A single recursion level will merge n elements. It doesn’t matter if there are many small merges or one large one; the number of elements merged will still be n at each level. This means the cost of a single recursion is O(n).
This brings the total cost to O(log n) ×O(n) = O(n log n).

The previous chapter’s sort algorithms were in-place and used swapAt to move elements around. Merge sort, by contrast, allocates additional memory to do its work. How much? There are log2(n) levels of recursion, and at each level, n elements are used. That makes the total O(n log n) in space complexity. Merge sort is one of
the hallmark sorting algorithms. It’s relatively simple to understand, and serves as a great introduction to how to divide and conquer algorithms work. Merge sort is O(n log n), and this implementation requires O(n log n) of space. If you’re clever with your bookkeeping, you can reduce the memory required to O(n) by discarding the
memory that is not actively being used.

Key points
Merge sort is in the category of the divide and conquer algorithms.
There are many implementations of merge sort, and you can have different performance characteristics depending on the implementation.
To do a comparison, in this chapter you sorted objects implementing the Comparable interface but the same can be done providing a different implementation of Comparator.
📒 References
Programiz - merge sort
GeeksForGeeks - Merge Sort

Markdown 3824 bytes 600 words 44 lines Ln 43, Col 67HTML 2710 characters 582 words 28 paragraphs
