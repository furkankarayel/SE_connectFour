package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player1 = Player("Your Name", 1)
      val player2 = Player("Yo Name", 2)
      "have a name" in {
        player1.pname should be ("Your Name")
        player2.pname should be ("Yo Name")
      }
      "have a number" in{
        player1.pnumber should be (1)
        player2.pnumber should be (2)
      }
      "have a color" in {
        player1.pcolor should be ("red")
        player2.pcolor should be ("yellow")
      }
      "have a nice String representation" in {
        player1.toString should be
        "Der Spieler " + player1.pname + " mit der Nummer "+
          player1.pnumber +" hat die Farbe "+ player1.pcolor
        player2.toString should be
        "Der Spieler " + player2.pname + " mit der Nummer "+
          player2.pnumber +" hat die Farbe "+ player2.pcolor
      }
    }
  }
}