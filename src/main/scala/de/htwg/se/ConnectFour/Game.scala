package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.aUI.TUI
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.model._

import scala.io.StdIn.readLine

object Game {
  val player1 = Player("Jens", 1)
  val player2 = Player("Eric", 2)
  var player = player1
  var move = 0

  val controller = new Controller(new Grid())
  val tui = new TUI(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    tui.gamestart()
    var input: String = args(0)
    if (!input.isEmpty) tui.processInputLine(input)
    else do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")
  }

}