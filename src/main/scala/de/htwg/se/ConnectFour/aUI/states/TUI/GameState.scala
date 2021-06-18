package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.impl.ControllerImpl

case class GameState(controller: ControllerImpl) {
  var state: State[GameState] = InitialState(controller)

  def handle(input: String): Unit = {
    state.handle(input, this)
  }

  def changeState(state: State[GameState]): Unit = {
    this.state = state
  }

}
