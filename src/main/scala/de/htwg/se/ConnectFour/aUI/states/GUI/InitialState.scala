package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl

case class InitialState(controller: ControllerImpl, gui:GUI) extends State[GameState] {
  override def handle(input: String,gui:GUI,state: GameState): Unit = {
    if (controller.players.size == controller.maxPlayers) {
      state.changeState(DropState(controller))
      gui.refreshView()
    }
  }
}
