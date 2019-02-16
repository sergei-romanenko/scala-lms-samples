package lms.lib

import scala.lms.common._

import lms.lib._
import DummySourceContext.dummySourceContext

trait CollConv { this: DslExp =>

  def ra2ar(l: Int, a: Rep[Array[Int]]): Array[Rep[Int]] = {
    Array.tabulate(l)(i => a(i))
  }

  def ar2ra(a: Array[Rep[Int]]): Rep[Array[Int]] = {
    val l = a.length
    val b = NewArray[Int](l)
    for (i <- 0 until l: Range) {
      b(i) = a(i)
    }
    b
  }

  def ra2vr(l: Int, a: Rep[Array[Int]]): Vector[Rep[Int]] = {
    Vector.tabulate(l)(i => a(i))
  }

  def vr2ra(a: Vector[Rep[Int]]): Rep[Array[Int]] = {
    val l = a.length
    val b = NewArray[Int](l)
    for (i <- a.indices: Range) {
      b(i) = a(i)
    }
    b
  }

}
