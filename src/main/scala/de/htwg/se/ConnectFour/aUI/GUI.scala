package de.htwg.se.ConnectFour.aUI;

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.UI
import scalafx.application.JFXApp

class GUI(controller: Controller) extends JFXApp with UI{

  override def processInput(input: String):Unit = {
    input match {
      case _ => controller.execute(input);
    }
  }
}

