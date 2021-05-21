package de.htwg.se.ConnectFour.controller
import de.htwg.se.ConnectFour.util.State

case class DropState(controller:Controller) extends State[GameState] {
  override def handle(input: String, state: GameState): Unit = {
    val regExCheck = "([0-6])".r
    if(regExCheck.matches(input))
      controller.drop(input)
      if(controller.checkWin()) {
        state.changeState(WinState(controller))
        state.handle("won")
      }
    if(controller.checkWin())
      state.changeState(WinState(controller))
  }
}
