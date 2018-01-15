package Chap05.SortedList

import Chap05.FirstLastList.Link

/**
 * Created by shushper on 05.02.17.
 */
class Link(var dData: Long) {

    var next: Link? = null

    fun displayLink() {
        print("$dData ")
    }
}


class SortedList {
    private var first: Link? = null

    fun isEmpty(): Boolean {
        return first == null
    }

    fun insert(key: Long) {
        val newLink = Link(key)

        var previous: Link? = null
        var current: Link? = first

        while (current!!.next != null && current.dData < key) {
            previous = current
            current = current.next
        }

        if (previous == null) {
            first = newLink
        } else {
            previous.next = newLink
        }

        newLink.next = current
    }

    fun remove(): Link {
        val temp = first
        first = temp!!.next
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
    val theSortedList = SortedList()
    theSortedList.insert(20)    // insert 2 items
    theSortedList.insert(40)

    theSortedList.displayList() // display list

    theSortedList.insert(10)    // insert 3 more items
    theSortedList.insert(30)
    theSortedList.insert(50)

    theSortedList.displayList() // display list

    theSortedList.remove()      // remove an item

    theSortedList.displayList() // display list
}