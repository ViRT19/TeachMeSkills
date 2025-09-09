/*
Задание 1: Поиск максимального и минимального элемента массива
           Напишите программу, которая находит и выводит максимальное и минимальное значение в массиве целых чисел.
           Также вычислите индекс этих элементов.
Задание 2: Подсчет четных и нечетных чисел в массиве
           Напишите программу, которая принимает массив целых чисел и подсчитывает, сколько четных и сколько нечетных чисел в нем содержится.
Задание 3: Реверс массива
           Напишите программу, которая принимает массив целых чисел и изменяет его порядок на обратный.
           Выведите результат после изменения порядка.
Задание 4: Проверка на палиндром.
           Напишите программу, которая проверяет, является ли массив чисел палиндромом.
 */

fun RandomNum(maxNum: Int): Int {
    return (Math.random() * maxNum).toInt() + 1
}

fun main() {
    val maxIndex = 5 //Максимальный индекс
    val maxNum = 10  // Максимальное значение элемента массива
    val countIndex: Int = RandomNum(maxIndex)           // Случайное значение количества элементов массива
    val arr: Array<Int> = Array(countIndex, { 0 })    // Инициализируем массив типа Int, все нули
    print("Сгенерирован массив из $countIndex элементов:")
    for (i in 0..countIndex - 1) {                          // Заполнение массива случайными числами
        arr[i] = RandomNum(maxNum)
        print(" ")
        print(arr[i])
    }
    println(".")
    var maxIndexOfArray: Int = 0
    var minIndexOfArray: Int = 0
    var countEven = 0   // Четные
    var countOdd = 0    // Нечетные

    for (i in 0..countIndex - 1) {
        if (arr[i] > arr[maxIndexOfArray]) maxIndexOfArray = i
        if (arr[i] < arr[minIndexOfArray]) minIndexOfArray = i
        if (arr[i] % 2 == 0) countEven++ else countOdd++
    }
    println("Максимальное число = ${arr[maxIndexOfArray]} с индексом $maxIndexOfArray.")
    println("Минимальное число = ${arr[minIndexOfArray]} с индексом $minIndexOfArray.")
    println("Четных элементов: $countEven, нечётных: $countOdd.")
    print("Массив в обратном порядке:")
    for (i in countIndex - 1 downTo 0)
        print(" ${arr[i]}")
    println(".")

    var palindrom: Boolean = true
    for (i in 1..arr.size / 2)
        if (arr[i - 1] != arr[countIndex - i])
            palindrom = false
    if (palindrom) println("Массив является палиндромом.") else println("Массив не палиндром.")
}