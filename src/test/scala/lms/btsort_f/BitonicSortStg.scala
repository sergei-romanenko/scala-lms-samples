package lms.btsort_f

import lms.lib._
import DummySourceContext.dummySourceContext

trait BitonicSortStg extends DslExp with CollConv {

  def merge(up: Boolean, x: Vector[Rep[Int]]): Vector[Rep[Int]] = {
    // Produces a sorted list, on condition that x is bitonic.
    val l = x.length
    if (l == 1)
      return x
    val h = l / 2
    val (x1, x2) = x.splitAt(h)
    val ok = Vector.tabulate(h)(i => if (up) x1(i) <= x2(i) else x2(i) <= x1(i))
    val y1 = Vector.tabulate(h)(i => __ifThenElse(ok(i), x1(i), x2(i)))
    val y2 = Vector.tabulate(h)(i => __ifThenElse(ok(i), x2(i), x1(i)))
    merge(up, y1) ++ merge(up, y2)
  }

  def sort(up: Boolean, x: Vector[Rep[Int]]): Vector[Rep[Int]] = {
    val l = x.length
    require((l & (l - 1)) == 0, "x.length must be a power of 2")
    if (l <= 1)
      return x
    val h = l / 2
    val (x1, x2) = x.splitAt(h)
    val y1 = sort(up = true, x1)
    val y2 = sort(up = false, x2)
    merge(up, y1 ++ y2)
  }

  def sort(l: Int, x: Rep[Array[Int]]): Rep[Array[Int]] = {
    vr2ra(sort(up = true, ra2vr(l, x)))
  }
}

class BitonicSortStgTest extends TutorialFunSuite {
  val under = "btsort_f"

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
