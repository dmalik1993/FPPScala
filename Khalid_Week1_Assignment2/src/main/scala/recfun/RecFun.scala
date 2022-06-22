package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()
      println("Parentheses Balancing")
      println(balance("H)(ello)(".toList))
      println("Counting Change")
      println(countChange(4, List(1,2)))
  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    if (c < 0 || r < 0 || c > r)

      throw new IllegalArgumentException("Column and row numbers must be 0 or greater. Column length must be lower than row length") else {

      if (c == 0 || c == r) 1 else {

        pascal(c - 1, r - 1) + pascal(c, r - 1)
      }

    }

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanced(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) open == 0
      else
        if (chars.head == '(') balanced(chars.tail,open+1)
        else
          if (chars.head == ')') open>0 && balanced(chars.tail,open-1)
          else balanced(chars.tail,open)
    }
    balanced(chars,0)
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0)
      1
    else if(money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else
      0
  }

trait Greeting {
  lazy val greeting: String = "hello"
}
