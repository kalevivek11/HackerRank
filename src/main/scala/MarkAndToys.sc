import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {

    val sortedPrices = prices.sorted

    def aa(sPrices: Array[Int], sum: Int , count: Int): Int={

      if(sum < sPrices.head) count
      else aa(sPrices.drop(1), sum-sPrices(0), count+1)

    }

    aa(sortedPrices, k, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    printWriter.println(result)

    printWriter.close()
  }
}
