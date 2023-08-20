package day2
import scala.collection.mutable.ListBuffer
def day2 =
    val lines = io.Source.fromFile("day2.input").getLines().toList
    val e = lines.map(eval).sum
    val e1 = lines.map(eval2).sum
    e.toString() + ' ' + e1.toString()


def eval(s: String) =
    val mychoice = s(2).toInt - 'W'.toInt
    val results = Map("A X" -> 3, "A Y" -> 6, "A Z" -> 0, "B X" -> 0, "B Y" -> 3, "B Z" -> 6, "C X" -> 6, "C Y" -> 0, "C Z" -> 3)
    mychoice + results(s)

def eval2(s: String) =
    val result = (s(2).toInt - 'X'.toInt) * 3
    val mychoice = Map("A X" -> 3, "A Y" -> 1, "A Z" -> 2, "B X" -> 1, "B Y" -> 2, "B Z" -> 3, "C X" -> 2, "C Y" -> 3, "C Z" -> 1)
    result + mychoice(s)

