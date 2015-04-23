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
  def getLines(): String = {
    var retVal = "First String: "
    retVal += ", Second String: "
    var lines = getLines(2)
    retVal += lines(0)+", Third: "+lines(1)
    retVal
  }
  def getFirstLine(): String = {
    io.Source.stdin.getLines().next()
  }
  def getLines(num: Int): Array[String] = {
    var lines = new Array[String](num)
    io.Source.stdin.getLines().copyToArray(lines, 0, num)
    lines
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
  def getArgsFromLine(line: String): Array[Int] = {
    var intsStr = new Array[String](0)
    def addInt(original: Array[String], next: String): Array[String] = {
      var retVal = new Array[String](original.length+1)
      for(i <- 0 to original.length-1) {
        retVal(i) = original(i)
      }
      retVal(original.length) = next
      retVal
    }
    var currentString = line
    var lastNumber = 0
    for(i <- 0 to line.length()) {
      if(i == line.length()) {
        intsStr = addInt(intsStr, currentString.substring(lastNumber, line.length()))
      } else if(currentString.substring(i, i+1).equals(" ")) {
        intsStr = addInt(intsStr, currentString.substring(lastNumber, i))
        lastNumber = i+1
      }
    }
    var ints = new Array[Int](intsStr.length)
    for(i <- 0 to intsStr.length-1) {
      ints(i) = intsStr(i).toInt
    }
    ints
  }
}