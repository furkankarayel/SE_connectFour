package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl

import scala.util.{Failure, Success, Try}

object Game {
  def main(args: Array[String]): Unit = {
    val grid = new GridImpl()
    val controller = new ControllerImpl(grid)
    val uiType = "GUI"

    Try(UIFactory(uiType,controller)) match {
      case Success(v) => println("Bye.")
      case Failure(v) => println("Could not create UI" + v.getMessage + v.getCause)
    }
  }
}