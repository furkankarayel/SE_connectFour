import de.htwg.se.ConnectFour.model._

val player1 = Player("Hansi", 2)
val player2 = Player("Franzi", 1)


print(Piece(player1))
print(Piece(player2))

val grid = Grid
val board = Board()
val piecep1 = Piece(player1)
val piecep2 = Piece(player2)

board.grid = board.grid.replaceCell(0,2, Cell(Some(piecep1)))
board.grid = board.grid.replaceCell(0,0, Cell(Some(piecep2)))
board.printGrid()

board.drop(2,piecep2)
board.printGrid()







