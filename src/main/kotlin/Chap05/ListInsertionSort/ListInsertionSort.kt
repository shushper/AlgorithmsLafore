package Chap05.ListInsertionSort

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

    constructor(linkArr: Array<Link>) {
        for (link in linkArr) {
            insert(link)
        }
    }


    fun insert(k: Link) {
        var previous: Link? = null
        var current: Link? = first

        while (current != null && current.dData < k.dData) {
            previous = current
            current = current.next
        }

        if (previous == null) {
            first = k
        } else {
            previous.next = k
        }

        k.next = current
    }

    fun remove(): Link {
        val temp = first
        first = temp!!.next
        return temp
    }


}

fun main(args: Array<String>) {
    val size = 10
    // create array of links
    val linkArray = Array(size) {
        val n = (java.lang.Math.random() * 99).toInt()
        Link(n.toLong())  // make link
    }


    // display array contents
    print("Unsorted array: ")
    for (j in 0..size - 1)
        print(linkArray[j].dData.toString() + " ")
    println("")

    // create new list
    val theSortedList = SortedList(linkArray)

    for (j in 0..size - 1)
    // links from list to array
        linkArray[j] = theSortedList.remove()

    // display array contents
    print("Sorted Array:   ")
    for (j in 0..size - 1)
        print(linkArray[j].dData.toString() + " ")
    println("")
}