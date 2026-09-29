package com.htes.sort

object MergeSort extends App {

  def msort[T](xs: List[T])(using ord: Ordering[T]): List[T] =
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if ord.lt(x, y) then x :: merge(xs1, ys) else y :: merge(xs, ys1)

    val n = xs.length / 2
    if n == 0 then xs
    else
      val (ys, zs) = xs.splitAt(n)
      merge(msort(ys), msort(zs))

  val testArray = Array(5, 1, 2, 1, 6, 5)
  println(s"Before: ${testArray.mkString(",")}")

  println(s"After: ${msort(testArray.toList).mkString(",")}")
}
