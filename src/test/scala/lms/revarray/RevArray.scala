package lms.revarray

import org.scalatest.FunSuite

object RevArray {

  def reverse(l: Int, a: Array[Int]): Array[Int] = {
    require(l == a.length, "l must be equal to a.length")
    val b = new Array[Int](l)
    for (i <- 0 until l) {
      b(i) = a(l - 1 - i)
    }
    b
  }
}

class RevArrayTest extends FunSuite {
  import RevArray.reverse

  def testRev(a: Array[Int], after: Vector[Int]): Unit = {
    val b = reverse(a.length, a)
    assert(b.toVector == after)
  }

  test("RevArray.reverse 0") {
    testRev(Array(), Vector())
  }

  test("RevArray.reverse 1") {
    testRev(Array(1), Vector(1))
  }

  test("RevArray.reverse 2") {
    testRev(Array(1,2), Vector(2,1))
  }

  test("RevArray.reverse 5") {
    testRev(Array(1,2,3,4,5), Vector(5,4,3,2,1))
  }
}