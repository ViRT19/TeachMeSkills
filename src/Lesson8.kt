/*
Задание 1: Магазин товаров
Создай систему товаров для интернет-магазина. Каждый товар должен уметь вычислять свою цену с учетом скидки.
• Интерфейс Product с методом double getFinalPrice()
• Классы Electronics, Clothing и Food, которые реализуют этот интерфейс
• Electronics (например, смартфон) имеет скидку 10%
• Clothing (например, куртка) имеет скидку 15%
• Food (например, хлеб) не имеет скидки
• В main() добавь товары в список и выведи их финальные цены
*/

interface Product {
    fun getFinalPrice(): Double
}

class Electronics(val price: Double) : Product {
    override fun getFinalPrice(): Double {
        return price - price / 10
    }
}

class Clothing(val price: Double) : Product {
    override fun getFinalPrice(): Double {
        return price - price / 15
    }
}

class Food(val price: Double) : Product {
    override fun getFinalPrice(): Double {
        return price
    }
}

fun main() {
    val arr: Array<Product> = arrayOf(
        Electronics(105.5),
        Clothing(85.0),
        Food(30.2)
    )
    arr.forEach { println(it.getFinalPrice()) }
}