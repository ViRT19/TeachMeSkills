/*fun main() {
    val lll = sequenceOf(1, 2, 3, 4, 5).map() {it*it}.toList()
    println(lll)
}

Задача 1: Напишите функцию, которая принимает список целых чисел и возвращает их сумму.
          Используйте лямбду в качестве параметра для определения операции. (Reduce).
Задача 2: Напишите программу, которая получает список людей, фильтрует только тех,
          кто старше 18 лет, затем сортирует их по возрасту в порядке убывания
          и выводит на экран с помощью apply и let. (sortedByDescending).
Задача 3: Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа, затем возведите их в квадрат
          и посчитайте сумму всех этих чисел. Сделайте это с использованием asSequence для ленивой обработки.
 */

fun sumWithLambda(numbers: List<Int>, operation: (Int, Int) -> Int): Int {
    return numbers.reduce(operation)
}

data class Person(
    val name: String,
    val age: Int
)

fun peopleAges() {
    val people = listOf(
        Person("Анна", 25),
        Person("Борис", 17),
        Person("Виктор", 30),
        Person("Галина", 22),
        Person("Дмитрий", 16)
    )

    people
        .filter { it.age >= 18 }          // Фильтруем только совершеннолетних
        .sortedByDescending { it.age }    // Сортируем по возрасту в порядке убывания
        .let { adults ->                  // Получаем отфильтрованный список
            println("Список совершеннолетних:")
            adults.apply {                // Применяем действия к списку
                forEach { person ->
                    println("${person.name}: ${person.age} лет")
                }
            }
        }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val sum = sumWithLambda(numbers) { a, b -> a + b }
    println("Сумма: $sum")

    peopleAges()

    val result: Long = (1L..1000000L)
        .asSequence()           // преобразуем в последовательность для ленивой обработки
        .filter { (it % 2).toInt() == 0 } // фильтруем только четные числа
        .map { it * it }        // возводим каждое число в квадрат
        .sum()                  // считаем сумму

    println("Сумма квадратов четных чисел: $result")
}