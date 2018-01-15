package Chap04.Infix

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by shushper on 05.02.17.
 */
class StackX(val maxSize: Int) {

    private val stackArray = CharArray(maxSize)
    private var top = -1

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


    fun size(): Int {
        return top + 1
    }

    fun isFull(): Boolean {
        return top == maxSize - 1
    }

    fun peekN(n: Int): Char {
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

class InToPost(val input: String) {

    private val theStack: StackX = StackX(input.length)
    private var output = ""

    fun doTrans(): String {
        for (j in 0 until input.length) {
            val ch = input[j]
            theStack.displayStack("For $ch ")

            when (ch) {
                '+', '-' -> gotOper(ch, 1)
                '*', '/' -> gotOper(ch, 2)
                '(' -> theStack.push(ch)
                ')' -> gotParen(ch)
                else -> output += ch
            }
        }

        while (theStack.isNotEmpty()) {
            theStack.displayStack("While ")
            output += theStack.pop()
        }

        theStack.displayStack("End ")
        return output
    }

    fun gotOper(opThis: Char, prec1: Int) {
        while (theStack.isNotEmpty()) {
            val opTop = theStack.pop()

            if (opTop == '(') {
                theStack.push(opTop)
                break
            } else {
                var prec2: Int

                if (opTop == '+' || opTop == '-') {
                    prec2 = 1
                } else {
                    prec2 = 2
                }

                if (prec2 < prec1) {
                    theStack.push(opTop)
                    break
                } else {
                    output += opTop
                }
            }
        }

        theStack.push(opThis)
    }

    fun gotParen(ch: Char) {
        while (theStack.isNotEmpty()) {
            val chx = theStack.pop()
            if (chx == '(') {
                break
            } else {
                output += chx
            }
        }
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

        val theTrans = InToPost(input)
        val output = theTrans.doTrans()
        println("Reversed: " + output)
    }
}

fun getString(): String {
    val isr = InputStreamReader(System.`in`)
    val br = BufferedReader(isr)
    val s = br.readLine()
    return s
}