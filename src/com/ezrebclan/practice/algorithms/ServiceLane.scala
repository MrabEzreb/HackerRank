package com.ezrebclan.practice.algorithms

class ServiceLane {

  var linesItr = io.Source.stdin.getLines()
  def main(args: Array[String]): Unit = {
    val initial = getArgsFromLine(getFirstLine())
    val highwayLength = initial(0)
    val testCases = initial(1)
    val widthsStr = getFirstLine()
    val widths = getArgsFromLine(widthsStr)
    if(widths.length != highwayLength) {
      println("error")
    } else {
      val tests = getLines(testCases)
      tests.foreach { s => 
        var currentArgs = getArgsFromLine(s)
        println(getMaxWidth(currentArgs(0), currentArgs(1), widths))
      }
    }
  }
  def getMaxWidth(in: Int, out: Int, widths: Array[Int]): Int = {
    var maxWidth = 3
    for(i <- in to out) {
      if(widths(i) < maxWidth) {
        maxWidth = widths(i)
      }
    }
    maxWidth
  }
  def getFirstLine(): String = {
    linesItr.next()
  }
  def getLines(num: Int): Array[String] = {
    var lines = new Array[String](num)
    linesItr.copyToArray(lines, 0, num)
    lines
  }
  def getArgsFromLine(line: String): Array[Int] = {
    var intsStr = new Array[String](0)
    def addInt(original: Array[String], next: String): Array[String] = {
      var retVal = new Array[String](original.length+1)
      original.copyToArray(retVal, 0)
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
    var ints = intsStr.map { s => s.toInt }
    ints
  }
}