package com.htes.sort

object HeapSort {

  def swap(a: Array[Int], i: Int, j: Int) {
    val temp: Int = a(i)
    a(i) = a(j)
    a(j) = temp
  }

  def maxHeapify(a : Array[Int], i : Int, max : Int) : Unit = {
    val l = 2 * i + 1
    val r = l + 1
    var largest = i
    if (l <  max && a(l) > a(i))
      largest = l
    if(r <  max && a(r) > a(largest))
      largest = r
    if(i != largest) {
      swap(a, i, largest)
      maxHeapify(a, largest, max)
    }
  }

  def buildMaxHeap(a : Array[Int]) : Unit = {
    for(i <- a.length /2 to 0 by -1){
      maxHeapify(a, i, a.length)
    }
  }

  def sort(a : Array[Int]) : Unit = {
    buildMaxHeap(a)
    
    var lastElement = array.length - 1;
    
    while(lastElement > 0) {
      swap(array, 0, lastElement);  
      maxHeapify(array, 0, lastElement);
      lastElement -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    val a = Array(15, 7, 5, 4, 12)
    println(s"[${a.deep.mkString(",")}]")
    sort(a)
    println(s"[${a.deep.mkString(",")}]")
  }

}
