package funsets

object Main extends App:
  import FunSets.*
  println(contains(singletonSet(1), 1))

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)

  val s = union(union(s1, s2), s3)
  val anotherS = filter(s, x => x%2==0)

  printSet(anotherS)

  val s4 = map(s, x => x*2)
  printSet(s4)
