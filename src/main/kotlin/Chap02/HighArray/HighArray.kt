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

    // programs 2.1
    fun getMax(): Long {
        a.max()

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

    /**
     * Program 2.2
     */
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

    /**
     * Program 2.6
     *
     * First version. At first all pretenders are marked by unreal number and then all marked
     * elements are deleted.
     */
    fun noDups() {

        //mark all pretenders by unreal number
        for (i in 0 until nElems) {
            val pretender = a[i]

            for (j in i+1 until nElems) {
                if (a[j] == pretender) {
                    a[j] = -9999
                }
            }
        }

        println("Intermediate array")
        display()

        var pos = 0

        for (i in 0 until nElems) {
            if (a[i] == -9999L){
                break
            }
            pos ++
        }

        if (pos == nElems) {
            return
        }


        var offset = 1

        for (k in pos until nElems) {

            while ((k + offset < nElems) && (a[k + offset] == -9999L)) {
                offset++
            }

            if (k + offset >= nElems) {
                nElems -= offset
                return
            } else {
                a[k] = a[k + offset]
            }
        }

    }

    /**
     * Program 2.6
     *
     * Second version.
     */
    fun noDupsV2() {
        for (i in 0 until nElems) {
            val pretender = a[i]

            var position = i + 1

            for (j in i+1 until nElems) {
                if (a[j] == pretender) {
                    break
                }
                position ++
            }

            if (position == nElems) {
                continue
            }

            var offset = 1

            for (k in position until nElems) {

                while ((k + offset < nElems) && (a[k + offset] == pretender)) {
                    offset++
                }

                if (k + offset >= nElems) {
                    nElems -= offset
                    break
                } else {
                    a[k] = a[k + offset]
                }
            }
        }
    }
}

fun main(args: Array<String>) {
//    main_1(args)
//    main_2(args)
//    main_3(args)
    main_4(args)
}


/**
 * Default
 */
private fun main_1(args: Array<String>) {

    val maxSize = 100

    val arr = HighArray(maxSize)

    arr.insert(77)
    arr.insert(99)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)

    arr.display()

    val searchKey = 35L
    if (arr.find(searchKey))
        println("Found " + searchKey)
    else
        println("Can't find " + searchKey)

    arr.delete(0)
    arr.delete(55)
    arr.delete(99)

    arr.display()


    // programs 2.1
    println("Max value ${arr.getMax()}")

    // programs 2.3



}

/**
 * Program 2.1
 */
private fun main_2(args: Array<String>) {

    val maxSize = 100

    val arr = HighArray(maxSize)

    arr.insert(77)
    arr.insert(99)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)


    println("Max value ${arr.getMax()}")


}

/**
 * Program 2.3
 */
private fun main_3(args: Array<String>) {

    val maxSize = 100

    val arr = HighArray(maxSize)

    arr.insert(77)
    arr.insert(99)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)


    val sortedArr = HighArray(maxSize)

    for (i in 0 until arr.getSize()) {
        sortedArr.insert(arr.removeMax())
    }

    println("Sorted array")
    sortedArr.display()
}


/**
 * Program 2.6
 */
private fun main_4(args: Array<String>) {

    val maxSize = 10

    val arr = HighArray(maxSize)

    arr.insert(77)
    arr.insert(16)
    arr.insert(16)
    arr.insert(37)
    arr.insert(1)
    arr.insert(4)
    arr.insert(22)
    arr.insert(77)
    arr.insert(77)
    arr.insert(16)


    println("Source array")
    arr.display()

    arr.noDupsV2()

    println("No dups array")
    arr.display()
}
