package de.htwg.se.ConnectFour.model

class Boardtest extends AnyWordSpec with Matchers {
  "A Board" when {
    "not set to any value " should {
      val emptyBoard = Board(Matrix[Cell])
      "have empty columns and rows" in {
        grid.value should be(0)
      }
      "not be set" in {
        Board. should be(false)
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
