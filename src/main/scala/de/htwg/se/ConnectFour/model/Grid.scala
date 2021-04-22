package de.htwg.se.ConnectFour.model


case class Grid(rows: Vector[Vector[Cell]]) {
  def this() = this(Vector.tabulate(5, 6) { (row, col) => Cell(None) })
  def cell(row: Int, col: Int): Cell = rows(row)(col)
  def replaceCell(row: Int, col: Int, cell: Cell): Grid = copy(rows.updated(row, rows(row).updated(col, cell)))
}

