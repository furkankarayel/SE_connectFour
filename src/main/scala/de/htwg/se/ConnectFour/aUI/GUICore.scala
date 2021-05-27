package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.util.Observer
import de.htwg.se.ConnectFour.controller.Controller

class GUICore(guiMain:GUI,controller:Controller) extends Observer{
  override def update: Option[Boolean] =  {
    try {
      println(controller.toString)
      Some(true)
    } catch {
      case e: Exception => None
    }
  }
}

