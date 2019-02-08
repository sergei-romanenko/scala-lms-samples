package lms.btsort

object BitonicSort {

  def swap(up: Boolean, i: Int, j: Int, x: Array[Int]): Unit = {
    if (if (up) x(i) > x(j) else x(j) > x(i)) {
      val tmp = x(i)
      x(i) = x(j)
      x(j) = tmp
    }
  }

  def merge(up: Boolean, p: Int, l: Int, x: Array[Int]): Unit = {
    // Produces a sorted list, on condition that x is bitonic.
    if (l <= 1)
      return
    val h = l / 2
    for (i <- 0 until h)
      swap(up, p + i, p + h + i, x)
    merge(up, p, h, x)
    merge(up, p + h, h, x)
  }

  def sort(up: Boolean, p: Int, l: Int, x: Array[Int]): Unit = {
    require((l & (l - 1)) == 0, "x.length must be a power of 2")
    if (l <= 1)
      return
    val h = l / 2
    sort(up = true, p, h, x)
    sort(up = false, p + h, h, x)
    merge(up, p, l, x)
  }
}

object BitonicSortTest {
  def main(args: Array[String]): Unit = {
    val input = Vector(10, 30, 11, 20, 4, 330, 21, 110)
    for (incr <- Vector(true, false)) {
      val x = input.toArray
      println(s"inputs = ${x.toVector}")
      BitonicSort.sort(incr, 0, x.length, x)
      println(s"outputs = ${x.toVector}")
    }
  }
}
