package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GridSpec extends AnyWordSpec with Matchers {

  "A Grid is the matrix of the ConnectFour Game. A Grid" when {
    "new" should {
      val grid = new Grid()
      "have rows of type Vector of Vector of type Cell" in {
        grid.rows.getClass should be (Vector[Vector[Cell]])
      }
      "have rows and columns initialised with Cell type None" in {
        grid.cell(6, 7) should be(Cell(None))
      }
      "have a method to replace specific cells" in {
        val player1 = Player("Your Name", 2)
        val piecep1 = Piece(player1)
        val updatedGrid = grid.replaceCell(0,3, Cell(Some(piecep1)))
        grid.cell(0,3).piece should be
      }
    }
  }
}