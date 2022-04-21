package DataStructure.Trees.Tries


/*------------------Trie------------------
* The trie (pronounced try) is a tree that specializes in storing data that can be
represented as a collection, such as English words:
* https://assets.alexandria.raywenderlich.com/books/dsk/images/afaa85b9353ee595a31b187138adf4be34f1347b7b1a3bd6d4b31b575ae28bef/original.png
* Each character in a string is mapped to a node. The last node in each string is marked
as a terminating node (a dot in the image above).
* The benefits of a trie are best illustrated by looking at it in the context of prefix matching.
* Explanation: https://www.youtube.com/watch?v=-urNrIAQnNo

* ----------------Key Point--------------
* Tries provide great performance metrics in regards to prefix matching.
* Tries are relatively memory efficient since individual nodes can be shared between
many different values. For example, “car”, “carbs”, and “care” can share the first three letters of the word.*/


class Trie<Key: Any> {

    /*-------------Challenge 1: Adding more features----------
    The current implementation of the trie is missing some notable operations. Your
        task for this challenge is to augment the current implementation of the trie by
        adding the following:
        1.   A lists property that returns all of the lists in the trie.
        2.   A count property that tells you how many lists are currently in the trie.
        3.   An isEmpty property that returns true if the trie is empty, false otherwise.

        ----------Solution----------

        For this solution, you’ll implement lists as a computed property. It’ll be backed by a private property named storedLists.

        storedLists is a set of the lists currently contained by the trie. Reading the lists
        property returns a list of these tries, which is created from the privately maintained set.*/
    private val storedLists: MutableSet<List<Key>> = mutableSetOf()

    val lists: List<List<Key>>
        get() = storedLists.toList()





    //Adding the count and isEmpty properties is straightforward now that you’re keeping track of the lists:
    val count: Int
        get() = storedLists.count()

    val isEmpty: Boolean
        get() = storedLists.isEmpty()

    private val root = TrieNode<Key>(key = null, parent = null)



    /*Tries work with lists of the Key type. The trie takes the list and represents it as a
    series of nodes in which each node maps to an element in the list.

    The time complexity for this algorithm is O(k), where k is the number of elements in
    the list you’re trying to insert. This is because you need to traverse through or create
    each node that represents each element of the new list.*/
    fun insert(list: List<Key>) {
        //1-current keeps track of your traversal progress, which starts with the root node.
        var current = root

        /*2-A trie stores each element of a list in separate nodes. For each element of the list,
            you first check if the node currently exists in the children map.
            If it doesn’t, you create a new node.
            During each loop, you move current to the next node.*/
        list.forEach { element ->
            val child = current.children[element] ?: TrieNode(element, current)
            current.children[element] = child
            current = child
        }

        /*3-After iterating through the for loop, current should be referencing the node
        representing the end of the list. You mark that node as the terminating node.*/
        current.isTerminating = true
        storedLists.add(list)
    }

    /*Here, you traverse the trie in a way similar to insert. You check every element of the list to see if it’s in the tree.
      When you reach the last element of the list, it must be a terminating element.

      If not, the list wasn’t added to the tree and what you’ve found is merely a subset of a larger list.

      The time complexity of contains is O(k), where k is the number of elements in the
      list that you’re looking for. This is because you need to traverse through k nodes to
      find out whether or not the list is in the trie.*/
    fun contains(list: List<Key>): Boolean {
        var current = root

        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }

        return current.isTerminating
    }


    /*Removing a node in the trie is a bit more tricky. You need to be particularly careful
        when removing each node since nodes can be shared between multiple different collections.

        The time complexity of this algorithm is O(k), where k represents the number of
        elements of the collection that you’re trying to remove.*/
    fun remove(list: List<Key>) {
        /* 1-This part should look familiar, as it’s basically the implementation of contains.
        You use it here to check if the collection is part of the trie and to point current to the last node of the collection.*/
        var current = root

        list.forEach { element ->
            val child = current.children[element] ?: return
            current = child
        }

        if (!current.isTerminating) return

        // 2-You set isTerminating to false so that the current node can be removed by the loop in the next step.
        current.isTerminating = false

        /* 3-This is the tricky part. Since nodes can be shared, you don’t want to carelessly
        remove elements that belong to another collection. If there are no other children
        in the current node, it means that other collections do not depend on the current node.
        */
        val parent = current.parent
        while (parent != null && current.children.isEmpty() && !current.isTerminating) {
            parent.children.remove(current.key)
            current = parent
        }
    }



    /*-----------Prefix Matching-----------
    * The most iconic algorithm for the trie is the prefix-matching algorithm.

    * collection() has a time complexity of O(k*m), where k represents the longest
        collection matching the prefix and m represents the number of collections that match the prefix.

    * Recall that arrays have a time complexity of O(k*n), where n is the number of elements in the collection.
        For large sets of data in which each collection is uniformly distributed, tries have far
        better performance as compared to using arrays for prefix matching.*/
    fun collections(prefix: List<Key>): List<List<Key>> {
        // 1-You start by verifying that the trie contains the prefix. If not, you return an empty list.
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        // 2-After you’ve found the node that marks the end of the prefix, you call a recursive helper method to find all of the sequences after the current node.
        return collections(prefix, current)
    }

    private fun collections(prefix: List<Key>, node: TrieNode<Key>?): List<List<Key>> {
        /* 1-You create a MutableList to hold the results.
         If the current node is a terminating node, you add the corresponding prefix to the results.*/
        val results = mutableListOf<List<Key>>()

        if (node?.isTerminating == true) {
            results.add(prefix)
        }

        /* 2-Next, you need to check the current node’s children. For every child node, you
             recursively call collections() to seek out other terminating nodes.*/
        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }

        return results
    }

}