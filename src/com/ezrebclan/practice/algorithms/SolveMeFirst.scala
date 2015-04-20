package com.ezrebclan.practice.algorithms

class SolveMeFirst {

  def main(args: Array[String]): Unit = {
    var output: Int = 0
    var lines = io.Source.stdin.getLines().take(2)
    lines.foreach { i => output += i.toInt }
    println(output)
  }
}