package Chap05.LinkList2


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

    fun find(key: Int): Link? {
        var current = first

        while (current!!.iData != key) {
            if (current.next == null) {
                return null
            } else {
                current = current.next
            }
        }
        return current
    }

    fun delete(key: Int): Link? {
        var current = first
        var previous = first

        while (current!!.iData != key) {
            if (current.next == null) {
                return null
            } else {
                previous = current
                current = current.next

            }
        }

        if (current == first) {
            first = first!!.next
        } else {
            previous!!.next = current.next
        }

        return current
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

    val f = theList.find(44)          // find item
    if (f != null)
        println("Found link with key " + f.iData)
    else
        println("Can't find link")

    val d = theList.delete(66)        // delete item
    if (d != null)
        println("Deleted link with key " + d.iData)
    else
        println("Can't delete link")

    theList.displayList()              // displa
}