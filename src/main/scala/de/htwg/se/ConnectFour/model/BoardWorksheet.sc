import de.htwg.se.ConnectFour.model.Player

val player1 = new Player("Hansi", 2)
val player2 = new Player("Franzi", 1)

case class Piece(player: Player) {
  override def toString: String = player.playerNumber match {
    case 1 => "red"
    case 2 => "yellow"
  }
}

print(Piece(player1))
print(Piece(player2))

val columnfields = 7
val rowfields = 6
val grid = Array.ofDim[Piece](columnfields,rowfields)

def drop(col: Int, piece: Piece): Unit ={

  val idx = grid(5).lastIndexWhere(_ == None)
  grid.updated(5, grid(5).updated(idx, Some(Cell())));
  grid[5][idx] = Some(Cell())

}



