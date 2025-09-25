package Lesson9_Duel

class Warrior {             // Воин
    var health: Int = 0     // Здоровье
    var protection: Int = 0 // Защита
    var attack: Int = 0     // Атака

    fun health(meaning: Int) {
        return health -= meaning
    }

    fun protection(meaning: Int) {
        return protection -= meaning
    }

    fun attack(meaning: Int) {
        return attack -= meaning
    }
}