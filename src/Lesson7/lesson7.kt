package Lesson7
/*
Создать класс Book с:полями title, author, year
первичным конструктором.методом toString().
Добавить метод equals() и hashCode() для сравнения книг по названию и автору.
Создать enum class Genre (FANTASY, DETECTIVE, SCIENCE, HISTORY).
Сделать абстрактный класс LibraryItem (с полем id) и наследовать от него Book.

Создать interface Borrowable с методом borrow(user: String) и реализовать его в Book.
И создать аналог Book через Data class и сравнить логику методов tostring, equals, hashcode
 */
import Lesson7.Genre
fun main() {
    val b1 = Book("Космобиолухи", "Ольга Громыко", 2011, Genre.FANTASY,1,)
    val b2 = Book("Аквариум", "Виктор Суворов", 1991, Genre.DETECTIVE,2,)
    val b3 = Book("Ледокол", "Виктор Суворов", 1998, Genre.HISTORY,3,)
    println(b1)
    println(b2)
    println(b3)
    println("b3 == b2 ${b3 == b2}")
    println("b1 == b2 ${b1 == b2}")

}