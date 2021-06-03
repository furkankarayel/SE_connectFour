package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.aUI.{GUI, TUI, UIFactory}
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.model._
import scala.util.{Failure, Success, Try}

object Game {
  def main(args: Array[String]): Unit = {
    val controller = new Controller(new Grid())
    val uiType = "GUI"

    Try(UIFactory(uiType,controller)) match {
      case Success(v) => print("Bye.")
      case Failure(v) => print("Could not create UI" + v.getMessage + v.getCause)
    }
  }
}