package de.htwg.se.ConnectFour.model

import de.htwg.se.ConnectFour.model
import de.htwg.se.ConnectFour.model.fieldbase.gridbase.CellPieceBase
import de.htwg.se.ConnectFour.model.fieldbase.gridbase.CellPieceBase.Piece
import de.htwg.se.ConnectFour.model.playerbase.PlayerImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PieceSpec extends AnyWordSpec with Matchers {
  "A Piece" when {
    "new" should {
      val player1 = PlayerImpl("Your Name", 1)
      val player2 = PlayerImpl("Your Name", 2)
      val piece1 = Piece(player1)
      val piece2 = CellPieceBase.Piece(player2)
      "have a color" in {
        piece1.toString should be (Console.RED + "☻ ")
        piece2.toString should be (Console.YELLOW + "☻ ")
      }
    }
  }
}
