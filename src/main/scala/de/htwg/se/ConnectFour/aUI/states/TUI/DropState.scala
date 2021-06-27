package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.Controller

/**
 * DropState of TUI
 */
case class DropState(controller: Controller) extends State[GameState] {
  override def handle(input: String, state: GameState): Unit = {
    val regExCheck = "([0-6])".r
    if (regExCheck.matches(input))
      controller.drop(Some(input))
    if (controller.checkWin()) {
      state.changeState(WinState(controller))
      state.handle("won")
    }
    if (controller.checkWin())
      state.changeState(WinState(controller))
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
