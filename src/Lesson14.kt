import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.atomics.AtomicInt
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.thread

/*
Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта.
          Вам нужно создать класс Counter, который будет иметь метод increment и метод decrement.
          Эти методы должны увеличивать и уменьшать значение переменной count в многопоточном режиме.
          Для синхронизации доступов используйте внешний объект (не объект класса).
Задача 2: Применение атомарных типов для безопасного увеличения счетчика.
          Напишите программу, в которой два потока одновременно увеличивают счетчик.
          Вместо синхронизации используйте класс AtomicInteger, чтобы избежать блокировок.
Задача 3: Синхронизация потоков для предотвращения гонки данных.
          Напишите программу с двумя потоками, которые одновременно увеличивают и уменьшают значение счетчика.
          Ваша задача — обеспечить, чтобы операция увеличения и уменьшения была выполнена безопасно с помощью синхронизации.
*/


object ExternalObject               // Внешний объект. Нужен в качестве монитора

class Counter {
    private var count = 0
    fun increment() {
        synchronized(ExternalObject) {  // Первый метод синхронизации
            count++
        }
    }

    @Synchronized               // Второй метод синхронизации
    fun decrement() {
        count--
    }

    fun getCount() = count
}

class CounterAtomic() {
    private var cntAtomic = AtomicInteger(0)
    fun incAtomic() {
        cntAtomic.incrementAndGet()
    }

    fun decAtomic() {
        cntAtomic.decrementAndGet()
    }

    fun getAtomic() = cntAtomic
}

fun main() {
    val counterVal = Counter()
    val counterInc = Thread {
        for (i in 1..100)
            counterVal.increment()
    }
    val counterDec = Thread {
        for (i in 1..100)
            counterVal.decrement()
    }
    counterInc.start()
    counterDec.start()
    counterInc.join()
    counterDec.join()
    println(counterVal.getCount())

    val counterAtomic = CounterAtomic()
    val counterAtomicInc = Thread {
        for (i in 1..100)
            counterAtomic.incAtomic()
    }
    val counterAtomicDec = Thread {
        for (i in 1..100)
            counterAtomic.decAtomic()
    }
    counterAtomicInc.start()
    counterAtomicDec.start()
    counterAtomicInc.join()
    counterAtomicDec.join()
    println(counterAtomic.getAtomic())
}