package day1
import scala.collection.mutable.ListBuffer
import java.nio.file.Path
import cats.effect.IOApp
import scala.annotation.tailrec
@main
def day1 =
  val lines = io.Source.fromFile("day1.input").getLines().toList
  var foods =
    new ListBuffer[
      Int
    ] // Это точно val. меняется ListBuffer, но не ссылка на него
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

  println(f(0).toString() + " " + (f(0) + f(1) + f(2)).toString())

// ----- ppavel ---- 
case class Result(elfNum: Int, calories: Int):
  def max(r: Result) = if r.calories > calories then r else this

@tailrec
def findElf(
    in: Iterator[String],
    elfNum: Int = 1,
    res: Option[Result] = None
): Option[Result] =
  val (strings, rest) = in.dropWhile(_.isEmpty).span(_.nonEmpty)
  if strings.isEmpty then res
  else
    val current = Result(elfNum, strings.map(_.toInt).sum)
    val winner = res.map(_ max current).getOrElse(current)
    findElf(rest, elfNum + 1, Some(winner))

@main
def day1_ppavel_simple =
  val source = io.Source.fromFile("day1.input")
  try
    val res = findElf(source.getLines())
    println(res)
  finally source.close()
