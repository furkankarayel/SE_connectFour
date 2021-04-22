import de.htwg.se.ConnectFour.model.Board

import scala.language.postfixOps

case class TUI() {

  def gamestart(): Unit = {
    println("Welcome to Connect Four")
    println("Type a name for Player 1")
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
