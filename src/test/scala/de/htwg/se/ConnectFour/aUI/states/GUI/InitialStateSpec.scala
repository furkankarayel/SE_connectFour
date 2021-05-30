package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.states.GUI
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class InitialStateSpec extends AnyWordSpec with Matchers{
  "An initial state" when {
    val controller = new Controller(new Grid)
    val initialState = GUI.GameState(controller)
    controller.addPlayer("Franz")
    controller.addPlayer("Jens")
    "initialised" should {
      "process drop when two players exist and input isn't q" in {
        initialState.handle("2")
      }

    }
  }

}
