/*
Задание 1: Сортировка массива с отрицательными числами:
           Отсортируйте массив, чтобы отрицательные числа находились перед положительными,
           сохраняя порядок внутри каждой группы.
           Пример: Вход: [4, -3, 2, -1, 0, -5]
                   Выход: [-3, -1, -5, 4, 2, 0]
Задание 2: Частотная сортировка:
           Напишите функцию, которая сортирует массив по частоте появления элементов (по убыванию).
           Если два элемента встречаются одинаковое количество раз, сортируйте их по возрастанию.
           Пример: Вход: [4, 5, 6, 5, 4, 3]
                   Выход: [4, 4, 5, 5, 6, 3]
Задание 3: Минимальное количество перестановок для сортировки:
           Напишите функцию, которая возвращает минимальное количество перестановок, необходимых для сортировки массива.
           Пример: Вход: [4, 3, 2, 1]
                   Выход: 2 (перестановки [4, 1] и [3, 2])
 */

fun RandomNumber(maxNum: Int): Int {
    return (Math.random() * maxNum).toInt() + 1
}

fun main() {
    val maxIndex = 20 //Максимальный индекс
    val maxNum = 5  // Максимальное значение элемента массива
    val countIndex: Int = RandomNumber(maxIndex)        // Случайное значение количества элементов массива
    val arr: Array<Int> = Array(countIndex, { 0 })    // Инициализируем массив типа Int, все нули
    print("Задание 1. Сгенерирован массив из $countIndex элементов:")
    for (i in 0..countIndex - 1) {                          // Заполнение массива случайными числами
        arr[i] = RandomNumber(maxNum) - maxNum / 2               //Добавляем отрицательные числа
        print(" ")
        print(arr[i])
    }
    println(".")

// Задание 1
    var newArr: Array<Int> = Array(countIndex, { 0 })   // Массив для результатов сортировки
    var cnt: Int = 0
    for (i in 0..countIndex - 1) {
        if (arr[i] < 0) {
            newArr[cnt] = arr[i]
            cnt++
        }
    }
    for (i in 0..countIndex - 1) {
        if (arr[i] >= 0) {
            newArr[cnt] = arr[i]
            cnt++
        }
    }
    print("Ответ: отсортированный массив с сохранением порядка внутри групп из $countIndex элементов:")
    for (i in 0..countIndex - 1) print(" ${newArr[i]}")
    println(".")


// Задание 2
    var res0: Array<Int> = Array(countIndex, { 0 })
    arr.sort<Int>().also { res0 = arr }
    print("Задание 2, неоконченное. Первая сортировка: ")
    for (i in 0..res0.size - 1)
        print("${res0[i]} ")
    println()


// Задание 3
    print("Задание 3. Сгенерирован массив из $countIndex элементов:")
    for (i in 0..countIndex - 1) {                          // Заполнение массива случайными числами
        arr[i] = RandomNumber(maxNum) - maxNum / 2               //Добавляем отрицательные числа
        print(" ")
        print(arr[i])
    }
    println(".")
    var max: Int = 0
    var maxI: Int = 0
    var min: Int = 0
    var minI: Int = 0
    var res3: Array<Int> = Array(countIndex, { 0 })
    var countIterations: Int = 0
    for (i in 0..countIndex - 1) {
        if (min > arr[i]) {
            min = arr[i]
            minI = i
        }
        if (max < arr[i]) {
            max = arr[i]
            maxI = i
        }
    }
    arr[minI] = arr[0]
    arr[0] = min
    arr[maxI] = arr[countIndex - 1]
    arr[countIndex - 1] = max
    countIterations++
    res3[0] = min
    res3[countIndex - 1] = max
    println("Max = $max, Min = $min")

    res3[0] = arr.min()
    res3[countIndex - 1] = arr.max()
}