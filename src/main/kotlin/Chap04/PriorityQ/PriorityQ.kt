package Chap04.PriorityQ

/**
 * Created by shushper on 04.02.17.
 */
class PriorityQ(val maxSize: Int) {

    private val queArray = LongArray(maxSize)
    private var nItems: Int = 0


    fun insert(item: Long) {

        if (nItems == 0) {
            queArray[nItems++] = item
        } else {

            var j = nItems - 1

            while (j >= 0) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j]
                } else {
                    break
                }
                j--
            }

            queArray[j + 1] = item
            nItems++
        }
    }

    fun remove(): Long {

        return queArray[--nItems]
    }

    fun peekFront(): Long {
        return queArray[nItems - 1]
    }

    fun isEmpty(): Boolean {
        return (nItems == 0)
    }

    fun isFull(): Boolean {
        return nItems == maxSize
    }


}

fun main(args: Array<String>) {
    val thePQ = PriorityQ(5)
    thePQ.insert(30)
    thePQ.insert(50)
    thePQ.insert(10)
    thePQ.insert(40)
    thePQ.insert(20)

    while (!thePQ.isEmpty()) {
        val item = thePQ.remove()
        print("$item ")  // 10, 20, 30, 40, 50
    }  // end while
    println("")
}