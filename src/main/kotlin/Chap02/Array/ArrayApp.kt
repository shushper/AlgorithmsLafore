package Chap02.Array

/**
 * Created by shushper on 30.01.17.
 */

fun main(args: Array<String>) {
    ArrayApp().main()
}


class ArrayApp {

    fun main() {
        val arr: LongArray          // reference to array
        arr = LongArray(100)        // make array
        var nElems: Int = 0;        // number of items
        var j: Int = 0              // loop counter
        var searhkKey: Long         // key of item search for
//-----------------------------------------------------------
        arr[0] = 77                 // insert 10 items
        arr[1] = 99
        arr[2] = 44
        arr[3] = 55
        arr[4] = 22
        arr[5] = 88
        arr[6] = 11
        arr[7] = 0
        arr[8] = 66
        arr[9] = 33
        nElems = 10                 // now 10 items in arrya
//-----------------------------------------------------------
        for (index in 0 until nElems){     // display items
            print("${arr[index]} ")
        }
        println("")
//-----------------------------------------------------------
        j = 0
        searhkKey = 100                      // find item with key 66
        for (index in 0 until nElems) {     // for each element,
            if (arr[index] == searhkKey) {  // found item?
                break                       // yes, exit before end
            }
            j++
        }

        if (j == nElems) {                      // at the end
            println("Can't find " + searhkKey)  //yes
        } else {
            println("Found $searhkKey at index $j")       //no
        }
//-----------------------------------------------------------
        j = 0
        searhkKey = 55                          // delete item with key 55
        for (index in 0 until nElems) {         // look for it
            if (arr[index] == searhkKey) {
                break
            }
            j++
        }

        for (k in j until nElems) {             // move higher ones down
            arr[k] = arr[k + 1]
        }
        nElems--                                // decrement size
//--------------------------------------------------------------
        for (index in 0 until nElems) {         // display items
            print("${arr[index]} ")
        }
        println()
    }
}