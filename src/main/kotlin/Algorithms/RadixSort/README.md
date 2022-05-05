
# What is Radix Sort???
![enter image description here](https://i.redd.it/hnnial6x6x411.jpg)\
Radix sort is  [a sorting algorithm](https://www.programiz.com/dsa/sorting-algorithm)  that sorts the elements by first grouping the individual digits of the same  **place value**. Then, sort the elements according to their increasing/decreasing order.

Suppose, we have an array of 8 elements. First, we will sort elements based on the value of the unit place. Then, we will sort elements based on the value of the tenth place. This process goes on until the last significant place.

Let the initial array be  `[121, 432, 564, 23, 1, 45, 788]`. It is sorted according to radix sort as shown in the figure below.

![Radix Sort Working](https://cdn.programiz.com/cdn/farfuture/GKQPB3dxbVfvYT3qiSZtTQDI5UOENnLr-oTPlCbYKaM/mtime:1582112622/sites/tutorial2program/files/Radix-sort-0_0.png "Working of Radix Sort")

Working of Radix Sort

![enter image description here](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9mdW5nbm90bC1pbWcub3NzLWNuLWhhbmd6aG91LmFsaXl1bmNzLmNvbS8lRTYlQTElQjYlRTYlOEUlOTIlRTUlQkElOEYvQ291bnRTb3J0LmdpZg)
## ⏲ Time Complexity
![enter image description here](https://i.imgur.com/2d0Qj7t.png)
## Key points
-  Radix sort is a non-comparative sort that doesn’t rely on comparing two values. 
Instead, it leverages bucket sort, which is like a sieve for filtering values. A helpful analogy is how some of the vending machines accept coins — the coins are distinguished by size.
-  This chapter covered the least significant digit radix sort. Another way to implement radix sort is the most significant digit form. This form sorts by prioritizing the most significant digits over the lesser ones and is best illustrated by the sorting behavior of the String type.
## 📒 References 
[Programiz - Radix Sort](https://www.programiz.com/dsa/radix-sort)
