package lms.revarray

import org.scalatest.FunSuite

object RevArray0 {

  def reverse(l: Int, a: Array[Int]): Unit = {
    require(l == a.length, "l must be equal to a.length")
    if( l <= 1)
      return
    val h = l / 2
    for (i <- 0 until h) {
      val j = l - 1 - i
      val tmp = a(i)
      a(i) = a(j)
      a(j) = tmp
    }
  }
}

class RevArray0Test extends FunSuite {
  import RevArray0.reverse

  def testRev(a: Array[Int], after: Vector[Int]): Unit = {
    reverse(a.length, a)
    assert(a.toVector == after)
  }

  test("RevArray0.reverse 0") {
    testRev(Array(), Vector())
  }

  test("RevArray0.reverse 1") {
    testRev(Array(1), Vector(1))
  }

  test("RevArray0.reverse 2") {
    testRev(Array(1,2), Vector(2,1))
  }

  test("RevArray0.reverse 5") {
    testRev(Array(1,2,3,4,5), Vector(5,4,3,2,1))
  }
}