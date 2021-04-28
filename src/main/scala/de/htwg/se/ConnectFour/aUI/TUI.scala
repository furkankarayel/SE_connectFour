package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Piece
import io.AnsiColor._

import scala.io.StdIn.readLine

class TUI(controller: Controller) {

  def processInputLine(input: String):Unit = {
    input match {
      //case "n"=> Board().grid
      case "p" => controller.gridPrint()
      case "q" => println("Tschüss")
      case _ =>
        input.toList.filter(c => c != " ").map(c => c.toString.toInt) match {
          case col :: Nil =>
            Game.player = if(Game.move % 2 == 0)  Game.player1 else Game.player2
            controller.dropPiece(col, Piece(Game.player))
            Game.move+=1
            print(controller.gridPrint)
          case _ => print(controller.gridPrint)
        }
    }
  }

  def gamestart(): Unit ={

    println(Console.BLUE + s"${BOLD}◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.RED + " WELCOME TO CONNECT FOUR " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println("◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙" + Console.YELLOW + " You can start playing by typing a column number 0-6 " + Console.BLUE + "◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙" + Console.YELLOW + " Your turns are always alternating " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.GREEN + " With typing 'q' you can quit " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.MAGENTA + " Good luck and have fun! " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
  }
}
