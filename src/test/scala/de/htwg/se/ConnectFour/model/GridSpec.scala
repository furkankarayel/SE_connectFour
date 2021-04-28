package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GridSpec extends AnyWordSpec with Matchers {

  "A Grid is the matrix of the ConnectFour Game. A Grid" when {
    "new" should {
      val grid = new Grid()
      "be created with 6 rows and 7 initialised with Cell type None" in {
        grid.cell(0,0) should be (Cell(None))
        grid.cell(1,1) should be (Cell(None))
        grid.cell(2,2) should be (Cell(None))
        grid.cell(3,3) should be (Cell(None))
        grid.cell(4,4) should be (Cell(None))
        grid.cell(5,5) should be (Cell(None))
        grid.cell(5,6) should be (Cell(None))
      }
      "have a method to replace specific cells" in {
        val updatedGrid = grid.replaceCell(0,3, Cell(Some(Piece(Player("Your Name", 1)))))
        grid.cell(0,3).piece should be
      }
    }
  }
}