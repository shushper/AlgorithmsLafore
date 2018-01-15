package Chap02.ClassData

/**
 * Created by shushper on 03.02.17.
 */
class Person(val last: String, val firstName: String, val age: Int) {

    fun displayPerson() {
        print("   Last name: " + last)
        print(", First name: " + firstName)
        println(", Age: " + age)
    }
}


internal class ClassDataArray(max: Int) {
    private val a: Array<Person?> = kotlin.arrayOfNulls<Person?>(max)
    private var nElems: Int = 0


    fun find(searchName: String): Person? {
        var j = 0
        while (j < nElems) {

            if (a[j]?.last == searchName)
                break
            j++
        }
        if (j == nElems)
            return null
        else
            return a[j]
    }

    //--------------------------------------------------------------                                    // put person into array
    fun insert(last: String, first: String, age: Int) {
        a[nElems] = Person(last, first, age)
        nElems++                          // increment size
    }

    //--------------------------------------------------------------
    fun delete(searchName: String): Boolean {                              // delete person from array
        var j = 0
        while (j < nElems) {
            // look for it
            if (a[j]?.last == searchName)
                break
            j++
        }
        if (j == nElems)
        // can't find it
            return false
        else
        // found it
        {
            for (k in j..nElems - 1)
            // shift down
                a[k] = a[k + 1]
            nElems--                       // decrement size
            return true
        }
    }  // end delete()

    //--------------------------------------------------------------
    fun displayA()            // displays array contents
    {
        for (j in 0..nElems - 1)
        // for each element,
            a[j]?.displayPerson()          // display it
    }
    //--------------------------------------------------------------
}  // end class ClassDataArray

fun main(args: Array<String>) {
    val maxSize = 100             // array size
    val arr: ClassDataArray            // reference to array
    arr = ClassDataArray(maxSize)  // create the array
    // insert 10 items
    arr.insert("Evans", "Patty", 24)
    arr.insert("Smith", "Lorraine", 37)
    arr.insert("Yee", "Tom", 43)
    arr.insert("Adams", "Henry", 63)
    arr.insert("Hashimoto", "Sato", 21)
    arr.insert("Stimson", "Henry", 29)
    arr.insert("Velasquez", "Jose", 72)
    arr.insert("Lamarque", "Henry", 54)
    arr.insert("Vang", "Minh", 22)
    arr.insert("Creswell", "Lucinda", 18)

    arr.displayA()                // display items

    val searchKey = "Stimson"  // search for item
    val found: Person?
    found = arr.find(searchKey)
    if (found != null) {
        print("Found ")
        found.displayPerson()
    } else
        println("Can't find " + searchKey)

    println("Deleting Smith, Yee, and Creswell")
    arr.delete("Smith")           // delete 3 items
    arr.delete("Yee")
    arr.delete("Creswell")

    arr.displayA()                // display items again
}  // end main()
