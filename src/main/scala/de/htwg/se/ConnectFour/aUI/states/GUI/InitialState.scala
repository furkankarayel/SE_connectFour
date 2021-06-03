package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.State

case class InitialState(controller: Controller) extends State[GameState] {
  override def handle(input: String,state: GameState): Unit = {
    if (controller.players.size == controller.maxPlayers) {
      state.changeState(DropState(controller))
    }
  }
}
