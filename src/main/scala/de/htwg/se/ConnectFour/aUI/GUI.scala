package de.htwg.se.ConnectFour.aUI;

import de.htwg.se.ConnectFour.aUI.states.GUI.GameState
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{Observer, UI}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.TextInputDialog
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout._
import scalafx.scene.paint.Color.{Black, DarkRed, LightYellow, Red, Yellow}
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text

case class GUI(controller:Controller) extends UI with Observer with JFXApp {

  var gameState:GameState = GameState(controller)
  controller.add(this)
  def run(): Unit = {
    main(Array())
  }

  def typeName():Unit = {
    val dialog = new TextInputDialog(defaultValue = "Detlef") {
    initOwner(stage)
    title = "ConnectFour Game"
    headerText = "Welcome to Connect Four!"
      var number = ""
      if(controller.players.size == 0) number = "one" else number = "two"
    contentText = "Player " + number + " please enter your name:"
  }

    val result = dialog.showAndWait()

    result match {
    case Some(name) => controller.addPlayer(name)
    case None       => println("Please type a name!")
  }
  }

  def begin():Unit = {
    do {
      val playerSize = controller.players.size
      playerSize match {
        case 0 => typeName()
        case 1 => typeName()
      }
    } while (controller.players.size<2)
    gameState.handle("")
  }

  def gameGrid: GridPane = new GridPane {
    style = "-fx-border-color: #353535; -fx-background-color #f0e68c -fx-border-width: 0 2 0 0"
    for (_ <- 0 until controller.colCount) {
      val row = new RowConstraints() {
        percentHeight = 100.0 / controller.rowCount
      }
      rowConstraints.add(row)
      val column = new ColumnConstraints() {
        percentWidth = 100.0 / controller.colCount
      }
      styleClass = List("gameGridRowColumn")
      columnConstraints.add(column)
    }
  }

  def logo:HBox = new HBox {
    style = "-fx-border-color: #353535; -fx-border-width: 0 2 0 0"
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
      },
    )
  }

  stage = new PrimaryStage {
    title.value = "ConnectFour Game"
    minWidth = 650
    minHeight = 800

    scene = new Scene {
      root = new BorderPane {
        style = "-fx-border-color: #353535; -fx-background-color #f0e68c -fx-border-width: 0 2 0 0"
        top = logo
        center = gameGrid
      }
      begin()
    }

  }

  override def processInput(input: String):Unit = {
    input match {
      case _ =>
    }
  }

  override def update: Boolean =  { println(controller.toString);true }

}
