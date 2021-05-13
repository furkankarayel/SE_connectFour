package de.htwg.se.ConnectFour.model

abstract class GridTemplate {
  def drop(column: Int, piece: Piece): Grid
  def cell(row: Int, col: Int): Cell
  def reset(): Grid
  def toString(): String
}