package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GridSpec extends AnyWordSpec with Matchers {

  "A Grid" when {
      val grid = new Grid()
    "initialised" should {
      "be created with 6 rows and 7 initialised with Cell type None" in {
        grid.cell(0, 0) should be(Cell(None))
        grid.cell(1, 1) should be(Cell(None))
        grid.cell(2, 2) should be(Cell(None))
        grid.cell(3, 3) should be(Cell(None))
        grid.cell(4, 4) should be(Cell(None))
        grid.cell(5, 5) should be(Cell(None))
        grid.cell(5, 6) should be(Cell(None))
      }
    }
    "when not full" should {
      "have a method to replace specific cells" in {
        val replaced = grid.replaceCell(0,3, Cell(Some(Piece(Player("Your Name", 1).pnumber))))
        replaced.cell(0,3).piece should be (Some(Piece(Player("Your Name", 1).pnumber)))
      }
      "have a method to put Pieces into the Grid" in {
        val dropped = grid.drop(0, Piece(Player("Your Name", 1).pnumber))
        dropped.cell(0,0).piece should be (Some(Piece(Player("Your Name", 1).pnumber)))
      }
      "have a method to reset the whole Grid" in {
        grid.reset() should be (new Grid())
      }
    }
    "when full" should {

      "have no new dropped Piece" in {
        var afterFull = new Grid()
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        val newDrop = afterFull.drop(0, Piece(Player("Your Name", 1).pnumber))
        newDrop.rows should be (afterFull.rows)
      }
    }
  }

}