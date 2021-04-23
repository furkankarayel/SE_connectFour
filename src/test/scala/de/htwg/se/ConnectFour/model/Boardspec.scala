package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Boardspec extends AnyWordSpec with Matchers {

  "A Board" when {
    "to be printed" should {
      "show the Status of the Cells" in {
        val board = Board()
        val printedGrid = board.printGrid()
      }
      "be empty" in {
        val board = Board()
        val emptyGrid = board.reset()
      }
      "get a Piece at the lowest possible row" in {
        val board = Board()
      }
    }
    "set to a specific value" should {
      val nonEmptyCell = Cell(5)
      "return that value" in {
        nonEmptyCell.value should be(5)
      }
      "be set" in {
        nonEmptyCell.isSet should be(false) /// Fehler
      }
    }
  }

}
