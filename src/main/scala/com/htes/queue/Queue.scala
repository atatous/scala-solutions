package com.htes.queue

/**
  * This is a generic array based circular buffer queue.
  * The capacity of this queue is size - 1.
  * Int.MaxValue denotes invalid value.
  *
  */
class Queue(size : Int) {
  /** Points to the head, the oldest item added */
  var head = 0

  /** Points to the tail, the newest item added */
  var tail = 0

  /** Points to the actual buffer  */
  val buff = new Array[Int](size)

  def isEmpty = head == tail

  def isFull =  head == (tail + 1) % buff.length

  def insert(t : Int) {
    if (!isFull) {
      buff(tail) = t
      tail = (tail + 1) % buff.length
    }
  }

  def delete : Int = {
    var num : Int = Int.MaxValue
    if (!isEmpty) {
      num = buff(head)
      buff(head) = Int.MaxValue
      head = (head + 1) % buff.length
    }
    num
  }

  def display {
    System.out.print("head=" + head + ", tail=" + tail + "\nBuffer : ");
    for (i <- head until tail) {
      print(s"${buff(i)}, ");
    }
    println();
  }
}
