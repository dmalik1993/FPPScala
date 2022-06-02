package funsets

object Main extends App:
  import FunSets.*
  println("SingletonSet")
  println(contains(singletonSet(3), 1))
  println("Union test")
  println(contains(union(singletonSet(1),singletonSet(2)),2))
  println("Intersection test")
  println(contains(intersect(singletonSet(2),singletonSet(1)),1))
  println("Difference test")
  println(contains(diff(singletonSet(2),singletonSet(1)),2))
  println("Filter test")
  println(contains(filter(singletonSet(2),x=>x==2),2))
  println("Exist test")
  println(exists(singletonSet(2),x=>x==2))
  println("Map test")
  printSet(map(singletonSet(2),x=>x*2))
