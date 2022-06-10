package funsets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
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
    val s4 = singletonSet(1)

  /**
   * This test is currently disabled (by using @Ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remove the
   * .ignore annotation.
   */
  test("singleton set one contains one".ignore) {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets:
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }

  test("intersect contains common elements of each set") {
    new TestSets:
      val s = intersect(s1, s2)
      val anotherS = intersect(s1, s4)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
      assert(contains(anotherS, 1), "Intersect 4")
  }

  test("difference between elements of each set") {
    new TestSets:
      val s = diff(s1, s2)
      val anotherS = diff(s1, s4)
      assert(contains(s, 1), "Difference 1")
      assert(!contains(s, 2), "Difference 2")
      assert(!contains(s, 3), "Difference 3")
      assert(!contains(anotherS, 1), "Difference 4")
  }


  test("filters elements acc to the predicate") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      val anotherS = filter(s, x => x%2==0)
      assert(!contains(anotherS, 1), "Filter 1")
      assert(contains(anotherS, 2), "Filter 2")
      assert(!contains(anotherS, 3), "Filter 3")
  }

  test("forall") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(forall(s, x => x >= 1), "Forall 1")
      assert(!forall(s, x => x > 5), "Forall 2")
      assert(!forall(s, x => ((x % 2) == 0)), "Forall 3")
    }
  }

  test("exists") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(exists(s, x => x > 1), "Exists 1")
      assert(!exists(s, x => x > 5), "Exists 2")
      assert(exists(s, x => ((x % 2) == 0)), "Exists 3")
    }
  }


  test("map") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val anotherS = map(s, x => x * 2 )
      assert(contains(anotherS, 4), "Map 1")
      assert(contains(anotherS, 6), "Map 2")
      assert(!contains(anotherS, 1), "Map 3")
    }
  }


  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
