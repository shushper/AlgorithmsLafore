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

    fun merge(arr2: OrderedArray): OrderedArray {
        val arr1 = this
        val mergedArraySize = arr1.size() + arr2.size()

        val mergedArray = OrderedArray(mergedArraySize)

        var pointer1 = 0
        var pointer2 = 0

        for (pointer in 0 until mergedArraySize) {

            if (pointer1 < arr1.size() && pointer2 < arr2.size()) {
                if (arr1.a[pointer1] < arr2.a[pointer2]) {
                    mergedArray.insert(arr1.a[pointer1])
                    pointer1++
                } else {
                    mergedArray.insert(arr2.a[pointer2])
                    pointer2++
                }
            } else if (pointer1 < arr1.size()) {
                mergedArray.insert(arr1.a[pointer1])
                pointer1++
            } else {
                mergedArray.insert(arr2.a[pointer2])
                pointer2++
            }

        }

        return mergedArray
    }


}

fun main(args: Array<String>) {
//    main_1(args)
    main_2(args)
}

/**
 * Default
 */
private fun main_1(args: Array<String>) {

    val maxSize = 100

    val arr = OrderedArray(maxSize)

    arr.insert(77)
    arr.insert(22)
    arr.insert(44)
    arr.insert(55)
    arr.insert(99)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)

    arr.display()

    val searchKey = 80L
    if (arr.find(searchKey) != arr.size())
        System.out.println("Found " + searchKey)
    else
        System.out.println("Can't find " + searchKey)

    arr.delete(0)
    arr.delete(55)
    arr.delete(99)

    arr.display()
}

/**
 * Programs 2.5
 */
private fun main_2(args: Array<String>) {

    val arr1 = OrderedArray(7)
    arr1.insert(23)
    arr1.insert(16)
    arr1.insert(43)
    arr1.insert(91)
    arr1.insert(22)
    arr1.insert(1)
    arr1.insert(9)

    val arr2 = OrderedArray(5)
    arr2.insert(19)
    arr2.insert(33)
    arr2.insert(54)
    arr2.insert(6)
    arr2.insert(88)

    val mergedArray = arr1.merge(arr2)

    arr1.display()
    arr2.display()
    mergedArray.display()
}