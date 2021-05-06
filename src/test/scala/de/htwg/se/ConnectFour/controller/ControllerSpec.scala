package de.htwg.se.ConnectFour.controller

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
      override def update: Unit = updated = true
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