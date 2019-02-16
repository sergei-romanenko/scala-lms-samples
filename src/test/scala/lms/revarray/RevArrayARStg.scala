package lms.revarray

import scala.lms.common._

import scala.language.implicitConversions
import scala.language.reflectiveCalls

import lms.lib._
import DummySourceContext.dummySourceContext

trait RevArrayARStg extends DslExp with CollConv {

  def reverse(l: Int, a: Array[Rep[Int]]): Unit = {
    if( l <= 1)
      return
    val h = l / 2
    for (i <- 0 until h: Range) {
      val j = l - 1 - i
      val tmp = a(i)
      a(i) = a(j)
      a(j) = tmp
    }
  }

  def reverse(l: Int, a: Rep[Array[Int]]): Rep[Array[Int]] = {
    val b = ra2ar(l, a)
    reverse(l, b)
    ar2ra(b)
  }
}

class RevArrayARStgTest extends TutorialFunSuite {
  val under = "revarray"

  def specialize(l: Int): DslDriver[Array[Int], Array[Int]] = {
    new DslDriver[Array[Int], Array[Int]] with RevArrayARStg {
      def snippet(a: Rep[Array[Int]]): Rep[Array[Int]] = {
        reverse(l, a)
      }
    }
  }

  test("specialize reversePS to l=5") {
    val res = specialize(5)
    check("-ar5", res.code)
  }
}
