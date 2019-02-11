package lms.lib

import scala.lms.common._

import lms.lib._
import DummySourceContext.dummySourceContext

trait CollConv { this: DslExp =>

  def ra2ar(l: Int, a: Rep[Array[Int]]): Array[Rep[Int]] = {
    val b = new Array[Rep[Int]](l)
    for (i <- 0 until l: Range) {
      b(i) = a(i)
    }
    b
  }

  def ar2ra(l: Int, a: Array[Rep[Int]]): Rep[Array[Int]] = {
    val b = NewArray[Int](l)
    for (i <- 0 until l: Range) {
      b(i) = a(i)
    }
    b
  }

}
