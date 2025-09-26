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

fun Main() {
    println("Обработка исключений. Задание 1: поимка деления на 0 или введение не числа.")
    var a = 0
    var b = 0
    var errors = false
    do {
        errors = false
        print("Первое число: ")
        try {
            a = readln().toInt()
        } catch (e: InputMismatchException) {
            errors = true
            println("Введено не число.")
        }
    } while (!errors)
    do {
        errors = false
        print("Второе число: ")
        try {
            try {
                a = readln().toInt()
            } catch (e: InputMismatchException) {
                errors = true
                println("Введено не число.")
            }
        } catch (e: ArithmeticException) {
            errors = true
            println("Делить на 0 нельзя. Повторите ввод числа.")
        }
    } while (!errors)
}