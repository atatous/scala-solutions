package com.htes.sort

import scala.collection.mutable.ArrayBuffer

object QuickSort {

  def swap(nums  :ArrayBuffer[Int], p :Int, q :Int)= {
    val t = nums(p)
    nums(p) = nums(q)
    nums(q) = t
  }

  def partition(nums  :ArrayBuffer[Int], p :Int, q :Int) :Int = {
    var j = p -1
    for(i <- p until q)
      if(nums(i) <= nums(q)) {
        j += 1
        swap(nums, i, j)
      }
    swap(nums, j+1, q)
    j+1
  }

  def sort(nums  :ArrayBuffer[Int], p :Int, q :Int) :Unit = {
    if (p<q) {
      val r = partition(nums, p, q)
      sort(nums, p, r - 1)
      sort(nums, r + 1, q)
    }
  }

  def main(args :Array[String]) :Unit = {
    val ints = ArrayBuffer(50,4,3,13,22,34,12,11,43,45,23,50)
    println(s"Before: $ints")
    sort(ints, 0, ints.length-1)
    println(s"After: $ints")
  }


}
