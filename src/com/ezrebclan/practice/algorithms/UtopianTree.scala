package com.ezrebclan.practice.algorithms

class UtopianTree {

  def main(args: Array[String]): Unit = {
    val args2 = getArgs()
    var growths = new Array[String](args2.length)
    var it = 0
    growths.foreach { s =>
      growths(it) = getGrowth(args2(it)).toString()
      it += 1
    }
    growths.foreach { s => println(s) }
  }
  def getArgs(): Array[Int] = {
    var allLines = io.Source.stdin.getLines()
    var lines = allLines.next().toInt
    var output = new Array[Int](lines)
    var input = new Array[String](lines)
    allLines.copyToArray(input, 0, lines)
    var outIt = 0
    input.foreach { s => output(outIt) = input(outIt).toInt
      outIt += 1
    }
    output
  }
  def getGrowth(cycles: Int): Int = {
    val originalHeight = 1
    var completedCycles = 0
    var currentHeight = originalHeight
    while (completedCycles < cycles) {
      if(completedCycles % 2 == 0) {
        currentHeight = growInSpring(currentHeight)
      } else if(completedCycles % 2 == 1) {
        currentHeight = growInSummer(currentHeight)
      }
      completedCycles += 1
    }
    currentHeight
  }
  def growInSpring(height: Int): Int = {
    height*2
  }
  def growInSummer(height: Int): Int = {
    height+1
  }
}