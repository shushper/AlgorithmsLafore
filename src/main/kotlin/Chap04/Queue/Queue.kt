package Chap04.Queue

/**
 * Created by shushper on 04.02.17.
 */
class Queue(val maxSize: Int) {

    private val queArray = LongArray(maxSize)
    private var front: Int = 0
    private var rear: Int = -1
    private var nItems: Int = 0


    fun insert(j: Long) {
        if (rear == maxSize - 1) {
            rear = -1
        }

        queArray[++rear] = j
        nItems++
    }

    fun remove(): Long {

        val temp = queArray[front++]
        if (front == maxSize)
            front = 0

        nItems--
        return temp
    }

    fun peekFront(): Long {
        return queArray[front]
    }

    fun isEmpty(): Boolean {
        return (nItems == 0)
    }

    fun isFull(): Boolean {
        return nItems == maxSize
    }

    fun size(): Int {
        return nItems
    }
}

fun main(args: Array<String>) {

    val theQueue = Queue(5)  // queue holds 5 items

    theQueue.insert(10)            // insert 4 items
    theQueue.insert(20)
    theQueue.insert(30)
    theQueue.insert(40)

    theQueue.remove()              // remove 3 items
    theQueue.remove()              //    (10, 20, 30)
    theQueue.remove()

    theQueue.insert(50)            // insert 4 more items
    theQueue.insert(60)            //    (wraps around)
    theQueue.insert(70)
    theQueue.insert(80)

    while (!theQueue.isEmpty())    // remove and display
    {                            //    all items
        val n = theQueue.remove()  // (40, 50, 60, 70, 80)
        System.out.print(n)
        System.out.print(" ")
    }
    System.out.println("")

}