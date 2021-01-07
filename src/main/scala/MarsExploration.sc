object Solution {

  def marsExploration(s: String): Int =  {
    var count =0
    val list = s.grouped(3).toList
    list.map(f => if (!f.equals("SOS")){
      if( f(0)!='S') count+=1
      if( f(1)!='O') count+=1
      if( f(2)!='S') count+=1
    })
    count
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.next();
    val result = marsExploration(s);
    println(result)
  }
}
