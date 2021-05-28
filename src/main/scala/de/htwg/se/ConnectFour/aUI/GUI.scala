package de.htwg.se.ConnectFour.aUI;

import de.htwg.se.ConnectFour.util.UI
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

object GUI extends JFXApp with UI{

  override def processInput(input: String):Unit = {
  }

  stage = new JFXApp.PrimaryStage {
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

