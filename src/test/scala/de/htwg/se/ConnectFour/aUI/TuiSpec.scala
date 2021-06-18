package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl
import de.htwg.se.ConnectFour.model.player.impl.PlayerBuilderImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec with Matchers{

  "A ConnectFour Tui" should {
    val controller = new ControllerImpl(new GridImpl(),PlayerBuilderImpl())
    val tui = new TUI(controller)

  }
}
