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

fun printStatus(paladin: Warrior, outlaw: Warrior, archer: Warrior): Int {
    println("        Вы: Лучник       1. Паладин      2. Разбойник")
    println("Здоровье:     ${archer.health}                ${paladin.health}                ${outlaw.health}")
    println("Атака:        ${archer.attack}                ${paladin.attack}                ${outlaw.attack}")
    println("Защита:       ${archer.protection}                ${paladin.protection}                ${outlaw.protection}")
    println("1 - атакуем паладина, 2 - атакуем разбойника, 0 - выход.")

    if (paladin.health < 0 || outlaw.health < 0 || archer.health < 0) {
        println("Победа!")
        return 0
    } else
    {
        print("Кого атакуем? > ")
        return readln().toInt()
    }
}

fun attack(whom: Warrior, who: Warrior) {
    whom.health(who.attack)
    whom.protection(who.attack)
    who.attack--
}

fun Rand(maxNum: Int): Int {
    return (Math.random() * maxNum).toInt() + 1
}