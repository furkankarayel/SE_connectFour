package de.htwg.se.ConnectFour

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameSpec extends AnyWordSpec with Matchers{

  "The Connect Four main class" should {
    "accept text input as argument without readline loop, to test it from command line" in {
      Game.main(Array[String]("t"))
    }
  }

}
