package recfun
import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */

  def pascal(c: Int, r: Int): Int =
    if (c == 0 || r == c) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    lazy val bracesOnly = chars.filter(c => c == ')' || c == '(')
    @tailrec
    def findTail(tail: List[Char]): Boolean =
      if (tail.head == ')')
        true
      else if (tail.tail.isEmpty)
        false
      else
        findTail(tail.tail)
    @tailrec
    def compare(filtered: List[Char], counter: Int): Boolean =
          if (filtered.isEmpty) if counter == 0 then true else false
          else if (filtered.tail.isEmpty && filtered.head == '(')
            false
          else if (filtered.head == '(')
            findTail(filtered.tail) && compare(filtered.tail, counter + 1)
          else compare(filtered.tail, counter - 1)

    if chars.isEmpty || bracesOnly.isEmpty then false else compare(bracesOnly, 0)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    def changeCounter(sol:Int,coinList:List[Int]):Int=
      if(coinList.isEmpty || sol>money)0
      else if(sol==money)1
      else changeCounter(sol+coinList.head,coinList) + changeCounter(sol, coinList.tail)
    changeCounter(0,coins)
