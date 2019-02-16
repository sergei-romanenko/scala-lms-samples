/*****************************************
Emitting Generated Code
*******************************************/
class Snippet extends ((Array[Int])=>(Array[Int])) {
  def apply(x0:Array[Int]): Array[Int] = {
    val x6 = new Array[Int](2)
    val x1 = x0(0)
    val x2 = x0(1)
    val x3 = x1 <= x2
    val x4 = if (x3) {
      x1
    } else {
      x2
    }
    val x7 = x6(0) = x4
    val x5 = if (x3) {
      x2
    } else {
      x1
    }
    val x8 = x6(1) = x5
    x6
  }
}
/*****************************************
End of Generated Code
*******************************************/
