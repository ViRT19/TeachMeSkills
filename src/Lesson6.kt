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
    print("Сгенерирован массив из $countIndex элементов:")
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
    print("Отсортированный массив с сохранением порядка внутри групп из $countIndex элементов:")
    for (i in 0..countIndex - 1) print(" ${newArr[i]}")
    println(".")

// Задание 2
    var res0: Array<Int> = Array(countIndex, { 0 })
    arr.sort<Int>().also { res0 = arr }
    print("Первая сортировка: ")
    for (i in 0..res0.size - 1)
        print("${res0[i]} ")
    println()

    /*    class frequencyArr() {
            var fIndex: Int = 0
            var fRepeat: Int = 0
            var fMeaning: Int = 0
        }
        var fr = Array<frequencyArr> (countIndex)
    */
    var frIndex: Array<Int> = Array(countIndex, { 0 })
    var frCount: Array<Int> = Array(countIndex, { 1 })
    var frMeaning: Array<Int> = Array(countIndex, { 0 })
    cnt = 0
    for (i in 0..countIndex - 2) {
        if (res0[i] == res0[i + 1]) {
            if (res0[i] == frMeaning[cnt]) {
                frCount[cnt]++
                cnt++
            } else {
                frCount[cnt]++
                frIndex[cnt] = i
                frMeaning[cnt] = res0[i]
                cnt++
            }
        }
    }
    for (i in 0..cnt - 1) {
        print("${frIndex[i]} ")
        println()
        print("${frCount[i]} ")
        println()
        print("${frMeaning[i]} ")
        println()
    }
}