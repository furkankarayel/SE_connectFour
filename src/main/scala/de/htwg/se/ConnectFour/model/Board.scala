package de.htwg.se.ConnectFour.model

case class Board(/*private val cells:Matrix[Cell]*/) {
  val columnfields = 7
  val rowfields = 6
  val grid = Array.ofDim[Piece](columnfields,rowfields)


  def drop(col: Int, piece: Piece): Unit ={
    /*
    val idx = grid(5).lastIndexWhere(_ == None)
    grid.updated(5, grid(5).updated(idx, Some(Cell())));
    grid[5][idx] = Some(Cell())
     */
  }

}
