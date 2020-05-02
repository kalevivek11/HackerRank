

object Solution {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = 4

    val password = "4738"

    val answer = minimumNumber(n, password)

    println(answer)
    //printWriter.println(answer)

    printWriter.close()
  }

  // Complete the minimumNumber function below.
  def minimumNumber(n: Int, password: String): Int = {
    // Return the minimum number of characters to make the password strong
     val numbers = "0123456789".toList
      val lower_case = "abcdefghijklmnopqrstuvwxyz".toList
      val upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList
      val special_characters = "!@#$%^&*()-+".toList
    
      val mapData = scala.collection.mutable.Map(1 -> numbers, 2 -> lower_case, 3 -> upper_case, 4 -> special_characters)
      var mapCheck = scala.collection.mutable.Map(1 -> 0, 2 -> 0, 3 -> 0, 4 -> 0)
      var count = 0

      for (p <- password) {

        var mapCheckKeyList = mapCheck.filter(f => f._2 == 0).map(f => f._1)
        val x = mapCheckKeyList.map(f => {

          if (mapData(f).contains(p)) { mapCheck(f) = 1; count += 1 }
        })
      }

      val nosToAdd = if (count < 4) 4 - count else 0
   
      println("nosToAdd "+ nosToAdd)
      
      if(n < 6)
      {
        if(6-n > nosToAdd) 6-n else nosToAdd
        
      }else nosToAdd
  }
}
