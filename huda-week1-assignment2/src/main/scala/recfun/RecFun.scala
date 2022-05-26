package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()
    println(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
    println(countChange(300,List(500,5,50,100,20,200,10)))

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0 || r == 0) 1
    else
      pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceAux(count: Int, charsTail: List[Char]): Boolean = {
      charsTail match {
        case Nil => if (count == 0) true else false
        case _ =>
          charsTail.head match {
            case '(' => balanceAux(count + 1, charsTail.tail)
            case ')' => if (count > 0) balanceAux(count - 1, charsTail.tail) else false
            case _ => balanceAux(count, charsTail.tail)
          }
      }
    }
    balanceAux(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    money match {
      case 0: Int => 1
      case moneyCheck: Int if (moneyCheck < 0 || (moneyCheck > 0 && coins.isEmpty)) => 0
      case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }
