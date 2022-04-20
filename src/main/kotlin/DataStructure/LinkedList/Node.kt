data class Node<T>(var value: T, var next: Node<T> ? = null) {

    override fun toString(): String {

        return if(next != null){
            "$value ----> ${next.toString()}"
        }
        else "$value"

    }



    /*Challenge 1: Reverse a linked list
     This function forwards the call to the recursive function that traverses the list, node by node. To traverse the list, add this extension function for Node*/
    fun <T> Node<T>.printInReverse() {
        this.next?.printInReverse()
        // 1-First, you check if you’ve reached the end of the list. That’s the beginning of the reverse printing, and you’ll not add an arrow there.
        // The arrows start with the second element of the reverse output. This is just for pretty formatting.
        if (this.next != null) {
            print(" -> ")
        }
        // 2-As the recursive statements unravel, the node data gets printed.
        print(this.value.toString())
    }



}