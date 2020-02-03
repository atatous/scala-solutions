package com.htes.sort

object QuickSort2 extends App {

  def qsort(a :IndexedSeq[Int]) :IndexedSeq[Int] = {
    if(a.length < 2) {
      a  // base case
    } else {
      val smaller = for (i <- (0 until a.length - 1) if (a(i) <= a(a.length - 1))) yield a(i)
      val larger = for (i <- (0 until a.length - 1) if (a(i) > a(a.length - 1))) yield a(i)
      qsort(smaller) ++ IndexedSeq(a(a.length-1)) ++ qsort(larger)
    }
  }

  val oneToFive = IndexedSeq(5, 3, 4, 1, 2, 12, 25, 0, 10)
  println(qsort(oneToFive))
}
