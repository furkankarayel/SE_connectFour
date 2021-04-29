package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec with Matchers{

  "A ConnectFour Tui" should {
    val controller = new Controller(new Grid())
    val tui = new TUI(controller)
    "create an empty ConnectFour grid on start" in {
      controller.grid should be (new Grid())
    }
    /*"print the empty grid on input 'p'" in {
      tui.processInputLine("p")
      controller.grid.toString should be ("_______\n_______\n_______\n_______\n_______\n_______")
    }*/
    "should replace a specific cell by typing a number 0-6" in {
      tui.processInputLine("0")
      controller.grid.cell(0,0).isSet should be (true)
    }
  }

}
