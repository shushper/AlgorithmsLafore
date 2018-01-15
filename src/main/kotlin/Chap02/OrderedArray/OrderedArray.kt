package Chap02.HighArray

/**
 * Created by shushper on 31.01.17.
 */
class OrderedArray(max: Int) {

    private var a = LongArray(max)
    private var nElems: Int = 0


    fun size(): Int {
        return nElems
    }


    fun find(searchKey: Long): Int {

        var lowerBound = 0
        var upperBound = nElems - 1
        var curIn: Int

        while (true) {
            curIn = (lowerBound + upperBound) / 2

            if (a[curIn] == searchKey) {
                return curIn
            } else if (lowerBound > upperBound) {
                return nElems
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1
                } else {
                    upperBound = curIn - 1
                }
            }

        }
    }


    fun insert(value: Long) {

        val insertIndex = getInsertIndex(value)


        for (index in nElems downTo (insertIndex + 1)) {
            a[index] = a[index - 1]
        }

        a[insertIndex] = value
        nElems++

    }

    private fun getInsertIndex(value: Long): Int {

        // binary search
        if (nElems == 0) {
            return 0
        }

        var lowerBound = 0
        var upperBound = nElems - 1
        var curIn: Int

        while (true) {
            curIn = (lowerBound + upperBound) / 2

            if (a[curIn] == value) {
                return curIn
            } else if (lowerBound > upperBound) {
                if (a[curIn] < value) {
                    return curIn + 1
                }
                return curIn
            } else {
                if (a[curIn] < value) {
                    lowerBound = curIn + 1
                } else {
                    upperBound = curIn - 1
                }
            }
        }


        // linear search
//        var j: Int = 0
//        for (index in 0 until nElems) {
//            if (a[index] > value) {
//                break
//            }
//            j++
//        }
//
//        for (index in nElems downTo (j + 1)) {
//            a[index] = a[index - 1]
//        }
//
//        a[j] = value
//        nElems++

    }

    fun delete(value: Long): Boolean {

        val j = find(value)

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


}

fun main(args: Array<String>) {
    val maxSize = 100           // array size

    val arr = OrderedArray(maxSize) // create the array

    arr.insert(77)               // insert 10 items
    arr.insert(22)
    arr.insert(44)
    arr.insert(55)
    arr.insert(99)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)

    arr.display()                // display items

    val searchKey = 55L           // search for item
    if (arr.find(searchKey) != arr.size())
        System.out.println("Found " + searchKey)
    else
        System.out.println("Can't find " + searchKey)

    arr.delete(0)               // delete 3 items
    arr.delete(55)
    arr.delete(99)

    arr.display()               // display items again
}  // end main()
