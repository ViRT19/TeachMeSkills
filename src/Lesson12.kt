fun anagramma() {
    val a: String = "hvdjksavklsad vlsavg"
    val b: String = "vhdjksavklsad vlsavg"
    a.uppercase()
    b.uppercase()
    var chA = a.toList().sorted()
    var chB = b.toList().sorted()
    if (chA == chB) println("Aнаграмма") else println("Это не анаграмма")
}

fun main() {
    anagramma()
}