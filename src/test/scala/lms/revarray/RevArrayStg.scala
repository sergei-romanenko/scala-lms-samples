package lms.revarray

import scala.lms.common._

import scala.language.implicitConversions
import scala.language.reflectiveCalls

import lms.lib._
import DummySourceContext.dummySourceContext

trait RevArrayStg extends Dsl {

  def reverse(u: Boolean, l: Int, a: Rep[Array[Int]]): Rep[Array[Int]] = {
    val b = NewArray[Int](l)
    if(u)
      for (i <- 0 until l: Range) {
        b(i) = a(l - 1 - i)
      }
    else
      for (i <- 0 until l) {
        b(i) = a(l - 1 - i)
      }
    b
  }
}

class RevArrayStgTest extends TutorialFunSuite {
  val under = "revarray"

  def specialize(u: Boolean, l: Int): DslDriver[Array[Int], Array[Int]] = {
    new DslDriver[Array[Int], Array[Int]] with RevArrayStg {
      def snippet(a: Rep[Array[Int]]): Rep[Array[Int]] = {
        reverse(u, l, a)
      }
    }
  }

  test("specialize reverseU to l=5") {
    val res = specialize(u = true, 5)
    check("-u5", res.code)
  }

  test("specialize reverseL to l=5") {
    val res = specialize(u = false, 5)
    check("-l5", res.code)
  }

}
