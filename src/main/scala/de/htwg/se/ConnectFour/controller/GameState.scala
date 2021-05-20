package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.util.State

case class GameState(controller:Controller) {
  var state: State[GameState] = InitialState(controller)

  def handle(input:String): Unit = {
    state.handle(input,this)
  }
  def changeState(state: State[GameState]): Unit = {
    this.state = state
  }

}
