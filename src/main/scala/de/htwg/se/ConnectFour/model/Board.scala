package de.htwg.se.ConnectFour.model

case class Board() {

  var grid = new Grid()
// grid return
  def drop(col: Int, piece: Piece): Unit = {
    val idx = grid.rows.indexWhere(row => !row(col).isSet)
    if(idx > -1) {
      grid = grid.replaceCell(idx, col, Cell(Some(piece)))
    }
  }
//will be replaced by toString
  def printGrid(): Unit = {
    for (row <- grid.rows.reverse) {
      for (col <- row) {
        print(col)
      }
      println("\n")
    }
  }
// grid reset return grid type
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

}
