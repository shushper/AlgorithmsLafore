package Chap04.Reverse

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by shushper on 04.02.17.
 */
class StackX(val maxSize: Int) {

    val stackArray = CharArray(maxSize)
    var top = -1

    fun push(value: Char) {
        stackArray[++top] = value
    }

    fun pop(): Char {
        return stackArray[top--]
    }

    fun peek(): Char {
        return stackArray[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isNotEmpty(): Boolean {
        return top > -1
    }

    fun isFull(): Boolean {
        return top == maxSize - 1
    }
}

class Reverser(val input: String) {
    private var output: String = ""


    fun doRev(): String {

        val stackSize = input.length
        val theStack = StackX(stackSize)

        for (j in 0 until input.length) {
            val ch = input[j]
            theStack.push(ch)
        }

        while (theStack.isNotEmpty()) {
            val ch = theStack.pop()
            output += ch
        }

        return output
    }

}

fun main(args: Array<String>) {

    while (true) {
        print("Enter a string: ")
        System.out.flush()

        val input = getString()

        if (input == "") {
            break
        }

        val theReverser = Reverser(input)
        val output = theReverser.doRev()
        println("Reversed: " + output)
    }
}

fun getString(): String {
    val isr = InputStreamReader(System.`in`)
    val br = BufferedReader(isr)
    val s = br.readLine()
    return s
}