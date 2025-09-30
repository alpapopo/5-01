
//Функция читает строку с консоли и пытается преобразовать в Double.
//Если преобразование невозможно, возвращается null вместо исключения.

fun readDouble(prompt: String): Double? {
    print(prompt)
    val input = readlnOrNull()
    return input?.toDoubleOrNull()  // возвращает null если преобразование не удалось
}


  //Функция читает координаты точки с консоли.
 //Возвращает объект Point или null, если ввод некорректен.

fun readPoint(name: String): Point? {
    val x = readDouble("Введите X координату точки $name: ")
    val y = readDouble("Введите Y координату точки $name: ")
    return if (x != null && y != null) Point(x, y) else null
}

fun main() {
    println("Введите координаты треугольника:")

    // Читаем три вершины треугольника с проверкой на корректность ввода
    val p1 = readPoint("A") ?: run {
        println("Ошибка ввода координат точки A")
        return
    }
    val p2 = readPoint("B") ?: run {
        println("Ошибка ввода координат точки B")
        return
    }
    val p3 = readPoint("C") ?: run {
        println("Ошибка ввода координат точки C")
        return
    }

    val triangle = Triangle(p1, p2, p3)

    // Читаем координаты отдельной точки
    val p = readPoint("P") ?: run {
        println("Ошибка ввода координат точки P")
        return
    }

    // Вывод результата проверки
    if (triangle.contains(p)) {
        println("Точка P находится внутри треугольника")
    } else {
        println("Точка P находится вне треугольника")
    }
}
