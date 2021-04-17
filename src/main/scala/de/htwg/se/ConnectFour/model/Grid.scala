package de.htwg.se.ConnectFour.model

import scala.runtime.Nothing$


case class Grid(settings: Settings) {
  //private val settings = Settings()
  //val grid = (Array.ofDim[Cell](settings.dimensionRow, settings.dimensionColumn))
  val grid = Vector.fill[Option[Cell]](settings.dimensionRow, settings.dimensionColumn)(None)
  def row(index: Int) = grid(index)
  def column(index: Int) = grid.map(row => row(index))
  //def cell(row: InCt, col: Int): Cell = cells.cell(row, col)

  //def set(row: Int, col: Int, value: String): Grid = copy(cells.replaceCell(row, col, Cell(value)))

}

