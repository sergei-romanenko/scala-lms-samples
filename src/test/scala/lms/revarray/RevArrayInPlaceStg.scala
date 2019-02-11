package lms.revarray

import scala.lms.common._

import scala.language.implicitConversions
import scala.language.reflectiveCalls

import lms.lib._
import DummySourceContext.dummySourceContext

// There are some problems with specializing updates in place.
// Rep[Array[Int]] is treated as non-mutable!

trait RevArrayInPlaceStg extends Dsl {

  def reverse(l: Int, a: Rep[Array[Int]]): Unit = {
    if (l <= 1)
      return
    val h = l / 2
    for (i <- 0 until h: Range) {
      val j = l - 1 - i
      val ai = a(i)
      val aj = a(j)
      a(i) = aj
      a(j) = ai
    }
  }

}

class RevArrayInPlaceStgTest extends TutorialFunSuite {
  val under = "revarray0"

  def specialize(l: Int): DslDriver[Array[Int], Unit] = {
    new DslDriver[Array[Int], Unit] with RevArrayInPlaceStg {
      def snippet(a: Rep[Array[Int]]): Rep[Unit] = {
        reverse(l, a)
      }
    }
  }

  // The result is incorrect!

  /*
    test("specialize reverse to l=5") {
      val res = specialize(5)
      check("-r5", res.code)
    }
  */

}
