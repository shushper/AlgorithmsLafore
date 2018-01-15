package Chap02.HighArray

/**
 * Created by shushper on 31.01.17.
 */
class HighArray(max: Int) {

    private var a = LongArray(max)
    private var nElems: Int = 0

    fun find(searchKey: Long): Boolean {

        for (i in 0 until nElems) {
            if (a[i] == searchKey) {
                return true
            }
        }

        return false
    }

    fun insert(value: Long) {
        a[nElems] = value
        nElems++
    }

    fun delete(value: Long): Boolean {

        var j = 0

        for (i in 0 until nElems) {
            if (value == a[i]) {
                break
            }
            j++
        }

        if (j == nElems) {
            return false
        } else {

            for (k in j until nElems) {
                a[k] = a[k + 1]
            }
            nElems--
            return true
        }

    }

    fun display() {

        for (i in 0 until nElems) {
            print("${a[i]} ")
        }

        println()
    }

    fun getMax(): Long {
        if (nElems == 0) {
            return -1
        }


        var max = a[0]


        for (i in 1 until nElems) {
            if (a[i] > max) {
                max = a[i]
            }
        }


        return max
    }

    fun removeMax(): Long {

        if (nElems == 0) {
            return -1
        }


        var max = a[0]
        var maxIndex = 0

        for (i in 1 until nElems) {
            if (a[i] > max) {
                max = a[i]
                maxIndex = i
            }
        }

        for (k in maxIndex until nElems) {
            a[k] = a[k + 1]
        }
        nElems--

        return max
    }

    fun getSize(): Int {
        return nElems
    }

}

fun main(args: Array<String>) {
    val maxSize = 100           // array size

    val arr = HighArray(maxSize) // create the array

    arr.insert(77)               // insert 10 items
    arr.insert(99)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)

    arr.display()                // display items

    println("Max value ${arr.getMax()}")

    val searchKey = 35L           // search for item
    if (arr.find(searchKey))
        println("Found " + searchKey)
    else
        println("Can't find " + searchKey)

    arr.delete(0)               // delete 3 items
    arr.delete(55)
    arr.delete(99)

    arr.display()               // display items again


    println("Max value ${arr.getMax()}")

    val sortedArr = HighArray(maxSize)

    for (i in 0 until arr.getSize()) {
        sortedArr.insert(arr.removeMax())
    }

    println("Sorted array")
    sortedArr.display()


}  // end main()
