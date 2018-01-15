package Chap05.InterIterator

import Chap05.FirstLastList.Link
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


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


    fun getFirst(): Link? {
        return first
    }

    fun setFirst(f: Link?) {
        first = f
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    fun getIterator(): ListIterator {
        return ListIterator(this)
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

class ListIterator(val ourList: LinkList) {
    private var current: Link? = null
    private var previous: Link? = null

    fun reset() {
        current = ourList.getFirst()
        previous = null
    }

    fun atEnd(): Boolean {
        return current?.next == null
    }

    fun nextLink() {
        previous = current
        current = current?.next
    }

    fun getCurrent(): Link? {
        return current
    }

    fun insertAfter(dd: Long) {
        val newLink = Link(dd)

        if (ourList.isEmpty()) {

            ourList.setFirst(newLink)
            current = newLink

        } else {

            newLink.next = current?.next
            current?.next = newLink
            nextLink()
        }
    }

    fun insertBefore(dd: Long) {
        val newLink = Link(dd)

        if (previous == null) {

            newLink.next = ourList.getFirst()
            ourList.setFirst(newLink)
            reset()

        } else {

            newLink.next = previous?.next
            previous?.next = newLink
            current = newLink
        }
    }

    fun deleteCurrent(): Long? {
        val value = current?.dData

        if (previous == null) {

            ourList.setFirst(current?.next)
            reset()

        } else {

            previous?.next = current?.next
            if (atEnd())
                reset()
            else
                current = current?.next

        }

        return value
    }
}

fun main(args: Array<String>) {
    val theList = LinkList()           // new list
    val iter1 = theList.getIterator()  // new iter
    var value: Long

    iter1.insertAfter(20)             // insert items
    iter1.insertAfter(40)
    iter1.insertAfter(80)
    iter1.insertBefore(60)

    while (true) {
        print("Enter first letter of show, reset, ")
        print("next, get, before, after, delete: ")
        System.out.flush()
        val choice = getChar()       // get user's option
        when (choice) {
            's' -> {
                if (!theList.isEmpty())
                    theList.displayList()
                else
                    println("List is empty")
            }
            'r' -> iter1.reset()
            'n' -> {
                if (!theList.isEmpty() && !iter1.atEnd())
                    iter1.nextLink()
                else
                    println("Can't go to next link")
            }
            'g' -> {
                if (!theList.isEmpty()) {
                    value = iter1.getCurrent()!!.dData
                    println("Returned " + value)
                } else
                    println("List is empty")
            }
            'b' -> {
                print("Enter value to insert: ")
                System.out.flush()
                value = getInt().toLong()
                iter1.insertBefore(value)
            }
            'a' -> {
                print("Enter value to insert: ")
                System.out.flush()
                value = getInt().toLong()
                iter1.insertAfter(value)
            }
            'd' -> {
                if (!theList.isEmpty()) {
                    value = iter1.deleteCurrent()!!
                    println("Deleted " + value)
                } else
                    println("Can't delete")
            }
            else -> println("Invalid entry")

        }  // end switch
    }  // end while
}

//--------------------------------------------------------------
@Throws(IOException::class)
fun getString(): String {
    val isr = InputStreamReader(System.`in`)
    val br = BufferedReader(isr)
    val s = br.readLine()
    return s
}

//-------------------------------------------------------------
@Throws(IOException::class)
fun getChar(): Char {
    val s = getString()
    return s[0]
}

//-------------------------------------------------------------
@Throws(IOException::class)
fun getInt(): Int {
    val s = getString()
    return Integer.parseInt(s)
}
//-------------------------------------------------------------