package de.htwg.se.ConnectFour.controller
import de.htwg.se.ConnectFour.util.State

case class WinState(controller: Controller) extends State[GameState]{
  override def handle(input: String, state: GameState): Unit = {
    print("feierabend")
  }
}
