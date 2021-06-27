package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller

/**
 * InitialState of GUI
 */
case class InitialState(controller: Controller, gui:GUI) extends State[GameState] {
  override def handle(input: String,gui:GUI,state: GameState): Unit = {
    if (controller.players.size == controller.maxPlayers) {
      state.changeState(DropState(controller))
      gui.refreshView()
      controller.currentPlayer = controller.players(0)
    }
  }
}
