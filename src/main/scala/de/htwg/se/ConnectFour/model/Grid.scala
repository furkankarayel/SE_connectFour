package de.htwg.se.ConnectFour.model


case class Grid(rows: Vector[Vector[Cell]]) {
  def this() = this(Vector.tabulate(6, 7) { (row, col) => Cell(None) })
  override def cell(row: Int, col: Int): Cell = rows(row)(col)
  def replaceCell(row: Int, col: Int, cell: Cell): Grid = copy(rows.updated(row, rows(row).updated(col, cell)))

  def drop(column: Int, piece: Piece): Grid = {
    val idx = this.rows.indexWhere(row => !row(column).isSet)
    if (idx > -1) {
      this.replaceCell(idx, column, Cell(Some(piece)))
    } else {
      this
    }
  }
  def reset(): Grid = {
    new Grid
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

