package de.htwg.se.ConnectFour.model

import de.htwg.se.ConnectFour.model.fieldbase.{CellImpl, PieceImpl, PlayerImpl}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CellSpec extends AnyWordSpec with Matchers {

  "A Cell" when {
    "not set to any value " should {
      val emptyCell = CellImpl(None)
      "have value 0" in {
        emptyCell.piece should be(None)
      }
      "not be set" in {
        emptyCell.isSet should be(false)
      }
      "have a nice String representation" in {
        emptyCell.toString should be (Console.BLUE + "_ ")
      }
    }
    "set to a specific value" should {
      val player = PlayerImpl("Your Name",1)
      val nonEmptyCell = CellImpl(Some(PieceImpl(player)))
      "return that value" in {
        nonEmptyCell.piece should be(Some(PieceImpl(PlayerImpl("Your Name",1))))
      }
      "be set" in {
        nonEmptyCell.isSet should be(true)
      }
      "have a nice String representation" in {
        nonEmptyCell.toString should be (Console.RED + "☻ ")
      }
    }
  }


}