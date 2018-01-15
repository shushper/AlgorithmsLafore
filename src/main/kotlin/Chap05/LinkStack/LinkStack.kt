package Chap05.LinkStack

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

class LinkList {
    private var first: Link? = null

    fun isEmpty(): Boolean {
        return first == null
    }

    fun insertFirst(dd: Long) {
        val newLink = Link(dd)
        newLink.next = first
        first = newLink
    }

    fun deleteFirst(): Long {
        val temp = first
        first = first!!.next
        return temp!!.dData
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

class LinkStack {
    private val theList = LinkList()

    fun push(j: Long) {
        theList.insertFirst(j)
    }

    fun pop(): Long {
        return theList.deleteFirst()
    }

    fun isEmpty(): Boolean {
        return theList.isEmpty()
    }

    fun displayStack() {
        print("Stack (top-->bottom): ")
        theList.displayList()
    }

}

fun main(args: Array<String>) {
    val theStack = LinkStack() // make stack

    theStack.push(20)                    // push items
    theStack.push(40)

    theStack.displayStack()              // display stack

    theStack.push(60)                    // push items
    theStack.push(80)

    theStack.displayStack()              // display stack

    theStack.pop()                       // pop items
    theStack.pop()

    theStack.displayStack()              // displays
}