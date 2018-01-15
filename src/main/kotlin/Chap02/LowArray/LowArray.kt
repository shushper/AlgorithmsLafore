package Chap02.LowArray

/**
 * Created by shushper on 31.01.17.
 */
class LowArray(size: Int) {
    private val a = LongArray(size)

    fun setElem(index: Int, value: Long) {
        a[index] = value
    }

    fun getElem(index: Int): Long {
        return a[index]
    }


}

fun main(args: Array<String>) {

    val arr = LowArray(100)
    var nElems = 0
    var j = 0


    arr.setElem(0, 77)           // insert 10 items
    arr.setElem(1, 99)
    arr.setElem(2, 44)
    arr.setElem(3, 55)
    arr.setElem(4, 22)
    arr.setElem(5, 88)
    arr.setElem(6, 11)
    arr.setElem(7, 0)
    arr.setElem(8, 66)
    arr.setElem(9, 33)
    nElems = 10

    for (index in 0 until nElems)
        print("${arr.getElem(index)} ")

    println()


    j = 0
    val searchKey = 26L
    for (index in 0 until nElems) {
        if (arr.getElem(index) == searchKey) {
            break
        }
        j++
    }

    if (j == nElems) {
        println("Can't find $searchKey")
    } else {
        println("Found $searchKey at index $j")
    }


    j = 0
    for (index in 0 until nElems) {
        if (arr.getElem(index) == 55L) {
            break
        }
        j++
    }

    for (index in j until nElems) {
        arr.setElem(index, arr.getElem(index + 1))
    }
    nElems--

    for (index in 0 until nElems) {
        print("${arr.getElem(index)} ")
    }

    println()

}