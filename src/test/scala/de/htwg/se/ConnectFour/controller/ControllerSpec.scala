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
      Game.move = 0
      controller.whoseTurnIsIt()
      observer.updated should be (true)
      Game.player should be (Game.player1)
    }
    "notify its Observer if an do/undo/redo step is done" in {
      controller.doStep("0")
      controller.grid.cell(0,0).isSet should be (true)
      controller.undoStep()
      controller.grid.cell(0,0).isSet should be (false)
      controller.redoStep()
      controller.grid.cell(0,0).isSet should be (true)
    }
    "notify its Observer after resetting the grid" in {
      controller.reset()
      observer.updated should be (true)
      controller.grid should be (new Grid())
    }
    "notify its Observer after dropping a piece" in {
      val piece = Piece(Player("Your Name", 1))
      controller.dropPiece(0,piece)
      observer.updated should be (true)
      controller.grid.cell(0,0).isSet should be (true)
    }


  }
}
