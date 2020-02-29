package com.htes.sort

object QuickSort2 extends App {

  def qsort(a :Array[Int]) :Array[Int] = {
    if(a.length < 2) a else {
      val s = for (i <- a.take(a.length-1) if(i <= a(a.length - 1))) yield i
      val l = for (i <- a.take(a.length-1) if(i > a(a.length - 1))) yield i
      qsort(s) ++ Array(a(a.length-1)) ++ qsort(l)
    }
  }

  val array = Array(5, 3, 4, 1, 2, 12, 25, 0, 17,13, 15, 10)
  println(array.mkString(","))
  println(qsort(array).mkString(","))
}
