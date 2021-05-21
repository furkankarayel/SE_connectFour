package de.htwg.se.ConnectFour.controller
import de.htwg.se.ConnectFour.util.State

case class InitialState(controller:Controller) extends State[GameState] {
  override def handle(input: String, state: GameState): Unit = {

      if(controller.players.size == controller.maxPlayers) {
        controller.currentPlayer = controller.players(0)
        controller.drop(input)
        state.changeState(DropState(controller))
      }
      else if (controller.players.size < 3){
        controller.addPlayer(input)
      }
  }
}
