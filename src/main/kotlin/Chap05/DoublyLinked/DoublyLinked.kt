package Chap05.DoublyLinked


/**
 * Created by shushper on 05.02.17.
 */
class Link(var dData: Long) {

    var next: Link? = null
    var previous: Link? = null

    fun displayLink() {
        print("$dData ")
    }
}

class DoublyLinkedList {
    private var first: Link? = null
    private var last: Link? = null

    fun isEmpty(): Boolean {
        return first == null
    }

    fun insertFirst(dd: Long) {
        val newLink = Link(dd)

        if (isEmpty()) {
            last = newLink
        } else {
            first!!.previous = newLink
        }
        newLink.next = first
        first = newLink
    }

    fun insertLast(dd: Long) {
        val newLink = Link(dd)

        if (isEmpty()) {
            first = newLink
        } else {
            last!!.next = newLink
            newLink.previous = last
        }

        last = newLink
    }

    fun deleteFirst(): Link? {
        val temp = first

        if (first!!.next == null) {
            last == null
        } else {
            first!!.next!!.previous = null
        }

        first = first!!.next
        return temp
    }

    fun deleteLast(): Link? {
        val temp = last

        if (last!!.previous == null) {
            first == null
        } else {
            last!!.previous!!.next = null
        }

        last = last!!.previous
        return temp
    }

    fun insertAfter(key: Long, dd: Long): Boolean {
        var current = first

        while (current!!.dData != key) {
            current = current.next

            if (current == null) {
                return false
            }
        }

        val newLink = Link(dd)

        if (current == last) {
            newLink.next = null
            last = newLink
        } else {
            newLink.next = current.next
            current.next!!.previous = newLink
        }

        newLink.previous = current
        current.next = newLink
        return true
    }

    fun deleteKey(key: Long): Link? {
        var current = first

        while (current!!.dData != key) {
            current = current.next

            if (current == null) {
                return null
            }
        }

        if (current == first) {
            first = current.next
        } else {
            current.previous!!.next = current.next
        }

        if (current == last) {
            last = current.previous
        } else {
            current.next!!.previous = current.previous
        }

        return current
    }

    fun displayForward() {
        print("List (first-->last): ")
        var current = first          // start at beginning
        while (current != null)
        // until end of list,
        {
            current.displayLink()      // display data
            current = current.next     // move to next link
        }
        println("")

    }

    fun displayBackward() {
        print("List (last-->first): ")
        var current = last           // start at end
        while (current != null)
        // until start of list,
        {
            current.displayLink()      // display data
            current = current.previous // move to previous link
        }
        println("")
    }
}

fun main(args: Array<String>) {
    val theList = DoublyLinkedList()

    theList.insertFirst(22)      // insert at front
    theList.insertFirst(44)
    theList.insertFirst(66)

    theList.insertLast(11)       // insert at rear
    theList.insertLast(33)
    theList.insertLast(55)

    theList.displayForward()     // display list forward
    theList.displayBackward()    // display list backward

    theList.deleteFirst()        // delete first item
    theList.deleteLast()         // delete last item
    theList.deleteKey(11)        // delete item with key 11

    theList.displayForward()     // display list forward

    theList.insertAfter(22, 77)  // insert 77 after 22
    theList.insertAfter(33, 88)  // insert 88 after 33

    theList.displayForward()     // display list forward
}
