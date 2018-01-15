package Chap05.LinkQueue

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


class FirstLastList {
    private var first: Link? = null
    private var last: Link? = null


    fun isEmpty(): Boolean {
        return first == null
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
        var current = first

        while (current != null) {
            current.displayLink()
            current = current.next
        }
        println("")
    }
}


class LinkQueue {
    private val theList = FirstLastList()

    fun isEmpty(): Boolean {
        return theList.isEmpty()
    }

    fun insert(j: Long) {
        theList.insertLast(j)
    }

    fun remove(): Long {
        return theList.deleteFirst()
    }

    fun displayQueue() {
        print("Queue (front-->rear): ")
        theList.displayList()
    }
}

fun main(args: Array<String>) {
    val theQueue = LinkQueue()
    theQueue.insert(20)                 // insert items
    theQueue.insert(40)

    theQueue.displayQueue()             // display queue

    theQueue.insert(60)                 // insert items
    theQueue.insert(80)

    theQueue.displayQueue()             // display queue

    theQueue.remove()                   // remove items
    theQueue.remove()

    theQueue.displayQueue()             // display queue
}