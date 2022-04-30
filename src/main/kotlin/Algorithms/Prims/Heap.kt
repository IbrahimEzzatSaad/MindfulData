package Algorithms.Prims

import java.util.Collections

interface Collection<T: Any> {
  val count: Int

  val isEmpty: Boolean
    get() = count == 0

  fun insert(element: T)

  fun remove(): T?

  fun remove(index: Int): T?
}


interface Heap<T: Any> : Collection<T> {

  fun peek(): T?
}

abstract class AbstractHeap<T: Any> : Heap<T> {
  var elements: ArrayList<T> = ArrayList()

  override val count: Int
    get() = elements.size

  override fun peek(): T? = elements.first()

  override fun insert(element: T) {
    elements.add(element)
    siftUp(count - 1)
  }

  private fun siftUp(index: Int) {
    var child = index
    var parent = parentIndex(child)
    while (child > 0 && compare(elements[child], elements[parent]) > 0) {
      Collections.swap(elements, child, parent)
      child = parent
      parent = parentIndex(child)
    }
  }

  override fun remove(): T? {
    if (isEmpty) return null

    Collections.swap(elements, 0, count - 1)
    val item = elements.removeAt(count - 1)
    siftDown(0)
    return item
  }

  private fun siftDown(index: Int) {
    var parent = index
    while (true) {
      val left = leftChildIndex(parent)
      val right = rightChildIndex(parent)
      var candidate = parent
      if (left < count &&
          compare(elements[left], elements[candidate]) > 0
      ) {
        candidate = left
      }
      if (right < count &&
          compare(elements[right], elements[candidate]) > 0
      ) {
        candidate = right
      }
      if (candidate == parent) {
        return
      }
      Collections.swap(elements, parent, candidate)
      parent = candidate
    }
  }

  override fun remove(index: Int): T? {
    if (index >= count) return null

    return if (index == count - 1) {
      elements.removeAt(count - 1)
    } else {
      Collections.swap(elements, index, count - 1)
      val item = elements.removeAt(count - 1)
      siftDown(index)
      siftUp(index)
      item
    }
  }

  private fun index(element: T, i: Int): Int? {
    if (i >= count) {
      return null
    }
    if (compare(element, elements[i]) > 0) {
      return null
    }
    if (element == elements[i]) {
      return i
    }
    val leftChildIndex = index(element, leftChildIndex(i))
    if (leftChildIndex != null) return leftChildIndex
    val rightChildIndex = index(element, rightChildIndex(i))
    if (rightChildIndex != null) return rightChildIndex
    return null
  }

  protected fun heapify(values: ArrayList<T>) {
    elements = values
    if (!elements.isEmpty()) {
      (count / 2 downTo 0).forEach {
        siftDown(it)
      }
    }
  }

  private fun leftChildIndex(index: Int) = (2 * index) + 1

  private fun rightChildIndex(index: Int) = (2 * index) + 2

  private fun parentIndex(index: Int) = (index - 1) / 2

  abstract fun compare(a: T, b: T): Int
}

class ComparableHeapImpl<T : Comparable<T>> :
    AbstractHeap<T>() {

  companion object {
    fun <T : Comparable<T>> create(
        elements: ArrayList<T>
    ): Heap<T> {
      val heap = ComparableHeapImpl<T>()
      heap.heapify(elements)
      return heap
    }
  }

  override fun compare(a: T, b: T): Int = a.compareTo(b)
}

class ComparatorHeapImpl<T: Any>(
    private val comparator: Comparator<T>
) : AbstractHeap<T>() {

  companion object {
    fun <T: Any> create(
        elements: ArrayList<T>,
        comparator: Comparator<T>
    ): Heap<T> {
      val heap = ComparatorHeapImpl(comparator)
      heap.heapify(elements)
      return heap
    }
  }

  override fun compare(a: T, b: T): Int =
      comparator.compare(a, b)
}
