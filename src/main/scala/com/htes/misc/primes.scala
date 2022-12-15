object Main {

  def isPrime2(n: Int): Boolean = {
    (2 to math.sqrt(n).toInt) forall (x => n % x != 0)
  }

  def isPrime(n: Int): Boolean = {
    (2 to n/2) forall (x => n % x != 0)
  }

  def getExponent(num: Int, denom:Int, times: Int, remainder: Int): Int = {
    if(remainder == 0)
      getExponent(num/denom, denom, times + 1, num % denom)
    else
      times - 1
  }

  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.Map
    val result = Map[Int, Int]().withDefaultValue(0)

    while (true) {
      result.clear()
      println("Enter an odd number between 1 to 9999:")
      val num = scala.io.StdIn.readInt
      val t = System.currentTimeMillis
      val primes = for (i <- (2 to num) if isPrime2(i)) yield i
      println(s"Calc-ed ${primes.size} PRIMEs less than $num in ${System.currentTimeMillis - t} ms")
      println(s"PRIMEs: ${primes.mkString(",")}")
      for (prime <- primes if num % prime == 0) yield result(prime) = result(prime) + getExponent(num, prime, 0, 0)
      if (isPrime(num)) println(s"$num is a PRIME number") else {
        println(s"$num is NOT a PRIME number")
        print(s"$num =")
        result.foreach(kv => print(s"1x${kv._1}^${kv._2}"))
        println()
      }
    }
  }
}
