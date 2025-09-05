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

fun Randomize(maxNum: Int):Int {
    return (Math.random() * maxNum).toInt() + 1
}

fun main() {
    println("Поиск максимального и минимального элементов массива и их индексов.")
    val maxIndex = 30 //Максимальный индекс
    val maxNum = 10  // Максимальное значение
    val countIndex: Int = Randomize(maxIndex)
    val arr: Array<Int> = Array(countIndex, { 0 })    // Инициализируем массив
    print("Массив из $countIndex элементов: ")                   // Вывод массива
    for (i in 0..countIndex - 1) {                          // Заполнение массива
        arr[i] = Randomize(maxNum)
        print(arr[i])
        print(" ")
    }
    println()
    var maxIndexOfArray: Int = 0
    var minIndexOfArray: Int = 0

    for (i in 0..countIndex-1){
        if (arr[i] > arr[maxIndexOfArray]) maxIndexOfArray = i
        if (arr[i] < arr[minIndexOfArray]) minIndexOfArray = i
    }
    println("Максимальное число = ${arr[maxIndexOfArray]} с индексом $maxIndexOfArray")
    println("Минимальное число = ${arr[minIndexOfArray]} с индексом $minIndexOfArray")
}