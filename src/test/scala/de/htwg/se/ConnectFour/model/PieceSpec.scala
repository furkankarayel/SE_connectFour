package de.htwg.se.ConnectFour.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PieceSpec extends AnyWordSpec with Matchers {
  "A Piece" when {
    "new" should {
      val player = Player("Your Name", 1)
      val piece = Piece(player)
      "have a color" in {
        piece.toString should be ("R")
      }
    }
  }
}
