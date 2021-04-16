package de.htwg.se.ConnectFour.model

case class Grid() {
  def this(size: Int) = this(new Array.ofDim[Cell](size, Cell("")))

  val size: Int = t.size

  def cell(row: Int, col: Int): Cell = cells.cell(row, col)

  def set(row: Int, col: Int, value: String): Grid = copy(cells.replaceCell(row, col, Cell(value)))

}

