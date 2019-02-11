package lms.btsort

import lms.lib._
import DummySourceContext.dummySourceContext

trait BitonicSortStg extends DslExp with CollConv {

  def swap(up: Boolean, i: Int, j: Int, x: Array[Rep[Int]]): Unit = {
    //val cmp: Rep[Boolean] = if (up) x(i) > x(j) else x(j) > x(i)
/*
    if (x(i) > x(j)) {
      val tmp = x(i)
      x(i) = x(j)
      x(j) = tmp
    }
*/
    xi = Math.min(x(i), x(j))
  }

  def merge(up: Boolean, p: Int, l: Int, x: Array[Rep[Int]]): Unit = {
    // Produces a sorted list, on condition that x is bitonic.
    if (l <= 1)
      return
    val h = l / 2
    for (i <- 0 until h: Range) {
      if(up)
        swap(up, p + i, (p + h) + i, x)
      else
        swap(up, (p + h) + i, p + i, x)
    }
    merge(up, p, h, x)
    merge(up, p + h, h, x)
  }

  def sort(up: Boolean, p: Int, l: Int, x: Array[Rep[Int]]): Unit = {
    if (l <= 1)
      return
    val h = l / 2
    sort(up = true, p, h, x)
    sort(up = false, p + h, h, x)
    merge(up, p, l, x)
  }

  def sort(l: Int, x: Rep[Array[Int]]): Rep[Array[Int]] = {
    val y = ra2ar(l, x)
    sort(up = true, 0, l, y)
    ar2ra(l, y)
  }
}

class BitonicSortStgTest extends TutorialFunSuite {
  val under = "btsort"

  def specialize(l: Int): DslDriver[Array[Int], Array[Int]] = {
    require((l & (l - 1)) == 0, "x.length must be a power of 2")
    new DslDriver[Array[Int], Array[Int]] with BitonicSortStg {
      def snippet(x: Rep[Array[Int]]): Rep[Array[Int]] = {
        sort(l, x)
      }
    }
  }

  test("specialize sort to l=1") {
    val sort1 = specialize(1)
    check("-l1", sort1.code)
  }

  test("specialize sort to l=2") {
    val sort2 = specialize(2)
    check("-l2", sort2.code)
  }

  test("specialize sort to l=4") {
    val sort4 = specialize(4)
    check("-l4", sort4.code)
  }

}
