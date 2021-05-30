package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import de.htwg.se.ConnectFour.controller
import de.htwg.se.ConnectFour.controller.Controller

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
        val replaced = grid.replaceCell(0,3, Cell(Some(Piece(Player("Your Name", 1)))))
        replaced.cell(0,3).piece should be (Some(Piece(Player("Your Name", 1))))
      }
      "have a method to put Pieces into the Grid" in {
        val dropped = grid.drop(0, Piece(Player("Your Name", 1)))
        dropped.cell(0,0).piece should be (Some(Piece(Player("Your Name", 1))))
      }
      "have a method to reset the whole Grid" in {
        grid.reset() should be (new Grid())
      }
    }
    "when full" should {
      "have no new dropped Piece" in {
        var afterFull = new Grid()
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        val newDrop = afterFull.drop(0, Piece(Player("Your Name", 1)))
        newDrop.rows should be(afterFull.rows)
      }
    }
    "when filled specifically" should {
      "wrong it shouldn't be checked correctly" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.currentPlayer = controller.players(0)
        controller.checkWin() should be(false)
      }
      "all patterns should be checked correctly" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,1, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,2, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,3, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,1, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,2, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,3, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(5,6, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(4,5, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,4, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,3, Cell(Some(Piece(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        controller.checkWin() should be (true)
      }
      "any horizontal pattern be checked correctly" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,1, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,2, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,3, Cell(Some(Piece(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        val horizontal = controller.winPatternHorizontal()
        var bool = false
        horizontal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be (true)
      }
      "any vertical pattern be checked correctly" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,0, Cell(Some(Piece(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        val vertical = controller.winPatternVertical()
        var bool = false
        vertical match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be (true)
      }
      "the bottom left corner be checked correctly ascending diagonally" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,1, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,2, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,3, Cell(Some(Piece(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        val ascDiagonal = controller.winPatternAscendingDiagonal()
        var bool = false
        ascDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be (true)
      }

      "the upper right corner be checked correctly ascending diagonally" in {
        var controller = new Controller(new Grid())
        controller.grid.reset()
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(5,6, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(4,5, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,4, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,3, Cell(Some(Piece(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        val ascDiagonal = controller.winPatternAscendingDiagonal()
        var bool = false
        ascDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be (true)
      }
      "the upper left corner be checked correctly descending diagonally if a player has won the game" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(5,0, Cell(Some(Piece(controller.players(1)))))
        controller.grid = controller.grid.replaceCell(4,1, Cell(Some(Piece(controller.players(1)))))
        controller.grid = controller.grid.replaceCell(3,2, Cell(Some(Piece(controller.players(1)))))
        controller.grid = controller.grid.replaceCell(2,3, Cell(Some(Piece(controller.players(1)))))
        controller.currentPlayer = controller.players(1)
        val descDiagonal = controller.winPatternDescendingDiagonal()
        var bool = false
        descDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be (true)
      }
      "the bottom right corner be checked correctly descending diagonally if a player has won the game" in {
        var controller = new Controller(new Grid())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,6, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,5, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,4, Cell(Some(Piece(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,3, Cell(Some(Piece(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        val descDiagonal = controller.winPatternDescendingDiagonal()
        var bool = false
        descDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be (true)
      }

    }
  }

}