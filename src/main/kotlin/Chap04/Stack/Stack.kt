package Chap04.Stack

/**
 * Created by shushper on 04.02.17.
 */
class StackX(val maxSize: Int) {

    val stackArray = LongArray(maxSize)
    var top = -1

    fun push(value: Long) {
        stackArray[++top] = value
    }

    fun pop(): Long {
        return stackArray[top--]
    }

    fun peek(): Long {
        return stackArray[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isFull(): Boolean {
        return top == maxSize - 1
    }
}

fun main(args: Array<String>) {
    val theStack = StackX(10)  // make new stack
    theStack.push(20)               // push items onto stack
    theStack.push(40)
    theStack.push(60)
    theStack.push(80)

    while (!theStack.isEmpty()) {                             // delete item from stack
        val value = theStack.pop()
        print(value)
        print(" ")
    }
    println("")
}