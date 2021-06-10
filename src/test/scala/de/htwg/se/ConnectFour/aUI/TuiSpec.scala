package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fieldbase.GridImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec with Matchers{

  "A ConnectFour Tui" should {
    val controller = new Controller(new GridImpl())
    val tui = new TUI(controller)

  }
}
