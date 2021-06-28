package de.htwg.se.ConnectFour.aUI;
import de.htwg.se.ConnectFour.aUI.states.GUI.GameState
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{Observer, UI}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextInputDialog}
import scalafx.scene.effect.{Glow, InnerShadow}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout._
import scalafx.scene.paint.Color.{Black, DarkRed, LightYellow, Red, Yellow}
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text


/**
 * ConnectFour graphical user interface
 * based on ScalaFX
 */
case class GUI(controller: Controller) extends UI with Observer with JFXApp {
  controller.add(this)
  var gameState: GameState = GameState(controller, this)

  def run(): Unit = {
    main(Array())
  }

  def typeName(): Unit = {
    val dialog = new TextInputDialog(defaultValue = "Detlef") {
      initOwner(stage)
      title = "ConnectFour Game"
      headerText = "Welcome to Connect Four!"
      var number = ""
      if (controller.players.size == 0) number = "one" else number = "two"
      contentText = "Player " + number + " please enter your name:"
    }

    val result = dialog.showAndWait()
    result match {
      case Some(name) => controller.addPlayer(name)
      case None => println("Please type a name!")
    }
  }

  /**
   * Force to type in names
   * when method is running
   */
  def begin(): Unit = {
    do {
      val playerSize = controller.players.size
      playerSize match {
        case 0 => typeName()
        case 1 => typeName()
      }
    } while (controller.players.size < 2)
    execute("") // changing the state
  }

  /**
   * Method to create a gamefield button.
   * On mouse click the button passes
   * its y-value to the gameState
   */
  def gameFieldButton(y: Int): Button = {
    val gameFieldButton = new Button {
      style = "-fx-font: normal bold 16pt sans-serif;  -fx-border-color: lightgrey; -fx-text-fill: black; -fx-background-color: #e6f3ff;"
      onMouseClicked = _ => {
        gameState.handle(y.toString)
      }
    }
    gameFieldButton
  }

  val gameLogo: HBox = new HBox {
    style = "-fx-background-color: #b3daff;"
    padding = Insets(30, 100, 0, 100)
    children = Seq(
      new Text {
        text = "Connect "
        style = "-fx-font: normal bold 70pt sans-serif"
        fill = new LinearGradient(
          endX = 0,
          stops = Stops(Red, DarkRed))
        effect = new InnerShadow() {
          color = Black
          radius = 5
        }
      },
      new Text {
        text = "Four"
        style = "-fx-font: normal bold 70pt sans-serif"
        fill = new LinearGradient(
          endX = 0,
          stops = Stops(Yellow, LightYellow)
        )
        effect = new InnerShadow() {
          color = Black
          radius = 5
        }
      },
    )
  }

  /**
   * Initialising the game grid.
   */
  val gameGrid: GridPane = new GridPane {
    gridLinesVisible = false
    padding = Insets(70)
    var i = 0
    for (_ <- 0 until controller.colCount) {
      if (i < 6) {
        val row = new RowConstraints() {
          percentHeight = 100.0 / controller.rowCount
        }
        rowConstraints.add(row)
      }
      val column = new ColumnConstraints() {
        percentWidth = 100.0 / controller.colCount
      }
      columnConstraints.add(column)
      i += 1
    }
  }

  /**
   * Initialising the the bottom bar.
   */
  val bottombar: GridPane = new GridPane {
    padding = Insets(20)
    hgap = 10
    vgap = 10

    val rows: RowConstraints = new RowConstraints() {
      percentHeight = 50
      prefHeight = 60
    }

    rowConstraints.add(rows)
    rowConstraints.add(rows)

    for (_ <- 0 until 3) {
      val col = new ColumnConstraints() {
        percentWidth = 80
      }
      columnConstraints.add(col)
    }

    val save = new Button("Save") {
      padding = Insets(10)
      style = "-fx-font: normal bold 16pt sans-serif; -fx-text-fill: black; -fx-background-color: #4169E1; -fx-background-radius: 15px;"
      this.setMaxSize(Double.MaxValue, Double.MaxValue)
      onMouseClicked = _ => {
        controller.saveGame()
      }
      onMouseEntered = _ => effect = new Glow(0.7)
      onMouseExited = _ => effect = null
    }

    val load = new Button("Load") {
      padding = Insets(10)
      style = "-fx-font: normal bold 16pt sans-serif; -fx-text-fill: black; -fx-background-color: #4169E1; -fx-background-radius: 15px;"
      this.setMaxSize(Double.MaxValue, Double.MaxValue)
      onMouseClicked = _ => {
        controller.loadGame()
      }
      onMouseEntered = _ => effect = new Glow(0.7)
      onMouseExited = _ => effect = null
    }

    val undo = new Button("Undo") {
      padding = Insets(10)
      style = "-fx-font: normal bold 16pt sans-serif; -fx-text-fill: black; -fx-background-color: #00BFFF; -fx-background-radius: 15px;"
      this.setMaxSize(Double.MaxValue, Double.MaxValue)
      onMouseClicked = _ => {
        execute("u")
      }
      onMouseEntered = _ => effect = new Glow(0.7)
      onMouseExited = _ => effect = null
    }

    val redo = new Button("Redo") {
      padding = Insets(10)
      style = "-fx-font: normal bold 16pt sans-serif; -fx-text-fill: black; -fx-background-color: #00BFFF; -fx-background-radius: 15px;"
      this.setMaxSize(Double.MaxValue, Double.MaxValue)
      onMouseClicked = _ => {
        execute("r")
      }
      onMouseEntered = _ => effect = new Glow(0.7)
      onMouseExited = _ => effect = null
    }

    val newGame = new Button("New Game") {
      padding = Insets(10)
      style = "-fx-font: normal bold 16pt sans-serif; -fx-text-fill: black; -fx-background-color: #4682B4; -fx-background-radius: 15px;"
      this.setMaxSize(Double.MaxValue, Double.MaxValue)
      onMouseClicked = _ => {
        execute("n")
      }
      onMouseEntered = _ => effect = new Glow(0.7)
      onMouseExited = _ => effect = null
    }
    add(undo, 0, 0)
    add(redo, 0, 1)
    add(newGame, 1, 0)
    add(save, 2, 0)
    add(load, 2, 1)
  }

  stage = new PrimaryStage {
    title.value = "ConnectFour Game"
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

  /**
   * This method needs to be run
   * to show the latest drops.
   */
  def refreshView(): Unit = {
    try {
      for (x <- 0 to controller.colCount -1; y <- (0 to controller.rowCount - 1).reverse) {
        /**
         * Reversing the y values so the dropped pieces
         * are landing at the bottom
         **/
        var reverseY = y match {
          case 0 => 5
          case 1 => 4
          case 2 => 3
          case 3 => 2
          case 4 => 1
          case 5 => 0
        }
        val piece: Button = gameFieldButton(x)
        if (controller.getGrid().cell(y, x).isSet) {
          val img = controller.getGrid().cell(y, x).piece.get.player.playerNumber match {
            case 1 => new Image("/red.png")
            case 2 => new Image("/yellow.png")
          }
          val imgView = new ImageView(img)
          imgView.setFitHeight(35)
          imgView.setFitWidth(35)
          imgView.setPreserveRatio(true)
          piece.setGraphic(imgView)
          piece.setMaxSize(Double.MaxValue, Double.MaxValue)
        }
        piece.setMaxSize(Double.MaxValue, Double.MaxValue)
        gameGrid.add(piece, x, reverseY)
      }
    } catch {
      case any => print(any)
    }
  }

  override def processInput(input: String):Unit = {
    input match {
      case _ => execute(input);
    }
  }

  def execute(input:String): Unit = {
    gameState.handle(input)
  }

  override def update: Boolean = {
    refreshView()
    true
  }
}