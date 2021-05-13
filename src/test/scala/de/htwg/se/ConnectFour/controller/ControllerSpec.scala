package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.model.{Grid, Piece, Player}
import de.htwg.se.ConnectFour.util.Observer
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers{
  "observed by an Observer" should {
    val player1 = Player("Your Name", 1)
    val player2 = Player("Your Name", 2)
    val controller = new Controller(new Grid(), player1, player2)
    val observer = new Observer {
      var updated: Boolean = false
      def isUpdated: Boolean = updated
      override def update: Boolean = {updated = true; updated}
    }
    controller.add(observer)
    "notify its Observer after creation" in {
      controller.createGrid()
      observer.updated should be (true)
      controller.grid should be (new Grid())
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
