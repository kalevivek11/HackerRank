object Solution {

  def missingNumbers(arr: Array[Int], brr: Array[Int]): List[Int] = {
    // Complete this function

    var hash = scala.collection.mutable.Map[Int, Int]()
    var temp: Array[Int] = Array()

    brr.map(f => {
      val quant = hash.get(f).getOrElse(0)
      if (quant > 0) {
        hash(f) = quant + 1
      } else {
        hash += (f -> 1)
      }
    })




    arr.map(f => {
      val quant = hash.get(f).getOrElse(0)
      if (quant > 0) {
        hash(f) = quant - 1
      }
    })


    val s = hash.filter(p => p._2 > 0).map(f => f._1)

    s.toList.sorted

  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    var m = sc.nextInt();
    var brr = new Array[Int](m);
    for(brr_i <- 0 to m-1) {
      brr(brr_i) = sc.nextInt();
    }
    val result = missingNumbers(arr, brr);
    println (result.mkString(" "))


  }
}
