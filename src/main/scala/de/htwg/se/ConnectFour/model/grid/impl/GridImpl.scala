package de.htwg.se.ConnectFour.model.grid.impl

import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.{CannotDropPiece, ColumnFull}

import scala.util.{Failure, Success, Try}

case class GridImpl(rows: Vector[Vector[Cell]]) extends Grid {

  def this() = this(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })

  override def cell(row: Int, col: Int): Cell = rows(row)(col)

  override def replaceCell(row: Int, col: Int, cell: Cell): Grid = copy(rows.updated(row, rows(row).updated(col, cell)))

  override def drop(column: Int, piece: Piece): Grid = {
    var idx = 0
    Try(this.rows.indexWhere(row => !row(column).isSet)) match {
      case Success(result) => idx = result
      case Failure(_) => Failure(exception = new Exception)
    }

    if (idx > -1) {
      Try(this.replaceCell(idx, column, Cell(Some(piece)))) match {
        case Success(grid) => this.replaceCell(idx, column, Cell(Some(piece)))
        case Failure(_) => Failure(new CannotDropPiece); this
      }
    } else {
      Failure(new ColumnFull)
      this
    }
  }

  override def reset(): Grid = {
    new GridImpl()
  }

  override def toString: String = {
    val builder = new StringBuilder
    for (row <- this.rows.reverse) {
      for (col <- row) {
        builder.append(col)
      }
      builder.append("\n")
    }
    builder.toString()
  }
}
