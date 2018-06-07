import java.util.*

private val stack = LinkedList<Int>()
private val result = LinkedList<Int>()

fun main(args: Array<String>) {
    stack.push(-3)
    stack.push(18)
    stack.push(-5)
    stack.push(30)
    stack.push(-2)

    sort (stack)
    print(result)
}


fun sort(s: Deque<Int>) {
    if (s.isEmpty()) return

    val curr = stack.top()
    sort(stack, curr)
    sort(s)
}

fun sort(s: Deque<Int>, min : Int): Int {
    if (s.isEmpty()) return min
    var cur = s.pop()

    val newMin = sort(s,  Math.min(cur, min))

    if (cur != newMin)
        s.push(cur)
    else
        result.push(cur)
    return newMin
}




