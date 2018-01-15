package Chap05.LinkList

/**
 * Created by shushper on 05.02.17.
 */
class Link(var iData: Int, var dData: Double) {

    var next: Link? = null

    fun displayLink() {
        print("{$iData, $dData} ")
    }
}

class LinkList {
    private var first: Link? = null

    fun isEmpty(): Boolean {
        return first == null
    }

    fun insertFirst(id: Int, dd: Double) {
        val newLink = Link(id, dd)
        newLink.next = first
        first = newLink
    }

    fun deleteFirst(): Link? {
        if (isEmpty()) {
            return null
        }

        val temp = first
        first = first!!.next
        return temp
    }

    fun displayList() {
        print("List (first --> last): ")
        var current = first

        while (current != null) {
            current.displayLink()
            current = current.next
        }
        println("")
    }
}

fun main(args: Array<String>) {
    val theList = LinkList()  // make new list

    theList.insertFirst(22, 2.99)      // insert four items
    theList.insertFirst(44, 4.99)
    theList.insertFirst(66, 6.99)
    theList.insertFirst(88, 8.99)

    theList.displayList()              // display list

    while (!theList.isEmpty())
    // until it's empty,
    {
        val aLink = theList.deleteFirst()   // delete link
        print("Deleted ")         // display it
        aLink!!.displayLink()
        println("")
    }
    theList.displayList()              //
}