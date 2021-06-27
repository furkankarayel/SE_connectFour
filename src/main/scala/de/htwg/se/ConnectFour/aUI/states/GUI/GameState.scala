package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller

/**
 * GameState of GUI
 */
case class GameState(controller: Controller, gui:GUI) {
  var state: State[GameState] = InitialState(controller, gui)

  def handle(input: String): Unit = {
    state.handle(input, gui, this)
  }

  def changeState(state: State[GameState]): Unit = {
    this.state = state
    state.handle("",gui,this)
  }

}
