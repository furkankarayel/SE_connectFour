package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your Name", "Your Color")
      "have a name" in {
        player.name should be ("Your Name")
      }
      "have a color" in {
        player.color should be ("Your Color")
      }
      "have a nice String representation" in {
        player.toString should be
        "Der Spieler " + player.name + " hat die Farbe "+ player.name
      }
    }
  }
}