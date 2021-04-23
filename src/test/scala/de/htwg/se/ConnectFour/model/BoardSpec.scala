package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class BoardSpec extends AnyWordSpec with Matchers {
  "A Board" when {
    "new" should {
      val board = Board()
      "have a grid" in {
        board.grid should be
      }
    }
  }
}
