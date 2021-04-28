package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Piece

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
    println("################################")
    println("####Welcome to Connect Four#####")
    println("################################")
    println("")
    println("You can start playing with your partner by typing a column number 0-6")
    println("After each move it will be the turn of the other player")
    println("Good luck and have fun!")
    println("")
    println("To print the latest board press 'p'")
    println("_______________________________")
    println("If you want to quit the game press 'q'")
  }
}
