/*
Задача 1: Переворот слов (без массива)
          Напишите программу, которая принимает строку и переставляет слова в обратном порядке,
          используя только методы String и StringBuild.
Задача 2: Преобразование строки в ASCII коды и обратно
          Реализуйте программу, которая преобразует строку в последовательность ASCII-кодов
          и строку кодов в текст, используя циклы и методы String.
 */

fun main() {
    val str = "до ре ми фа"
    var newStr = StringBuilder()
    println("Исходная строка: «$str».")

    var beginIndex: Int
    var endIndex: Int = str.length

    for (i in str.length - 1 downTo 0)
        if (str[str.length - i - 1] == ' ') {
            beginIndex = i
            newStr.append(str.substring(beginIndex, endIndex))
            newStr.append(" ")
            endIndex = i
        }
    newStr.append(str.substring(0, endIndex))
    println("1 способ. Перевёрнутая строка: «${newStr.trim()}».")
    /*************************************************************************/
    var newString = str.split(" ")
    var out = StringBuilder()
    for (i in newString.size - 1 downTo 0)
        out.append(newString[i]).append(" ")
    println("2 способ. Перевёрнутая строка: «${out.trim()}».")
    /*************************************************************************/
    newString = newStr.reversed().split(" ")
    print("3 способ. Переворачиваем обратно: «")
    for (i in 0..newString.size - 1)
        print(newString[i].reversed())
    println("».")
    /*************************************************************************/

    val name = "Hello World, I am teach Kotlin"

    val words = name.split(" ")
    val reversedname = words.reversed().joinToString(" ")

    println("Исходная строка: $name")
    println("Перевернутые слова: $reversedname")

    /*************************************************************************/

    print("В ASCII коде:")
    for (i in 0..str.length - 1)
        print(" ${str[i].code}")
    println(".")

    print("Обратно в ASCII код: ")
    for (i in 0..str.length - 1)
        print("${str[i].code.toChar()}")
    println(".")
}