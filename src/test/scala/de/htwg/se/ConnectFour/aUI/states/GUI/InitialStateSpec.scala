package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.aUI.states.GUI
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class InitialStateSpec extends AnyWordSpec with Matchers{
  "An initial state" when {
    val controller = new Controller(new Grid)
    val gui = new GUI(controller)
    val initialState = GameState(controller,gui)
    controller.addPlayer("Franz")
    controller.addPlayer("Jens")
    "initialised" should {
      "process drop when two players exist and input isn't q" in {
        initialState.handle("2")
      }

    }
  }

}
