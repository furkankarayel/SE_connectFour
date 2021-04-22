package de.htwg.se.ConnectFour.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SettingsSpec extends AnyWordSpec with Matchers {
  "A Setting" when {
    "not set to any value" should {
      val setting = Settings()
      "have value 6" in {
        setting.dimRow should be (6)
      }
      "have value 7" in {
        setting.dimCol should be (7)
      }
      "have player1 color red" in {
        setting.player1color should be ("red")
      }
      "have player2 color yellow" in {
        setting.player2color should be ("yellow")
      }
    }
    "set to a specific value" should {
      val setting = Settings(12,14)
      "have value 12" in {
        setting.dimRow should be (12)
      }
      "have value 14" in {
        setting.dimCol should be (14)
      }
      "have player1 color red" in {
        setting.player1color should be ("red")
      }
      "have player2 color yellow" in {
        setting.player2color should be ("yellow")
      }
    }

  }
}
