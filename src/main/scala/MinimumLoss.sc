object Solution {

  def minimumLoss(price: Array[Long]): Long = {
    var hash = scala.collection.mutable.Map[Long, Int]()
    var i = 0;
    price.map(f => {
      hash += (f -> i)
      i += 1
    })
    // hash.map(f => println(f._1 + " " + f._2))
    val pS = price.sorted

    //  pS.map(f => println(f))
    var diff = Long.MaxValue;
    //  println("length is" + pS.length)
    for (i <- 0 to pS.length - 2) {
      var j = i + 1

      //  println("diff is " + diff)
      if (hash((pS(j))) < hash((pS(i)))) {
        //  println(pS(j) + " " + pS(i))
        if (diff > (pS(j) - pS(i))) diff = (pS(j) - pS(i))
      }

    }

    diff
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var price = new Array[Long](n);
    for(price_i <- 0 to n-1) {
      price(price_i) = sc.nextLong();
    }
    val result = minimumLoss(price);
    println(result)
  }
}
