package day1
import scala.collection.mutable.ListBuffer
def day1 =
    val lines = io.Source.fromFile("day1.input").getLines().toList
    var foods = new ListBuffer[Int]
    var i = 0
    var max = 0
    var currentSum = 0
    for row <- lines do 
        if row == "" then
            if currentSum > max then max = currentSum
            currentSum = 0
            i += 1
        else
            currentSum += row.toInt
            foods += currentSum

        // println(row)
    val f = foods.toList.sorted(Ordering.Int.reverse)

    f(0).toString() + " " + (f(0)+f(1)+f(2)).toString()

