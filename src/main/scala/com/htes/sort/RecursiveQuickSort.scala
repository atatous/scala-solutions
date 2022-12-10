package com.htes.sort

object RecursiveQuickSort extends App {

  def qsort(a :Array[Int]) :Array[Int] = {
    if(a.length < 2) a else {
      val (s, l) = a.tail.partition(_ < a.head)
      qsort(s) ++ Array(a.head) ++ qsort(l)
    }
  }

  val array = Array(5, 3, 4, 1, 2, 12, 25, 0, 17,13, 15, 10, 2, 5)

  println(array.mkString(","))
  println(qsort(array).mkString(","))
}
