package de.htwg.se.ConnectFour.model.fieldbase

import de.htwg.se.ConnectFour.model.Piece
import de.htwg.se.ConnectFour.model.fieldbase.gridbase.CellPieceBase.{Cell, Piece}

trait Grid {
  def cell(row: Int, col: Int): Cell

  def replaceCell(row: Int, col: Int, cell: Cell): Grid

  def drop(column: Int, piece: Piece): Grid

  def reset(): Grid
}
