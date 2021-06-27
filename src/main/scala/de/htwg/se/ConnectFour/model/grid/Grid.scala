package de.htwg.se.ConnectFour.model.grid

import de.htwg.se.ConnectFour.model.grid.impl._

/**
 * Grid Trait
 */
trait Grid {
  val rows: Vector[Vector[Cell]]
  def cell(row: Int, col: Int): Cell
  def replaceCell(row: Int, col: Int, cell: Cell): Grid
  def drop(column: Int, piece: Piece): Grid
  def reset(): Grid
}
