package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.State
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input

case class InitialState(controller: Controller) extends State[GameState] {
  override def handle(input: String,state: GameState): Unit = {
    if (controller.players.size == controller.maxPlayers) {
      controller.currentPlayer = controller.players(0)

        //controller.drop(Some(input))
        state.changeState(DropState(controller))

    }
    else if (controller.players.size < 3) {
      //controller.addPlayer()
    }
  }
}
