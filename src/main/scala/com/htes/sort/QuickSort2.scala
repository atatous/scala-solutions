package com.htes.sort

object QuickSort2 extends App {

  def qsort(a :Array[Int]) :Array[Int] = {
    if(a.length < 2) a else {
      val p = a.length-1
      val s = for (i <- a.take(p) if(i <= a(p))) yield i
      val l = for (i <- a.take(p) if(i > a(p))) yield i
      qsort(s) ++ Array(a(p)) ++ qsort(l)
    }
  }

  val array = Array(5, 3, 4, 1, 2, 12, 25, 0, 17,13, 15, 10)
  println(array.mkString(","))
  println(qsort(array).mkString(","))
}
