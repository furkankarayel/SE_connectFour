package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller

case class WinState(controller: Controller) extends State[GameState] {
  override def handle(input: String,gui:GUI, state: GameState): Unit = {
    if (input == "won") {
      if (controller.currentPlayer.color == "red")
        println(Console.RED + "BOOOOOOOOOOM!!!! Player " + controller.currentPlayer.playerNumber + " called " + controller.currentPlayer.playerName + " has won the game.")
      else
        println(Console.YELLOW + "BOOOOOOOOOOM!!!! Player " + controller.currentPlayer.playerNumber + " called " + controller.currentPlayer.playerName + " has won the game.")
    }
  }
}
