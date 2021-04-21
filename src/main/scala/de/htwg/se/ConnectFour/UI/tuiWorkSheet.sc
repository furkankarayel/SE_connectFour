import de.htwg.se.ConnectFour.model.Board

import scala.io.StdIn.readLine
import scala.language.postfixOps

case class TUI() {
  val board = Board
  val input = readLine()
  val started = 0
  gamestart()
  while(true) {
    inputProcessor(input)
  }

  def gamestart(): Unit ={
    println("Welcome to Connect Four")
    println("Type a name for Player 1")

    /*
    if (input == "yellow") {
      println("Player one has color yellow, Player two has color red")
    } else if (input == "red") {
      println("Player one has color red, Player two has color yellow")
    } else {
      println("Please choose yellow or red!")
    }
    */
  }

  def inputProcessor(in: String): Unit = {
    in match {
      case "start" => ""
      case _ => "input was wrong"
    }

  }

  def helpCommand(): Unit = {

  }

}
