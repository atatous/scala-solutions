package com.htes.sort

import scala.language.postfixOps

object SelectionSort extends App: 
  def swap(arr: Array[Int], i: Int, j: Int) = {
    val temp  = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def findMax(arr: Array[Int], start: Int, end: Int): Int = {
    var maxVauleIndex = start
    for (i <- start + 1 to end) {
        if(arr(i) > arr(maxVauleIndex)) maxVauleIndex = i
    }
    maxVauleIndex
  }

  def sort(arr: Array[Int]): Unit =
    for {
      i <- 0 until arr.length
      j = arr.length - 1 - i
      maxIndex = findMax(arr, 0, j)
      if arr(maxIndex) >= arr(j)
    } {
      swap(arr, maxIndex, j)
    }

  val testArray = Array(5, 1, 2, 1, 6, 5)
  println(s"Before: ${testArray.mkString(",")}")
  sort(testArray)
  println(s"After: ${testArray.mkString(",")}")

end SelectionSort