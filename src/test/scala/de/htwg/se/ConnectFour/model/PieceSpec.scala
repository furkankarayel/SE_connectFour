package de.htwg.se.ConnectFour.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PieceSpec extends AnyWordSpec with Matchers {
  "A Piece" when {
    "new" should {
      val player1 = Player("Your Name", 1)
      val player2 = Player("Your Name", 2)
      val piece1 = Piece(player1.pnumber)
      val piece2 = Piece(player2.pnumber)
      "have a color" in {
        piece1.toString should be (Console.RED + "☻ ")
        piece2.toString should be (Console.YELLOW + "☻ ")
      }
    }
  }
}
