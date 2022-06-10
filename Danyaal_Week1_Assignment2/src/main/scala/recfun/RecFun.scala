package recfun

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
  def pascal(c: Int, r: Int): Int = if(c==0 || c==r) then 1 else pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceParentheses(chars: List[Char], count: Int): Int = {
      if(chars.isEmpty || count < 0){
        count
      }else{
        if(chars.head.equals('(')){
          balanceParentheses(chars.tail, count + 1)
        }else if(chars.head.equals(')')){
          balanceParentheses(chars.tail, count - 1)
        }else{
          balanceParentheses(chars.tail, count)
        }
      }
    }

  val count = balanceParentheses(chars, 0)
  if (count !=0 ) false else true
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
