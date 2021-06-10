package de.htwg.se.ConnectFour.model.gridbase

import de.htwg.se.ConnectFour.model.fieldbase.gridbase.cellpiecebase.Cell
import de.htwg.se.ConnectFour.model.gridbase.cellpiecebase.{Cell, Piece}

trait Grid {
  def cell(row: Int, col: Int): Cell

  def replaceCell(row: Int, col: Int, cell: Cell): Grid

  def drop(column: Int, piece: Piece): Grid

  def reset(): Grid
}
