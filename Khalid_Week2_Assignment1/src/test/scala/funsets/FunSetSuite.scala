package funsets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("string take") {
    val message = "hello, Scala"
    assert(message.take(5) == "hello")
  }

     test("adding ints") {
        assert(2 + 1 + 1 == 4)
      }


  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  test("singletonSet is implemented") {
    assert(contains(singletonSet(1),1))
  }

  test("union is implemented") {
    assert(contains(union(singletonSet(1),singletonSet(1)),1))
  }

  test("intersect is implemented") {
    assert(contains(intersect(singletonSet(1),singletonSet(1)),1))
  }

  test("diff is implemented") {
    assert(contains(diff(singletonSet(1),singletonSet(2)),1))
  }

  test("filter is implemented") {
    assert(contains(filter(singletonSet(1),x=>x==1),1))
  }

  test("forall is implemented") {
    assert(forall(singletonSet(1),x=>x==1))
  }

  test("exists is implemented") {
    assert(exists(singletonSet(1),x=>x==1))
  }

  test("map is implemented") {
    assert(contains(map(singletonSet(1),x=>x),1))
  }
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = union(s1, s2)
    val s5 = union(s2, s3)
    val s6 = diff(s4, s1)
    val s7 = intersect(s4, s5)
    val s8 = union(s4, s5)
    val s9 = filter(s8, x => x>1)
    val s10 = filter(s8, x => x%2==1)
    var s11:FunSet = x => x >2 && x < 5
    val s12 = map(s8, x => x * x)
    val s13 = map(s11, x => x / 2)

  /**
   * This test is currently disabled (by using @Ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remove the
   * .ignore annotation.
   */


  test("singletonSets") {

    new TestSets {

      assert(contains(s1, 1), "Singleton set(1) contains 1")
      assert(contains(s2, 2), "Singleton set(2) contains 2")
      assert(!contains(s2, 1), "Singleton set(2) doesn't contain 1")
    }
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }



  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
