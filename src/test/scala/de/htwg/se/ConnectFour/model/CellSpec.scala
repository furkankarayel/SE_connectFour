package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CellSpec extends AnyWordSpec with Matchers {

  "A Cell" when {
    "not set to any value " should {
      val emptyCell = Cell(None)
      "have value 0" in {
        emptyCell.piece should be(None)
      }
      "not be set" in {
        emptyCell.isSet should be(false)
      }
    }
    "set to a specific value" should {
      val player = Player("Your Name",1)
      val nonEmptyCell = Cell(Some(Piece(player)))
      "return that value" in {
        nonEmptyCell.piece should be(Some)
      }
      "be set" in {
        nonEmptyCell.isSet should be(true)
      }
    }
  }


}