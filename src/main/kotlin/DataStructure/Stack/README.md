
# What is Stack??
Stacks are everywhere. Some common examples of things you might stack:
•  Pancakes.
•  Books.
•  Paper.
•  Cash, especially cash. :]
The stack data structure is identical, in concept, to a physical stack of objects. 

When you add an item to a stack, you place it on top of the stack. When you remove an item from a stack, you always remove the top-most item.
![Cattie!](https://media1.giphy.com/media/aOqVDcqUQt1BK/200.gif)
A stack is a linear data structure that follows the principle of  **Last In First Out (LIFO)**. This means the last element inserted inside the stack is removed first.

You can think of the stack data structure as the pile of plates on top of another.

Here, you can:
-   Put a new plate on top
-   Remove the top plate

And, if you want the plate at the bottom, you must first remove all the plates on top. This is exactly how the stack data structure works.



## LIFO Principle of Stack
In programming terms, putting an item on top of the stack is called **push** and removing an item is called **pop**.
![Stack operations](https://cdn.programiz.com/sites/tutorial2program/files/stack.png)
In the above image, although item **3** was kept last, it was removed first. This is exactly how the **LIFO (Last In First Out) Principle** works.

## Basic Operations of Stack

There are some basic operations that allow us to perform different actions on a stack.

-   **Push**: Add an element to the top of a stack
-   **Pop**: Remove an element from the top of a stack
-   **IsEmpty**: Check if the stack is empty
-   **IsFull**: Check if the stack is full
-   **Peek**: Get the value of the top element without removing it

## Stack Time Complexity

For the array-based implementation of a stack, the push and pop operations take constant time, i.e.  `O(1)`.

## Pros & Cons
### Advantages of Stack

1.  **Efficient data management:** Stack helps you manage the data in a LIFO (last in, first out) method, which is not possible with a Linked list and array.
2.  **Efficient management of functions:** When a function is called, the local variables are stored in a stack, and it is automatically destroyed once returned.
3.  **Control over memory:** Stack allows you to control how memory is allocated and deallocated.
4.  **Smart memory management:** Stack automatically cleans up the object.
5.  **Not easily corrupted:** Stack does not get corrupted easily; hence it is more secure and reliable.
6.  **Does not allow resizing of variables:** Variables cannot be resized.

### Disadvantages of Stack

1.  **Limited memory size:** Stack memory is very limited.
2.  **Chances of stack overflow:** Creating too many objects on the stack can increase the risk of stack overflow.
3.  **Random access is not possible:** In a stack, random accessing the data is not possible.
4.  **Unreliable:** When variable storage will get overwritten, it will sometimes leads to undefined behaviour of the function or program.
5.  **Undesired termination:** The stack will fall outside of the memory area, which might lead to an abnormal termination.

## 📒 References 

[Programiz - Stack](https://www.programiz.com/dsa/stack)\
[GeeksForGeeks - Stack](https://www.geeksforgeeks.org/stack-data-structure/)\
[LearningMadesimple360 - Stack](https://learningmadesimple360.blogspot.com/2021/08/advantages-and-disadvantages-of-stack.html)
