package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.Game
import de.htwg.se.ConnectFour.model.{Grid, Piece, Player}
import de.htwg.se.ConnectFour.util.Observer
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers{
  "observed by an Observer" should {
    val controller = new Controller(new Grid())
    val observer = new Observer {
      var updated: Boolean = false
      def isUpdated: Boolean = updated
      override def update: Boolean = {updated = true; updated}
    }
    controller.add(observer)
    "notify its Observer after grid creation" in {
      controller.createGrid()
      observer.updated should be (true)
      controller.grid should be (new Grid())
    }
    "notify its Observer which player has the turn" in {
      controller.move = 0
      controller.addPlayer("Player1")
      controller.addPlayer("Player2")
      controller.currentPlayer = controller.players(0)
      controller.whoseTurnIsIt()
      observer.updated should be (true)
      controller.currentPlayer should be (controller.players(0))
    }
    "notify its Observer if an do/undo/redo step is done" in {
      controller.drop("0")
      controller.grid.cell(0,0).isSet should be (true)
      controller.undoDrop()
      controller.grid.cell(0,0).isSet should be (false)
      controller.redoDrop()
      controller.grid.cell(0,0).isSet should be (true)
    }
    "notify its Observer after resetting the grid" in {
      controller.reset()
      observer.updated should be (true)
      controller.grid should be (new Grid())
    }
  }
}
