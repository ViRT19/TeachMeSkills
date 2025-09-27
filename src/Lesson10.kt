import java.util.InputMismatchException

/*
Задача 1: Деление с обработкой исключения
Задача: Написать программу, которая делит два числа, введенных пользователем.
Обработать:
⦁ ArithmeticException (деление на ноль)
⦁ InputMismatchException (если введено не число)

Задача 2: Проверка возраста (кастомное исключение)
Задача: Попросить пользователя ввести возраст. Если возраст < 18, выбросить исключение.
Используем кастомное исключение TooYoungException.

Задача 3: Обработка пустой строки
Задача: Запросить у пользователя строку и проверить, что она не пустая.
Обработать:
⦁ IllegalArgumentException, если строка пустая
*/

class TooYoungException: Throwable()
fun tooYoung (age: Int) {
    if (age < 18) throw TooYoungException()
}

fun main() {
    println("Обработка исключений. Задание 1: поимка деления на 0 или введение не числа.")
    var a = 0
    var b = 0
    var errors: Boolean = false
    do {
        print("Первое число: ")
        try {
            errors = false
            a = readln().toInt()
        } catch (e: NumberFormatException) {
            errors = true
            println("Введено не число.")
        }
    } while (errors)
    do {
        print("Второе число: ")
        try {
            errors = false
            b = readln().toInt()
        } catch (e: NumberFormatException) {
            errors = true
            println("Введено не число.")
        }
    } while (errors)
    try {
        val num: Int = a / b
        println("Результат деления: $num.")
    } catch (e: ArithmeticException) {
        println("Ошибка: деление на 0.")
    }

    print("Введите возраст: ")
    errors = true
    try {
        val yang: Int = readln().toInt()
        tooYoung(yang)
    } catch (e: TooYoungException) {
        println("Слишком молодой.")
        errors = false
    }
    if (errors) println("Подходящий возраст.")

    print("Ввод строки: ")
    errors = true
    try {
        val str: String = readln().toString()
    } catch (e: IllegalArgumentException) {
        errors = false
        println("Строка пустая.")
    }
    if (true) println("Строка не пустая.")
}