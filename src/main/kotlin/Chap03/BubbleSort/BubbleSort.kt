package Chap03.BubbleSort

/**
 * Created by shushper on 04.02.17.
 */
class ArrayBub(max: Int) {

    val a: LongArray = LongArray(max)
    var nElems: Int = 0


    fun insert(value: Long) {
        a[nElems] = value
        nElems++
    }


    fun display() {

        for (i in 0 until nElems) {
            print("${a[i]} ")
        }

        println()
    }

    fun bubbleSort() {

        for (outer in nElems - 1 downTo 1) {
            for (inner in 0 until outer) {
                if (a[inner] > a [inner + 1]) {
                    swap(inner, inner + 1)
                }
            }
        }
    }

    inline fun swap(one: Int, two: Int) {
        val temp = a[one]
        a[one] = a[two]
        a[two] = temp
    }


}

fun main(args: Array<String>) {

    var arr = ArrayBub(100)

    arr.insert(99)               // insert 10 items
    arr.insert(77)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)

    arr.display()                // display items

    arr.bubbleSort()             // bubble sort them

    arr.display()                // display them again

}