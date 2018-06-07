import java.util.*

private val input = LinkedList<Int>()

fun main(args: Array<String>) {
    input.push(-3)
    input.push(18)
    input.push(-5)
    input.push(30)
    input.push(-2)
    input.push(-3)
    input.push(500)
    input.push(-5)
    input.push(30)
    input.push(-2)
    input.push(1)
    input.push(18)
    input.push(-5)
    input.push(30)
    input.push(-2)

    print(splitMerge(input, false))
}


fun splitMerge(s: Deque<Int>, dir: Boolean): Deque<Int> {
    if (s.size < 2) return s

    val half = LinkedList<Int>()
    copyHalf(s, half)

    val result = LinkedList<Int>()
    collect(splitMerge(half, !dir),
            splitMerge(s, !dir),
            result, dir)
    return result
}

fun copyHalf(from: Deque<Int>, r: Deque<Int>) {
    if (from.size > r.size) {
        r.push(from.pop())
        copyHalf(from, r)
    }
}

fun collect (l: Deque<Int>, r: Deque<Int>, result: Deque<Int>, dir: Boolean) {
    if (r.isEmpty() && l.isEmpty()) return

    when {
        l.isEmpty() -> result.push(r.pop())
        r.isEmpty() -> result.push(l.pop())
        (l.top() < r.top()).xor(dir) -> result.push(l.pop())
        else -> result.push(r.pop())
    }
    collect(l, r, result, dir)
}
