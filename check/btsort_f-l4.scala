/*****************************************
Emitting Generated Code
*******************************************/
class Snippet extends ((Array[Int])=>(Array[Int])) {
  def apply(x0:Array[Int]): Array[Int] = {
    val x23 = new Array[Int](4)
    val x1 = x0(0)
    val x2 = x0(1)
    val x5 = x1 <= x2
    val x6 = if (x5) {
      x1
    } else {
      x2
    }
    val x3 = x0(2)
    val x4 = x0(3)
    val x8 = x4 <= x3
    val x9 = if (x8) {
      x3
    } else {
      x4
    }
    val x11 = x6 <= x9
    val x13 = if (x11) {
      x6
    } else {
      x9
    }
    val x7 = if (x5) {
      x2
    } else {
      x1
    }
    val x10 = if (x8) {
      x4
    } else {
      x3
    }
    val x12 = x7 <= x10
    val x14 = if (x12) {
      x7
    } else {
      x10
    }
    val x17 = x13 <= x14
    val x18 = if (x17) {
      x13
    } else {
      x14
    }
    val x24 = x23(0) = x18
    val x19 = if (x17) {
      x14
    } else {
      x13
    }
    val x25 = x23(1) = x19
    val x15 = if (x11) {
      x9
    } else {
      x6
    }
    val x16 = if (x12) {
      x10
    } else {
      x7
    }
    val x20 = x15 <= x16
    val x21 = if (x20) {
      x15
    } else {
      x16
    }
    val x26 = x23(2) = x21
    val x22 = if (x20) {
      x16
    } else {
      x15
    }
    val x27 = x23(3) = x22
    x23
  }
}
/*****************************************
End of Generated Code
*******************************************/
