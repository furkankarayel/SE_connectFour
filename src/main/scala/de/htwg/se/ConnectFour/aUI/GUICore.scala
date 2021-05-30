package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.util.Observer
import de.htwg.se.ConnectFour.controller.Controller
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color.LightGreen
import scalafx.scene.shape.Rectangle

object GUICore extends JFXApp {
  def apply() = this.main(Array())
  stage = new PrimaryStage {
    title.value = "Hello Stage"
    width = 600
    height = 450
    scene = new Scene {
      fill = LightGreen
      content = new Rectangle {
        x = 25
        y = 40
        width = 100
        height = 100
      }
    }
  }
}

class GUICore(controller:Controller) extends Observer {
  val obj = GUICore()

  override def update: Boolean =  { println(controller.toString);true }
}

