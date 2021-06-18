package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

case class WinState(controller: ControllerImpl) extends State[GameState] {
  override def handle(input: String, gui: GUI, state: GameState): Unit = {
    if(input == "won")
      if (controller.currentPlayer.color == "red")
        new Alert(AlertType.Information){ title = "We have a Winner!"
          headerText = "Congratulations " + controller.currentPlayer.playerName + "!!!"
          contentText = "you are the winner of this round! :)"}.showAndWait()
      else
        new Alert(AlertType.Information){ title = "We have a Winner!"
          headerText = "Congratulations " + controller.currentPlayer.playerName + "!!!"
          contentText = "you are the winner of this round! :)"}.showAndWait()

    else if (input == "n") {
      controller.reset()
      state.changeState(DropState(controller))
    }
    /* input match {
       case "won" => if (controller.currentPlayer.color == "red") new Alert(AlertType.Information, "Player 1 won the game!").showAndWait() else new Alert(AlertType.Information, "Player 1 won the game!").showAndWait()
       case "n" => controller.reset()
     }*/
  }
}
