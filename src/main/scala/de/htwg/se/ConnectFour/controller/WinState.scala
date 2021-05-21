package de.htwg.se.ConnectFour.controller
import de.htwg.se.ConnectFour.util.State

case class WinState(controller: Controller) extends State[GameState]{
  override def handle(input: String, state: GameState): Unit = {
    if(input == "won") {
      if (controller.currentPlayer.color == "red")
        println(Console.RED +"BOOOOOOOOOOM!!!! Player "+ controller.currentPlayer.playerNumber + " called " + controller.currentPlayer.playerName + " has won the game.")
      else
        println(Console.YELLOW +"BOOOOOOOOOOM!!!! Player "+ controller.currentPlayer.playerNumber + " called " + controller.currentPlayer.playerName + " has won the game.")
    } else
      println("Nobody has won, try playing smarter next time.")
  }
}
