fun anagramm(a: String, b: String): Boolean {
    a.uppercase()
    b.uppercase()
    var chA = a.toList().sorted()
    var chB = b.toList().sorted()
    if (chA == chB)
        return true
    else
        return false
}
/*
Задача 1: Группировка анаграмм
          Дан список слов. Нужно сгруппировать слова, которые являются анаграммами.
          {"listen", "silent", "enlist", "java", "avaj", "world"}
Задача 2: Поиск первого повторяющегося числа
          Дан список чисел, нужно найти первое число, которое повторяется.
 */

fun main() {
    println("Задание 1. Найти анаграммы из списка: «listen», «silent», «enlist», «java», «avaj», «world».")
    val list = listOf<String>("listen", "silent", "enlist", "java", "avaj", "world")
    for (i in 0..list.size - 1)
        for (j in 1..list.size - 1)
            if (anagramm(list[i], list[j]) and (list[i].toList() != list[j].toList()))
                println("Анаграммы: «${list[i]}» и «${list[j]}».")

    println("Задание 2. Найти первое повторяющееся число из списка чисел.")
    val listNum = listOf<Int>(4, 6, 8, 6, 5, 3, 4, 6, 7, 56, 5, 4, 5, 6, 6, 5, 4, 3, 2, 2, 4, 5, 6, 67, 7)
    for (i in 0..listNum.size - 1)
        for (j in 1..listNum.size - 1)
            if (listNum[i] == listNum[j]) {
                println("Первое повторяющееся число = ${listNum[i]}")
                return
            }
}