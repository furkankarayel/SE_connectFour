package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.impl.ControllerImpl

case class InitialState(controller: ControllerImpl) extends State[GameState] {
  override def handle(input: String, state: GameState): Unit = {
    if (controller.players.size == controller.maxPlayers) {
      controller.currentPlayer = controller.players(0)
      if (input != "q") {
        controller.drop(Some(input))
        state.changeState(DropState(controller))
      }
    }
    else if (controller.players.size < 3 && input != "q") {
      controller.addPlayer(input)
    }
  }
}
