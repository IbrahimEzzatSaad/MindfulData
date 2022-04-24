package DataStructure.Stack

import LinkedList
import example


/*--------------Stack Data Structures--------------*/
/* The stack data structure is identical, in concept, to a physical stack of objects.
    When you add an item to a stack, you place it on top of the stack.
    When you remove an item from a stack, you always remove the top-most item.


    Stacks are used prominently in all disciplines of programming, such as:

        * Android uses the fragment stack to push and pop fragments into and out of an Activity.
        * Memory allocation uses stacks at the architectural level. Memory for local variables is also managed using a stack.
        * Search and conquer algorithms, such as finding a path out of a maze, use stacks to facilitate backtracking.*/

/*--------------------------------------------Key points--------------------------------------------
   *   Despite its simplicity, the stack is a key data structure for many problems.
   *   The only two essential operations for the stack are the push method for adding elements and the pop method for removing elements.*/
    fun main(){


        "Simple use of stack" example {
            val stack = Stack<Int>().apply {
                push(1)
                push(2)
                push(3)
                push(4)
            }
            print(stack)
            val poppedElement = stack.pop()
            if (poppedElement != null) {
                println("Popped: $poppedElement")
            }
            print(stack)
        }




        "initializing a stack from a list" example{
        /*This code creates a stack of strings and pops the top element "D".
        Notice that the Kotlin compiler can type infer the element type from the list, so you can use Stack instead of the more verbose Stack<String>.*/
            val list = listOf("A", "B", "C", "D")
            val stack = Stack.create(list)
            print(stack)
            println("Popped: ${stack.pop()}")
        }







        "initializing a stack from an array literal" example{
        /*This creates a stack of Doubles and pops the top value 4.0.
        Again, type inference saves you from having to specify the generic type argument of the stackOf function call.*/
            val stack = stackOf(1.0, 2.0, 3.0, 4.0)
            print(stack)
            println("Popped: ${stack.pop()}")
        }


        /*Stacks are crucial to problems that search trees and graphs.
          Imagine finding your way through a maze.
          Each time you come to a decision point of left, right or straight, you can push all possible decisions onto your stack.
          When you hit a dead end, backtrack by popping from the stack and continuing until you escape or hit another dead end.*/






        "Challenge 1: Reverse a LinkedList" example{

        /* The time complexity of pushing the nodes into the stack is O(n).
         * The time complexity of popping the stack to print the values is also O(n).
         * Overall, the time complexity of this algorithm is O(n).
         * Since you’re allocating a container (the stack) inside the function, you also incur an O(n) space complexity cost.*/
            val list = LinkedList<Int>()
            list.add(1)
            list.add(2)
            list.add(3)
            list.add(4)
            list.add(5)
            list.printInReverse()
        }




        "Challenge 2: The parentheses validation" example{
        /* Check for balanced parentheses. Given a string, check if there are ( and ) characters, and return true if the parentheses in the string are balanced.
         * To check if there are balanced parentheses in the string, you need to go through each character of the string.
         * When you encounter an opening parenthesis, you’ll push that into a stack. Vice versa, if you encounter a closing parenthesis, you should pop the stack.*/
            var sting = "Hello()World("
            println(sting.checkParentheses())
            sting = "Hello()World()"
            println(sting.checkParentheses())
        }

    }


    /*---------------Challenge 1: Reverse a LinkedList---------------*/
    /*One of the prime use cases for stacks is to facilitate backtracking.
      If you push a sequence of values into the stack, sequentially popping the stack will give you the
      values in reverse order*/
    fun <T : Any> LinkedList<T>.printInReverse() {
        val stack = Stack<T>()

        //1- Copy the content of the list into a stack, carefully putting the nodes on top of each other.
        for (node in this) {
            stack.push(node)
        }

        //2-Remove and print the nodes from the stack one by one, starting from the top.
        var node = stack.pop()
        while (node != null) {
            println(node)
            node = stack.pop()
        }
    }



       /* Challenge 2: The parentheses validation
        * Check for balanced parentheses. Given a string, check if there are ( and ) characters, and return true if the parentheses in the string are balanced.
        * To check if there are balanced parentheses in the string, you need to go through each character of the string.
        * When you encounter an opening parenthesis, you’ll push that into a stack. Vice versa, if you encounter a closing parenthesis, you should pop the stack.*/
    fun String.checkParentheses(): Boolean {
        //1- Create a new stack and start going through your string, character by character.
        val stack = Stack<Char>()

        for (character in this) {
            when (character) {
                //2-Push every opening parenthesis into the stack.
                '(' -> stack.push(character)
                //3-Pop one item from the stack for every closing parenthesis, but if you’re out of items on the stack, your string is already imbalanced, so you can immediately return from the function.
                ')' -> if (stack.isEmpty) {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
        // 4-In the end, a balanced string is one that has popped all of the opening parentheses it’s pushed (and not a single item more).
        // That would leave the stack empty because you popped all the parentheses you pushed before.
        return stack.isEmpty


        /*The time complexity of this algorithm is O(n), where n is the number of characters in the string.
          This algorithm also incurs an O(n) space complexity cost due to the usage of the Stack data structure.*/
    }