package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fieldbase.gridbase.GridImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WinStateSpec extends AnyWordSpec with Matchers {
  "A Winstate" when {
    val controller = new Controller(new GridImpl)
    val gameState = GameState(controller)
    gameState.changeState(WinState(controller))
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
