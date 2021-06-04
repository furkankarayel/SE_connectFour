package de.htwg.se.ConnectFour.aUI.states

import de.htwg.se.ConnectFour.aUI.{GUI, TUI}
import de.htwg.se.ConnectFour.aUI.states.GUI.GameState
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{BorderPane, HBox}
import scalafx.scene.paint.Color.{DarkGray, DarkRed, Red, White}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

import scala.reflect.internal.util.NoSourceFile.content

object guiSpec extends AnyWordSpec with Matchers {
  "A connect four gui" should {
    val controller = new Controller(new Grid())
    val gui = new GUI(controller)
    "presented" when {

    }
  }

  stage = new PrimaryStage {
    minWidth = 650
    minHeight = 900
    resizable = true
    scene = new Scene {
      root = new BorderPane {
        style = "-fx-border-color: #353535; -fx-background-color: #b3daff;"
        top = gameLogo
        center = gameGrid
        bottom = bottombar
      }
      begin()
    }
  }

  fill = Color.rgb(38, 38, 38)
  content = new HBox {
    padding = Insets(50, 80, 50, 80)
    children = Seq(
      new Text {
        text = "Connect"
        style = "-fx-font: normal bold 100pt sans-serif"
        fill = new LinearGradient(
          endX = 0,
          stops = Stops(Red, DarkRed))
      },
      new Text {
        text = "Four"
        style = "-fx-font: italic bold 100pt sans-serif"
        fill = new LinearGradient(
          endX = 0,
          stops = Stops(White, DarkGray)
        )
        effect = new DropShadow {
          color = DarkGray
          radius = 15
          spread = 0.25
        }
      }
    )
  }
}
