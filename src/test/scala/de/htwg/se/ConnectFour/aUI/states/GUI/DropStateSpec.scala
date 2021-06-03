package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class DropStateSpec extends AnyWordSpec with Matchers {
  "A Dropstate" when {
    val controller = new Controller(new Grid)
    val gui = GUI(controller)
    val gameState = GameState(controller,gui)
    gameState.changeState(DropState(controller))
    controller.addPlayer("Franz")
    controller.addPlayer("Jens")
    controller.currentPlayer = controller.players(0)
    "initalised" should {
      "be in drop state" in {
        gameState.state should be (DropState(controller))
      }
      "drop a piece and check if any player has won the game" in {
        gameState.handle("2")
        gameState.handle("3")
        gameState.handle("4")
        gameState.handle("5")
      }
    }
  }
}
