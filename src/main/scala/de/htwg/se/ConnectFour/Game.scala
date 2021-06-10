package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.model.fieldbase.Grid
import de.htwg.se.ConnectFour.model.fieldbase.gridbase.GridImpl

import scala.util.{Failure, Success, Try}

object Game {
  def main(args: Array[String]): Unit = {
    val grid = new GridImpl()
    val controller = new Controller(grid)
    val uiType = "GUI"

    Try(UIFactory(uiType,controller)) match {
      case Success(v) => println("Bye.")
      case Failure(v) => println("Could not create UI" + v.getMessage + v.getCause)
    }
  }
}