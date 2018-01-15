package Chap05.FirstLastList


/**
 * Created by shushper on 05.02.17.
 */
class Link(var dData: Long) {

    var next: Link? = null

    fun displayLink() {
        print("$dData ")
    }
}


class FirstLastList {
    private var first: Link? = null
    private var last: Link? = null


    fun isEmpty(): Boolean {
        return first == null
    }

    fun insertFirst(dd: Long) {
        val newLink = Link(dd)

        if (isEmpty()) {
            last = newLink
        }

        newLink.next = first
        first = newLink
    }

    fun insertLast(dd: Long) {
        val newLink = Link(dd)

        if (isEmpty()) {
            first = newLink
        } else {
            last?.next = newLink
        }

        last = newLink
    }


    fun deleteFirst(): Long {

        val temp = first!!.dData
        if (first!!.next == null) {
            last = null
        }

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
    val theList = FirstLastList()

    theList.insertFirst(22)       // insert at front
    theList.insertFirst(44)
    theList.insertFirst(66)

    theList.insertLast(11)        // insert at rear
    theList.insertLast(33)
    theList.insertLast(55)

    theList.displayList()         // display the list

    theList.deleteFirst()         // delete first two items
    theList.deleteFirst()

    theList.displayList()
}