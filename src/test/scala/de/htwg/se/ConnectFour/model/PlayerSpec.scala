package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your Name", 1)
      "have a name" in {
        player.name should be ("Your Name")
      }
      "have a number" in{
        player.number should be (1)
      }
      "have a color" in {
        player.color should be ("red")
      }
      "have a nice String representation" in {
        player.toString should be
        "Der Spieler " + player.name + " mit der Nummer "+
          player.number +" hat die Farbe "+ player.color
      }
    }
  }
}