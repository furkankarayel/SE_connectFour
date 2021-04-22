package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CellSpec extends AnyWordSpec with Matchers {

  "A Cell" when {
    "not set to any value " should {
      val emptyCell = Cell("")
      "have no value" in {
        emptyCell.value should be("")
      }
      "not be set" in {
        emptyCell.isSet should be(false)
      }
    }
    "set to a specific value" should {
      val nonEmptyCell = Cell("5")
      "return that value" in {
        nonEmptyCell.value should be("5")
      }
      "be set" in {
        nonEmptyCell.isSet should be(true)
      }
    }
  }

}