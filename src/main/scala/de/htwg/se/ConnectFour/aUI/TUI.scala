package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{Observer, UI}


class TUI(controller: Controller) extends UI with Observer{

   override def processInput(input: String):Unit = {
    input match {
      case _ => controller.execute(input);
    }
  }



  def gamestart(): Unit = {

  }

  override def update: Option[Boolean] =  {
    try {
      println(controller.toString)
      Some(true)
    } catch {
      case e: Exception => None
    }
  }
}
