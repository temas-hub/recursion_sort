import java.util.*


fun <T> Deque<T>.isEmpty(): Boolean  = this.isEmpty()

fun <T> Deque<T>.push(x: T) = this.addFirst(x)

fun <T> Deque<T>.pop(): T = this.removeFirst()

fun <T> Deque<T>.top(): T = this.first