package de.htwg.se.ConnectFour.model.fileio.xml

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fileio.FileIO
import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.grid.impl.{Cell, Piece}


import scala.xml.PrettyPrinter

/**
 * FileIO implementation
 * for exporting the game as XML File
 */
class FileIOImpl() extends FileIO {

  override def load(controller:Controller): Unit = {
    val file = scala.xml.XML.loadFile("game.xml")
    val currentPlayer = (file \\ "game" \\ "player" \\ "currentPlayer").text
    val player1 = (file \\ "game" \\ "player" \\ "player1").text
    val player2 = (file \\ "game" \\ "player" \\ "player2").text
    val moveCount = (file \\ "game" \\ "player" \\ "moveCount").text.trim.toInt

    var newGrid: Grid = controller.getGrid()
    controller.setMoveCount(moveCount)
    controller.addPlayer(player1)
    controller.addPlayer(player2)
    currentPlayer match {
      case player1 => controller.setCurrentPlayer(controller.players(0))
      case player2 => controller.setCurrentPlayer(controller.players(1))
    }

    val cellNodes = (file \\ "grid" \\ "cell")
    for (cell <- cellNodes) {
      val row: Int = (cell \\ "@row").text.toInt
      val col: Int = (cell \\ "@col").text.toInt
      val value: Int = cell.text.trim.toInt

      val optPiece = (value) match {
        case 1 => Some(Piece(controller.players(0)))
        case 2 => Some(Piece(controller.players(1)))
        case _ => None
      }
      newGrid = newGrid.replaceCell(row, col, Cell(optPiece))
    }
    controller.setGrid(newGrid)
  }
  def gameToXml(controller: Controller) = {
    <game>
      <player>
        <moveCount>
          { controller.moveCount }
        </moveCount>
        <currentPlayer>
          { controller.currentPlayer.playerName }
        </currentPlayer>
        <player1>
          { controller.players(0).playerName }
        </player1>
        <player2>
          { controller.players(1).playerName }
        </player2>
      </player>
    <grid>
      {
      for {col <- 0 to controller.colCount - 1;
    row <- (0 to controller.rowCount - 1).reverse
    }
    yield {
      var player = controller.getGrid().cell(row, col).piece match {
        case Some(s) => s.player.playerNumber
        case None => -1
      }
      <cell row={ row.toString } col={ col.toString }>
        { player.toString }
      </cell>
    }
      }
    </grid>
    </game>
  }
  override def save(game: Controller): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("game.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(gameToXml(game))
    pw.write(xml)
    pw.close()
  }
}