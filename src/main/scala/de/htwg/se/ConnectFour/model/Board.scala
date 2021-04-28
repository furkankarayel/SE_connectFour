package de.htwg.se.ConnectFour.model

case class Board() {

  var grid = new Grid()

  def drop(col: Int, piece: Piece): Grid = {
    val idx = grid.rows.indexWhere(row => !row(col).isSet)
    if(idx > -1) {
      grid.replaceCell(idx, col, Cell(Some(piece)))
    } else {
      grid
    }
  }

  def reset(): Grid = {
    new Grid
  }

  override def toString: String = {
    val builder = new StringBuilder
    for (row <- grid.rows.reverse) {
      for (col <- row) {
        builder.append(col)
      }
      builder.append("\n")
    }
    builder.toString()
  }

  def wincheck(): Boolean = {
    def iswon: Boolean = false
    val verticalFour = 0;
    val horizontalFour = 0;
    val diagonalFour = 0;
    do {
      if(grid.rows)

    } while (iswon = false)
  }

}
