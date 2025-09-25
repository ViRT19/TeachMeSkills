package Lesson7

class Book(
    var title: String,
    var author: String,
    var year: Int,
    var genre: Genre,
    var id: Int
) : LibraryItem(id), Borrowable {
    fun borrow(user: String) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (author != other.author) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        return result
    }

    override fun toString(): String {
        return "Book(Название = «$title», Автор = $author, Год издания = $year, Жанр = $genre , ID = $id)"
    }

}