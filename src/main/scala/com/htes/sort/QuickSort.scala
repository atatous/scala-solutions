package com.htes.sort

object NonRecursiveQuickSort extends App {

  def swap(nums: Array[Int], p: Int, q: Int) = {
    val t = nums(p)
    nums(p) = nums(q)
    nums(q) = t
  }

  def partition(nums: Array[Int], p: Int, q: Int): Int = {
    var j = p - 1
    for (i <- p until q)
      if (nums(i) <= nums(q)) {
        j += 1
        swap(nums, i, j)
      }
    swap(nums, j + 1, q)
    j + 1
  }

  def qsort(a: Array[Int]): Array[Int] = {
    var p = 0
    var r = a.length - 1
    while (p < r) {
      val q = partition(a, p, r)
      r = q - 1
    }
    p = 0
    r = a.length - 1
    while (p < r) {
      val q = partition(a, p, r)
      p = q + 1
    }
    a
  }

  val ints = Array(50,4,3,13,22,34,12,11,43,45,23,50)
  println(ints.mkString(","))
  qsort(ints)
  println(ints.mkString(","))
}
