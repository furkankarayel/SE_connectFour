package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{UI,Observer}
import io.AnsiColor._


class TUI(controller: Controller) extends UI with Observer{

  override def processInput(input: String):Unit = {
    input match {
      case _ => controller.execute(input);
    }
  }

  def gamestart(): Unit = {

  }
  override def update: Boolean =  { println(controller.toString);true }
}
