package funsets

object Main extends App:
  import FunSets.*
  print("Contains: ")
  println(contains(singletonSet(1), 1))
  val unionSet = union(singletonSet(1), singletonSet(2))
  print("Union: ")
  printSet(unionSet)
  print("ForAll: ")
  println(forall(unionSet, x => x % 1 == 0))
  print("Exists: ")
  println(exists(unionSet, x => x == 1))
  print("Map: ")
  printSet(map(unionSet, x => x + x))
