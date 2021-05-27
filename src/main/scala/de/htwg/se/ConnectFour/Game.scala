package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.aUI.{GUI, TUI}
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.util.UI

import scala.io.StdIn.readLine

object Game {


  def main(args: Array[String]): Unit = {
    val controller = new Controller(new Grid())
    val uiType = "GUI"
    var ui:UI =  new TUI(controller)

    uiType match {
      case "TUI" => ui = new TUI(controller)
      case "GUI" => ui= GUI
    }
    controller.notifyObservers
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.RED + " WELCOME TO CONNECT FOUR " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println("◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.BLUE + "Type 2 player names first." + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙" + Console.YELLOW + " You can start playing by typing a column number 0-6 " + Console.BLUE + "◙")
    println(Console.BLUE + "◙◙◙" + Console.YELLOW + " There is an option 'u' for undo and 'r' for redo " + Console.BLUE + "◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.GREEN + " With typing 'q' you can quit " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")

    var input:String = ""
    if (args.length>0){
      input = args(0)
    }
    if (!input.isEmpty) ui.processInput(input)
    else do {
      input = readLine()
      ui.processInput(input)
    } while (input != "q")
  }

}