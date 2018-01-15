package Chap04.Postfix

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by shushper on 05.02.17.
 */
class StackX(val maxSize: Int) {

    private val stackArray = IntArray(maxSize)
    private var top = -1

    fun push(value: Int) {
        stackArray[++top] = value
    }

    fun pop(): Int {
        return stackArray[top--]
    }

    fun peek(): Int {
        return stackArray[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isNotEmpty(): Boolean {
        return top > -1
    }


    fun size(): Int {
        return top + 1
    }

    fun isFull(): Boolean {
        return top == maxSize - 1
    }

    fun peekN(n: Int): Int {
        return stackArray[n]
    }

    fun displayStack(s: String) {
        print(s)
        print("Stack (bottom-->top): ")
        for (j in 0 until size()) {
            print(peekN(j))
            print(' ')
        }
        println("")
    }
}

class ParsePost(val input: String) {

    private var theStack: StackX = StackX(0)

    fun doParse(): Int {
        theStack = StackX(20)

        for (j in 0 until input.length) {

            val ch = input[j]
            theStack.displayStack("$ch ")

            if (ch >= '0' && ch <= '9') {
                theStack.push(ch - '0')
            } else {
                val num2 = theStack.pop()
                val num1 = theStack.pop()
                var interAns: Int

                when (ch) {
                    '+' -> interAns = num1 + num2
                    '-' -> interAns = num1 - num2
                    '*' -> interAns = num1 * num2
                    '/' -> interAns = num1 / num2
                    else -> interAns = 0
                }

                theStack.push(interAns)
            }

        }

        val interAns = theStack.pop()
        return interAns
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

        val aParser = ParsePost(input)
        val output = aParser.doParse()
        println("Evaluates to: " + output)
    }
}

fun getString(): String {
    val isr = InputStreamReader(System.`in`)
    val br = BufferedReader(isr)
    val s = br.readLine()
    return s
}