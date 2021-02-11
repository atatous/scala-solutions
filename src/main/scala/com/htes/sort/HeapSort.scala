package com.htes.sort

object HeapSort {

  def swap(a: Array[Int], i: Int, j: Int) {
    val temp: Int = a(i)
    a(i) = a(j)
    a(j) = temp
  }

  def maxHeapify(a : Array[Int], i : Int, lastIndex : Int) : Unit = {
    val l = 2 * i + 1
    val r = 2 * i + 2
    var largest = i
    if(l <  lastIndex && a(l) > a(largest)) largest = l
    if(r <  lastIndex && a(r) > a(largest)) largest = r
    if(i != largest) {
      swap(a, i, largest)
      maxHeapify(a, largest, lastIndex)
    }
  }

  def buildMaxHeap(a : Array[Int]) : Unit = {
    for(i <- a.length /2 to 0 by -1){
      maxHeapify(a, i, a.length)
    }
  }

  def sort(a : Array[Int]) : Unit = {
    buildMaxHeap(a)

    var lastIndex = a.length - 1;

    while(lastIndex > 0) {
      swap(a, 0, lastIndex);
      maxHeapify(a, 0, lastIndex);
      lastIndex -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    val a = Array(15, 7, 5, 4, 12)
    println(s"[${a.mkString(",")}]")
    sort(a)
    println(s"[${a.mkString(",")}]")
  }

}
