package com.htes.sort


object TailRecursiveQuickSort {

  def swap(nums  :Array[Int], p :Int, q :Int)= {
    val t = nums(p)
    nums(p) = nums(q)
    nums(q) = t
  }

  def partition(nums  :Array[Int], p :Int, q :Int) :Int = {
    var j = p -1
    for(i <- p until q)
      if(nums(i) <= nums(q)) {
        j += 1
        swap(nums, i, j)
      }
    swap(nums, j+1, q)
    j+1
  }

  def qsort(nums :Array[Int], p :Int, q :Int) :Unit = {
    if (p<q) {
      val r = partition(nums, p, q)
      qsort(nums, p, r - 1)
      qsort(nums, r + 1, q)
    }
  }

  def main(args :Array[String]) :Unit = {
    val array = Array(5, 3, 4, 1, 2, 12, 25, 0, 17,13, 15, 10, 2, 5)

    println(array.mkString(","))
    qsort(array, 0, array.length-1)
    println(array.mkString(","))
  }


}