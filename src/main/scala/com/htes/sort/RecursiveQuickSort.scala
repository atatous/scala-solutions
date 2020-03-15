package com.htes.sort

object RecursiveQuickSort extends App {

  def qsort(a :Array[Int]) :Array[Int] = {
    if(a.length < 2) a else {
      val s = for(i <- a.tail if(i <= a(0))) yield i
      val l = for(i <- a.tail if(i > a(0))) yield i
      qsort(s) ++ Array(a(0)) ++ qsort(l)
    }
  }

  val array = Array(5, 3, 4, 1, 2, 12, 25, 0, 17,13, 15, 10, 2, 5)

  println(array.mkString(","))
  println(qsort(array).mkString(","))
}
