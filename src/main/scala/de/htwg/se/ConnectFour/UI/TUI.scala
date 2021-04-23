package de.htwg.se.ConnectFour.UI

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.model.Piece

import scala.io.StdIn.readLine

object TUI {
  val game = new Game()

  def main(args: Array[String]): Unit = {
    var input: String = ""
    gamestart()
    do {
      input = readLine()
      processInputLine(input)
    } while (input != "q")
  }

  def processInputLine(input: String):Unit = {
    input match {
      //case "n"=> Board().grid
      case "p" => print(game.board)
      case "q" => println("Tschüss")
      case _ => {
        input.toList.filter(c => c != " ").map(c => c.toString.toInt) match {
          case col :: Nil => {
            game.player = if(game.move % 2 == 0)  game.player1 else game.player2
            game.board.drop(col, Piece(game.player))
            game.move+=1
            print(game.board)
          }
          case _ => print(game.board)
        }
      }
    }
  }

  def gamestart(): Unit ={
    println("Welcome to Connect Four")

    println("You can start playing with your partner by typing a column number 0-6")
    println("After each move it will be the turn of the other player")
    println("Good luck and have fun!")

    println("To print the latest board press 'p'")
    println("_______________________________")
    println("If you want to quit the game press 'q'")
  }
}
