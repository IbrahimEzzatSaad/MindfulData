package DataStructure.PriorityQueues


/*-------------Challenge 2: Sorting-------------
* Your favorite concert was sold out. Fortunately, there’s a waitlist for people who still want to go.
*  However, the ticket sales will first prioritize someone with a military background, followed by seniority.
* Write a sort function that returns the list of people on the waitlist by the appropriate priority.
*
* ------------------------Solution-------------------
* Given a list of people on the waitlist, you would like to prioritize the people in the following order:
   1. Military background.
   2. Seniority, by age.
The best solution for this problem is to put the previous logic into a Comparator<Person> implementation and then use the proper priority queue
implementation. In this way, you can give Person objects different priority providing different Comparator<Person> implementations.*/



data class Person(
    val name: String,
    val age: Int,
    val isMilitary: Boolean) {
    override fun toString() = name
}


object MilitaryPersonComparator : Comparator<Person> {
    override fun compare(o1: Person, o2: Person): Int {
        if (o1.isMilitary && !o2.isMilitary) {
            return 1
        } else if (!o1.isMilitary && o2.isMilitary) {
            return -1
        } else if (o1.isMilitary && o2.isMilitary) {
            return o1.age.compareTo(o2.age)
        }
        return 0
    }
}