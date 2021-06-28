package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller

/**
 * DropState of TUI
 */
case class DropState(controller: Controller) extends State[GameState] {
  override def handle(input: String,gui:GUI, state: GameState): Unit = {
    val regExCheck = "([0-6])".r
    if (regExCheck.matches(input))
      controller.drop(input)
    if (controller.checkWin()) {
      state.changeState(WinState(controller))
      state.handle("won")
    }
    if (input == "u") {
      controller.undoDrop()
    }
    if (input == "r") {
      controller.redoDrop()
    }
    if (input == "n") {
      controller.reset()
    }
  }

}
