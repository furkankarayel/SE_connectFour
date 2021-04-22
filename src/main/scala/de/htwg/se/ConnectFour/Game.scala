package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.UI.TUI
import de.htwg.se.ConnectFour.model._



class Game {
  val board = new Board()
  val player1 = Player("Jens", 1)
  val player2 = Player("Eric", 2)
  var player = player1
  var move = 0

}
