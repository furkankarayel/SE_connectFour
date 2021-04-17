package de.htwg.se.ConnectFour.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GridSpec extends AnyWordSpec with Matchers {

  "A Grid" when {
    val settings = Settings()
    "rows and columns" should {
      val grid = Grid(settings)
      "have that length of row" in {
        grid.row(0).length should be(settings.dimensionColumn)
      }
      "have that length of column" in {
        grid.column(0).length should be(settings.dimensionRow)
      }
    }
  }
}