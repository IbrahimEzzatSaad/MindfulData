package Algorithms.DepthFirstSearch

/**
 * The Algorithms.DepthFirstSearch.Stack interface.
 */
interface Stack<T: Any> {

  /**
   * Push of an T into the stack.Algorithms.DepthFirstSearch.Stack
   */
  fun push(element: T)

  /**
   * Pops an element from the stack.Algorithms.DepthFirstSearch.Stack if any or returns null.
   */
  fun pop(): T?

  val count: Int
    get

  fun peek(): T?

  val isEmpty: Boolean
    get() = count == 0
}


/**
 * Simple stack.Algorithms.DepthFirstSearch.Stack implementation using an ArrayList
 */
class StackImpl<T: Any> : Stack<T> {

  private val storage = arrayListOf<T>()

  companion object {
    fun <T: Any> create(items: Iterable<T>): Stack<T> {
      val stack = StackImpl<T>()
      for (item in items) {
        stack.push(item)
      }
      return stack
    }
  }

  override fun push(element: T) {
    storage.add(element)
  }

  override fun pop(): T? {
    if (isEmpty) {
      return null
    }
    return storage.removeAt(count - 1)
  }

  override fun peek(): T? {
    return storage.lastOrNull()
  }

  override val count: Int
    get() = storage.size

  override fun toString() = buildString {
    appendLine("----top----")
    storage.asReversed().forEach {
      appendLine("$it")
    }
    appendLine("-----------")
  }
}

fun <T: Any> stackOf(vararg elements: T): Stack<T> {
  return StackImpl.create(elements.asList())
}
