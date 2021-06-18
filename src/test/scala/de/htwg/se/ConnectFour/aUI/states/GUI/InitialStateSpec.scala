package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.aUI.states.GUI
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl
import de.htwg.se.ConnectFour.model.player.impl.PlayerBuilderImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class InitialStateSpec extends AnyWordSpec with Matchers{
  "An initial state" when {
    val controller = new ControllerImpl(new GridImpl)
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
