package de.htwg.se.ConnectFour.model.grid.impl

import com.google.inject.Inject
import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.{CannotDropPiece, ColumnFull}

import scala.util.{Failure, Success, Try}

/**
 * Game grid implementation
 */
case class GridImpl(rows: Vector[Vector[Cell]]) extends Grid {

  @Inject()
  def this() = this(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })

  override def cell(row: Int, col: Int): Cell = rows(row)(col)

  override def replaceCell(row: Int, col: Int, cell: Cell): Grid = copy(rows.updated(row, rows(row).updated(col, cell)))

  override def drop(column: Int, piece: Piece): Grid = {
    val idx = this.rows.indexWhere(row => !row(column).isSet)
    if (idx > -1)
      return this.replaceCell(idx, column, Cell(Some(piece)))
    this
  }

  override def reset(): Grid = {
    new GridImpl()
  }

  override def toString: String = {
    var empty = true
    for (row <- this.rows)
      for (col <- row)
        if (col.isSet)
          empty = false

    if (!empty) {
      val builder = new StringBuilder
      for (row <- this.rows.reverse) {
        for (col <- row) {
          builder.append(col)
        }
        builder.append("\n")
      }
      return builder.toString()
    }
    ""
  }
}
