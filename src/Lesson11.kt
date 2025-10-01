import java.util.LinkedList

/*
Задача 1: Последний оставшийся элемент (LinkedList)
          В круге из n человек каждый 2-й выбывает, пока не останется один. Используйте LinkedList для моделирования.
Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)
          Даны два отсортированных LinkedList, нужно слить их в один отсортированный список.
 */
fun main() {
    val ll: LinkedList<Int> = LinkedList(listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    var iter: MutableIterator<Int> = ll.iterator()
    var i: Int = 0
    while (ll.size > 1) {
        try {
            iter.next()
            i++
            if (i % 2 == 0)
                iter.remove()
            println(ll.toString())
        } catch (e: NoSuchElementException) {
            ll.peekFirst()
        }
    }
}