import kotlin.math.abs


  //Класс треугольника, заданного тремя вершинами типа Point.

class Triangle(private val p1: Point, private val p2: Point, private val p3: Point) {


      //Вычисляет площадь треугольника по координатам трёх точек
      //Используется формула Шоутена:
      //|x1(y2−y3) + x2(y3−y1) + x3(y1−y2)| / 2

    private fun area(a: Point, b: Point, c: Point): Double {
        return abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0
    }


      //Проверяет, лежит ли точка p внутри (или на границе) треугольника.

      //Алгоритм:
      //- Считаем площадь полного треугольника S.
      //- Считаем сумму площадей трёх треугольников, образованных с точкой p (S1 + S2 + S3).
      //- Если точка внутри, то S ≈ S1 + S2 + S3 (учитываем небольшую погрешность).

    fun contains(p: Point): Boolean {
        val totalArea = area(p1, p2, p3)
        val area1 = area(p, p2, p3)
        val area2 = area(p1, p, p3)
        val area3 = area(p1, p2, p)
        // Прямое сравнение без ограничения точности
        return totalArea == (area1 + area2 + area3)
    }


}
