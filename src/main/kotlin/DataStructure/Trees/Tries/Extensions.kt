package DataStructure.Trees.Tries


/*These extension functions are only applicable to tries that store lists of characters.
    They hide the extra toList() calls you need to pass in a String, allowing you to
    simplify the  code*/
fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}

fun Trie<Char>.contains(string: String): Boolean {
    return contains(string.toList())
}

fun Trie<Char>.remove(string: String) {
    remove(string.toList())
}

/*This extension maps the input string into a list of characters, and then maps the lists
in the result of the collections() call back to strings.*/
fun Trie<Char>.collections(prefix: String): List<String> {
    return collections(prefix.toList()).map { it.joinToString(separator = "") }
}