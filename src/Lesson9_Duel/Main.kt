package Lesson9_Duel
/*
Задача 1: Игра дуэль
          Напишите консольную игру, где игроки сражаются, по очереди бросая кубик.
          Всего в игре может быть 3 класса (паладин, разбойник и лучник).
          У каждого класса должно быть здоровье, броня и оружие.
          Оружие должно иметь собственный параметр атаки.
          Броня имеет защиту, которая блокирует урон, но ее прочность снижается после каждого блока.
          Игроки могут выбрать класс, за который они хотят играть.
          Проигрывает тот, у кого первым кончилось здоровье.
        • Паладин — много здоровья, слабая атака, тяжелая броня
        • Разбойник — сильная атака, среднее количество здоровья, средняя броня
        • Лучник — очень сильная атака, мало здоровья, легкая броня
 */

fun main() {
    var paladin: Warrior = Warrior()    //  Паладин
    paladin.attack = 1
    paladin.health = 5
    paladin.protection = 5
    var outlaw: Warrior = Warrior()    // Разбойник
    outlaw.attack = 5
    outlaw.health = 3
    outlaw.protection = 3
    var archer: Warrior = Warrior()    // Лучник
    archer.attack = 5
    archer.health = 2
    archer.protection = 2

    var key: Int = 0
    do {
        key = printStatus(paladin, outlaw, archer)
        when (key) {
            0 -> {
                println("Игра завершена."); return
            }
            1 -> attack(paladin, archer)
            2 -> attack(outlaw, archer)
            else -> println("-----------Введено неверное значение. Еще раз.--------------")
        }
        when (Rand(2)) {
            1 -> {
                attack(paladin, archer)
                println("Паладин атаковал лучника.")
            }

            2 -> {
                attack(paladin, outlaw)
                println("Паладин атаковал разбойника.")
            }
        }
        when (Rand(2)) {
            1 -> {
                attack(outlaw, archer)
                println("Разбойник атаковал лучника.")
            }
            2 -> {
                attack(outlaw, paladin)
                println("Разбойник атаковал паладина.")
            }
        }
    } while (key != 0)
}