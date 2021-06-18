package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.aUI._
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl


object UIFactory {
  def apply(uiType:String, controller:ControllerImpl): Unit = {
    uiType match {
      case "gui" | "GUI" | "Gui" => GUI(controller).run()
      case "tui" | "TUI" | "Tui" => TUI(controller).run()
    }
  }
}
