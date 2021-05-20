package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.aUI.TUI
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.model._

import scala.io.StdIn.readLine

object Game {
  val controller = new Controller(new Grid())
  val tui = new TUI(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.RED + " WELCOME TO CONNECT FOUR " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println("◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.BLUE + "Type 2 player names first." + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙" + Console.YELLOW + " You can start playing by typing a column number 0-6 " + Console.BLUE + "◙")
    println(Console.BLUE + "◙◙◙" + Console.YELLOW + " There is an option 'u' for undo and 'r' for redo " + Console.BLUE + "◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.GREEN + " With typing 'q' you can quit " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")

    var input:String = ""
    if (args.length>0){
      input = args(0)
    }
    if (!input.isEmpty) tui.processInput(input)
    else do {
      input = readLine()
      tui.processInput(input)
    } while (input != "q")
  }

}