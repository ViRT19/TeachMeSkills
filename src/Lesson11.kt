import java.util.LinkedList

/*
Задача 1: Последний оставшийся элемент (LinkedList)
          В круге из n человек каждый 2-й выбывает, пока не останется один. Используйте LinkedList для моделирования.
Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)
          Даны два отсортированных LinkedList, нужно слить их в один отсортированный список.
 */
fun main() {
    println("Задание 1.")
    var i: Int = 1
    val ll: LinkedList<Int> = LinkedList(listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9))
    //    var iter: MutableIterator<Int> = ll.iterator()

    while (ll.size > 1) {
        if (i % 2 == 0) {
            ll.remove(ll[i - 1])
            println(ll)
        }
        if (ll.size <= i) {
            i = 1
            println("Круг пройден. Результат: $ll")
        }
        i++
    }
    /***************************************************************************************/
    println("Задание 2.")
    val ll1: LinkedList<Int> = LinkedList(listOf<Int>(1, 3, 5, 7, 9))
    val ll2: LinkedList<Int> = LinkedList(listOf<Int>(0, 2, 4, 6, 8))
    println("List1 = $ll1")
    println("List2 = $ll2")
    i = 0
    while (i < ll1.size) {
        ll2.add(ll1[i])
        ll2.sort()
        i++
    }
    println("United list = $ll2")
}