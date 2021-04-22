package de.htwg.se.ConnectFour.model

case class Board() {

  var grid = new Grid()

  def drop(col: Int, piece: Piece): Unit ={
    /*
    val idx = grid(5).lastIndexWhere(_ == None)
    grid.updated(5, grid(5).updated(idx, Some(Cell())));
    grid[5][idx] = Some(Cell())
     */
  }

  def printGrid(): Unit = {
    for (row <- grid.rows.reverse) {
      for (col <- row) {
        print(col)
      }
      println("\n")
    }
  }

  def reset(): Unit = {
    grid = new Grid
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
