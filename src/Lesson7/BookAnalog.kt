package Lesson7

import Lesson7.Borrowable as Borrowable1

data class BookAnalog (
    var title : String,
    var author : String,
    var year : Int,
    var genre: Genre,
    var id : Int ): LibraryItem(id), Borrowable1 {
    fun borrow(user: String) {

    }
}
