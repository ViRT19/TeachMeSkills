fun anagramma() {
    val a: String = "hvdjksavklsad vlsavg"
    val b: String = "vhdjksavklsad vlsavg"
    a.uppercase()
    b.uppercase()
    var chA = a.toList().sorted()
    var chB = b.toList().sorted()
    if (chA == chB) println("Aнаграмма") else println("Это не анаграмма")
}
/*
Задача 1: Группировка анаграмм
          Дан список слов. Нужно сгруппировать слова, которые являются анаграммами.
          {"listen", "silent", "enlist", "java", "avaj", "world"}
Задача 2: Поиск первого повторяющегося числа
          Дан список чисел, нужно найти первое число, которое повторяется.
 */

fun main() {
    anagramma()
}