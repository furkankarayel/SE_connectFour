package de.htwg.se.ConnectFour

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.io.StringReader

class GameSpec extends AnyWordSpec with Matchers{

  "The Connect Four main class" should {
    "accept text input as argument without readline loop, to test it from command line" in {
      Game.main(Array[String]("t"))
    }
    "not run into the readline loop if the argument length is higher than 0" in {
      Game.main(Array[String]("p"))
    }
    "exit the loop after entering with 'q'" in {
      val in = new StringReader("q")
      Console.withIn(in) {
        Game.main(Array[String]())
      }

    }
  }

}
