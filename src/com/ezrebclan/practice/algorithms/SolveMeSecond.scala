package com.ezrebclan.practice.algorithms

class SolveMeSecond {

  def main(args: Array[String]): Unit = {
    var allLines = io.Source.stdin.getLines()
    var linesStr = allLines.next()
    var lines = linesStr.toInt
    var maths: Array[String] = new Array[String](lines)
    var mathsIndex = 0
    allLines.copyToArray(maths, 0, lines)
    maths.iterator.foreach { x =>
      println(x.substring(0, x.indexOf(" ")).toInt+x.substring(x.indexOf(" ")+1).toInt)
    }
  }
}