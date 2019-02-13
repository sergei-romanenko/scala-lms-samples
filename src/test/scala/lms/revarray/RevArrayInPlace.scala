package lms.revarray

import org.scalatest.FunSuite

object RevArrayInPlace {

  def reverse(l: Int, a: Array[Int]): Unit = {
    require(l == a.length, "l must be equal to a.length")
    val h = l / 2
    for (i <- 0 until h) {
      val j = l - 1 - i
      val tmp = a(i)
      a(i) = a(j)
      a(j) = tmp
    }
  }
}

class RevArrayInPlaceTest extends FunSuite {
  import RevArrayInPlace.reverse

  def testRev(a: Array[Int], after: Vector[Int]): Unit = {
    reverse(a.length, a)
    assert(a.toVector == after)
  }

  test("RevArrayInPlace.reverse 0") {
    testRev(Array(), Vector())
  }

  test("RevArrayInPlace.reverse 1") {
    testRev(Array(1), Vector(1))
  }

  test("RevArrayInPlace.reverse 2") {
    testRev(Array(1,2), Vector(2,1))
  }

  test("RevArrayInPlace.reverse 5") {
    testRev(Array(1,2,3,4,5), Vector(5,4,3,2,1))
  }
}