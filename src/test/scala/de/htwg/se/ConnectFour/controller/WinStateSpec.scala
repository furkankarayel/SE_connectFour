package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WinStateSpec extends AnyWordSpec with Matchers {
  "A Winstate" when {
    val controller = new Controller(new Grid)
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
        gameState.handle("won")
        if (controller.currentPlayer.color == "red")
          println(Console.RED +"BOOOOOOOOOOM!!!! Player "+ controller.currentPlayer.playerNumber + " called " + controller.currentPlayer.playerName + " has won the game.")
        else
          println(Console.YELLOW +"BOOOOOOOOOOM!!!! Player "+ controller.currentPlayer.playerNumber + " called " + controller.currentPlayer.playerName + " has won the game.")

      }
      "process invalid input" in {
        gameState.handle("asdasd")
        println("Nobody has won, try playing smarter next time.")
      }
      }

    }

}
