package com.ezrebclan.practice.algorithms

class Reader {

  def getArgs(): Array[Int] = {
    var lines = io.Source.stdin.getLines().next().toInt
    var output: Array[Int] = new Array[Int](lines)
    var allLines = io.Source.stdin.getLines()
    var input = new Array[String](lines)
    allLines.copyToArray(input, 1, lines)
    var outIt = 0
    input.foreach { s => output(outIt) = s.toInt
      outIt += 1
    }
    output
  }
  def getDoubleArgs(): Array[Array[Int]] = {
    var lines = io.Source.stdin.getLines().next().toInt
    var output = Array.ofDim[Int](lines, 2)
    var allLines = io.Source.stdin.getLines()
    var input = new Array[String](lines)
    allLines.copyToArray(input, 1, lines)
    var outIt = 0
    input.foreach { s => output(outIt)(0) = s.substring(0, s.indexOf(" ")).toInt
      output(outIt)(1) = s.substring(s.indexOf(" ")+1).toInt
      outIt += 1
    }
    output
  }
}