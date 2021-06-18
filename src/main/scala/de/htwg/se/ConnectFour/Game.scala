package de.htwg.se.ConnectFour

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl

import java.lang.ModuleLayer.Controller
import scala.util.{Failure, Success, Try}

object Game {
  def main(args: Array[String]): Unit = {
    val injector: Injector = Guice.createInjector(new GameModule())
    injector.getInstance(classOf[Controller])
    val uiType = "GUI"

    Try(UIFactory(uiType,Controller: ControllerImpl)) match {
      case Success(v) => println("Bye.")
      case Failure(v) => println("Could not create UI" + v.getMessage + v.getCause)
    }
  }
}