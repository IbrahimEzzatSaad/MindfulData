package Algorithms.MergeSort

/*--------------------Challenge 1: Iterables merge--------------------
* Write a function that takes two sorted iterables and merges them into a single iterable.
* -----------------------Solution-----------------------------
* The tricky part of this challenge is the limited capabilities of Iterable. Traditional
implementations of this algorithm rely on the abilities of List types to keep track of indices.
Since Iterable types have no notion of indices, you’ll make use of their iterator.
*  The Iterator in Kotlin has a slight inconvenience that you need to fix first. If there are
no more elements in the iterable and you try to get the next one using next(), you’ll
get a NoSuchElementException. */
fun <T : Comparable<T>> merge(
    first: Iterable<T>,
    second: Iterable<T>
): Iterable<T> {

    /*1-Create a new container to store the merged iterable. It could be any class that
        implements Iterable but a MutableList is an easy to use choice, so go with
        that one. Then, grab the iterators of the first and second iterable. Iterators
        sequentially dispense values of the iterable via next(), but you’ll use your own extension nextOrNull().*/
    val result = mutableListOf<T>()

    //2-Create two variables that are initialized as the first and second iterator’s first value.
    val firstIterator = first.iterator()
    val secondIterator = second.iterator()

    //3-If one of the iterators didn’t have a first value, it means the iterable it came from was empty, and you’re done sorting. Simply return the other iterable.
    if (!firstIterator.hasNext()) return second
    if (!secondIterator.hasNext()) return first

    var firstEl = firstIterator.nextOrNull()
    var secondEl = secondIterator.nextOrNull()

    //4-This first while loop is where all of the comparisons are made to get the resulting iterable ordered. It only works while you still have values in both iterables.
    while (firstEl != null && secondEl != null) {
        //Using the iterators, you’ll decide which element should be appended into the result list by comparing the first and second next values.
        when {
            /*If the first value is less than the second, you’ll append the first value in result
            and seed the next value to be compared with by invoking nextOrNull() on the first iterator.*/
            firstEl < secondEl -> {
                result.add(firstEl)
                firstEl = firstIterator.nextOrNull()
            }
            /*If the second value is less than the first, you’ll do the opposite. You seed the next
            value to be compared by invoking nextOrNull() on the second iterator.*/
            secondEl < firstEl -> {
                result.add(secondEl)
                secondEl = secondIterator.nextOrNull()
            }
            else -> {
                /*If they’re equal, you append both the first and second values and seed both next values.*/
                result.add(firstEl)
                result.add(secondEl)
                firstEl = firstIterator.nextOrNull()
                secondEl = secondIterator.nextOrNull()
            }
        }
    }

    while (firstEl != null) {
        result.add(firstEl)
        firstEl = firstIterator.nextOrNull()
    }
    while (secondEl != null) {
        result.add(secondEl)
        secondEl = secondIterator.nextOrNull()
    }

    return result
}

//In order to avoid the null on next for the Iterator we write this extension function
private fun <T> Iterator<T>.nextOrNull(): T? {
    return if (this.hasNext()) this.next() else null
}