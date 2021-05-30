package de.htwg.se.ConnectFour.aUI;

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.UI

class GUI(controller:Controller) extends UI {
  val guiCore = new GUICore(controller)

  override def processInput(input: String):Unit = {
  }

}
