package com.ezrebclan.practice.algorithms

object MaximizingXOR {

  def maxXor(l: Int, r: Int): Int = {
    var retValStr = ""
    var le2 = l
    var ri2 = r
    if(l > r) {
      le2 = r
      ri2 = l
    }
    var biggest = 0
    for(le <- le2 to ri2) {
      for(ri <- le2 to ri2) {
        var left = le.toBinaryString
        var right = ri.toBinaryString
        while(left.length() < 4) {
          left = "0"+left
        }
        while(right.length() < 4) {
          right = "0"+right
        }
        var number = ""
        for(bit <- 0 to 3) {
          number += xorBit(left.substring(bit, bit+1), right.substring(bit, bit+1))
        }
        if(Integer.parseInt(number, 2) > biggest) {
          biggest = Integer.parseInt(number, 2)
        }
      }
    }
    retValStr = biggest.toString()
    var retVal = retValStr.toInt
    retVal
  }
  def xorBit(bit1: String, bit2: String): String = {
    var retVal = "";
    if(bit1.equals(bit2)) {
      retVal = "0"
    } else {
      retVal = "1"
    }
    retVal
  }
  def main(args: Array[String]): Unit = {
    maxXor(10, 15)
  }
}