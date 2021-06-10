package de.htwg.se.ConnectFour.model

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fieldbase.{CellImpl, Grid, PieceImpl, PlayerImpl}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GridSpec extends AnyWordSpec with Matchers {

  "A Grid" when {
      val grid = new GridImpl()
    "initialised" should {
      "be created with 6 rows and 7 initialised with Cell type None" in {
        grid.cell(0, 0) should be(CellImpl(None))
        grid.cell(1, 1) should be(CellImpl(None))
        grid.cell(2, 2) should be(CellImpl(None))
        grid.cell(3, 3) should be(CellImpl(None))
        grid.cell(4, 4) should be(CellImpl(None))
        grid.cell(5, 5) should be(CellImpl(None))
        grid.cell(5, 6) should be(CellImpl(None))
      }
    }
    "when not full" should {
      "have a method to replace specific cells" in {
        val replaced = grid.replaceCell(0,3, CellImpl(Some(PieceImpl(PlayerImpl("Your Name", 1)))))
        replaced.cell(0,3).piece should be (Some(PieceImpl(PlayerImpl("Your Name", 1))))
      }
      "have a method to put Pieces into the Grid" in {
        val dropped = grid.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        dropped.cell(0,0).piece should be (Some(PieceImpl(PlayerImpl("Your Name", 1))))
      }
      "have a method to reset the whole Grid" in {
        grid.reset() should be (new GridImpl())
      }
    }
    "when full" should {
      "have no new dropped Piece" in {
        var afterFull = new GridImpl()
        afterFull = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        afterFull = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        afterFull = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        afterFull = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        afterFull = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        afterFull = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        val newDrop = afterFull.drop(0, PieceImpl(PlayerImpl("Your Name", 1)))
        newDrop.rows should be(afterFull.rows)
      }
    }
    "when filled specifically" should {
      "wrong it shouldn't be checked correctly" in {
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.currentPlayer = controller.players(0)
        controller.checkWin() should be(false)
      }
      "all patterns should be checked correctly" in {
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,1, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,2, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,3, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,1, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,2, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,3, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(5,6, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(4,5, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,4, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,3, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.currentPlayer = controller.players(0)
        controller.checkWin() should be (true)
      }
      "any horizontal pattern be checked correctly" in {
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,1, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,2, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(0,3, CellImpl(Some(PieceImpl(controller.players(0)))))
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
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,0, CellImpl(Some(PieceImpl(controller.players(0)))))
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
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,0, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,1, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,2, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,3, CellImpl(Some(PieceImpl(controller.players(0)))))
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
        var controller = new Controller(new GridImpl())
        controller.grid.reset()
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(5,6, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(4,5, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,4, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,3, CellImpl(Some(PieceImpl(controller.players(0)))))
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
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(5,0, CellImpl(Some(PieceImpl(controller.players(1)))))
        controller.grid = controller.grid.replaceCell(4,1, CellImpl(Some(PieceImpl(controller.players(1)))))
        controller.grid = controller.grid.replaceCell(3,2, CellImpl(Some(PieceImpl(controller.players(1)))))
        controller.grid = controller.grid.replaceCell(2,3, CellImpl(Some(PieceImpl(controller.players(1)))))
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
        var controller = new Controller(new GridImpl())
        controller.addPlayer("Player1")
        controller.addPlayer("Player2")
        controller.grid = controller.grid.replaceCell(0,6, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(1,5, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(2,4, CellImpl(Some(PieceImpl(controller.players(0)))))
        controller.grid = controller.grid.replaceCell(3,3, CellImpl(Some(PieceImpl(controller.players(0)))))
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