package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.aUI.states.GUI.{GameState, WinState}
import de.htwg.se.ConnectFour.aUI.states.{GUI, TUI}
import de.htwg.se.ConnectFour.aUI.states.TUI.WinState
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WinStateSpec extends AnyWordSpec with Matchers {
  "A Winstate" when {
    val controller = new Controller(new Grid)
    val gameState = GameState(controller)
    gameState.changeState(GUI.WinState(controller))
    controller.addPlayer("Franz")
    controller.addPlayer("Jens")
    controller.currentPlayer = controller.players(0)
    "initialised" should {
      "be in drop state" in {
        gameState.state should be (WinState(controller))
      }
      "process input won" in {
        controller.currentPlayer = controller.players(0)
        gameState.handle("won")
        controller.currentPlayer = controller.players(1)
        gameState.handle("won")
      }
      "process invalid input" in {
        gameState.handle("asdasd")
        println("Nobody has won, try playing smarter next time.")
      }
      }

    }

}
