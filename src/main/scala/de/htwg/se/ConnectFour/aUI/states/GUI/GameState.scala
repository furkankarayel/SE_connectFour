package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl

case class GameState(controller: ControllerImpl, gui:GUI) {
  var state: State[GameState] = InitialState(controller, gui)

  def handle(input: String): Unit = {
    state.handle(input, gui, this)
  }

  def changeState(state: State[GameState]): Unit = {
    this.state = state
    state.handle("",gui,this)
  }

}
