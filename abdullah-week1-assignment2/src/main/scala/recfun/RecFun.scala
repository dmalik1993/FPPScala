package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()
      println("Balancer")
      println(balance("(sad))is#$)()".toList))
      println("Count Change")
      println(countChange(10, List(1,2)))


  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balancer(count: Int, remainingChars: List[Char]): Boolean = {
      if (remainingChars.isEmpty) if (count == 0) true else false
      else if (remainingChars.head == '(') balancer(count+1, remainingChars.tail)
      else if (remainingChars.head == ')' && count > 0) balancer(count-1, remainingChars.tail)
      else  balancer(count, remainingChars.tail)
    }
    if (chars.isEmpty) true
    else balancer(0, chars)
    
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def moneyChanger(money: Int, coins: List[Int]): Int =
      if (money == 0) 1
      else if (money < 0 || coins.isEmpty) 0
      else moneyChanger(money - coins.head, coins) + moneyChanger(money, coins.tail)

    moneyChanger(money, coins)
  }
