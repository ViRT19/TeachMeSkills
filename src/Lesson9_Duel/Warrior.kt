package Lesson9_Duel

class Warrior {             // Воин
    var health: Int = 0     // Здоровье
    var protection: Int = 0 // Защита
    var attack: Int = 0     // Атака

    fun health(meaning: Int) {
        this.health -= meaning
        return
    }

    fun protection(meaning: Int) {
        this.protection -= meaning
        return
    }

    fun attack(meaning: Int) {
        this.attack -= meaning
        return
    }
}