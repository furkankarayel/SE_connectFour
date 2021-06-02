package de.htwg.se.ConnectFour.aUI;

import de.htwg.se.ConnectFour.aUI.states.GUI.GameState
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{Observer, UI}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color.{Black, DarkRed, LightYellow, Red, Yellow}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

case class GUI(controller:Controller) extends UI with Observer with JFXApp {

  var gameState:GameState = GameState(controller)

  def run(): Unit = {
    main(Array())
  }
  stage = new PrimaryStage {
    title.value = "ConnectFour Game"
    scene = new Scene {
      fill = Color.rgb(120, 120, 68)
      content = new HBox {
        padding = Insets(5, 10, 5, 10)
        children = Seq(
          new Text {
            text = "Connect"
            style = "-fx-font: normal bold 50pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Red, DarkRed))
            effect = new DropShadow {
              color = Black
              radius = 5
              spread = 0.3
            }
          },
          new Text {
            text = "Four"
            style = "-fx-font: normal bold 50pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Yellow, LightYellow)
            )
            effect = new DropShadow {
              color = Black
              radius = 5
              spread = 0.3
            }
          }
        )
      }
    }
  }

  override def processInput(input: String):Unit = {
    input match {
      case _ =>
    }
  }

  override def update: Boolean =  { println(controller.toString);true }

}
