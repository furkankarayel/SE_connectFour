package de.htwg.se.ConnectFour.controller.impl

import com.google.inject.{Guice, Inject}
import de.htwg.se.ConnectFour.GameModule
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.grid.impl.Piece
import de.htwg.se.ConnectFour.model.player.Player
import de.htwg.se.ConnectFour.model.player.impl.PlayerBuilderImpl
import de.htwg.se.ConnectFour.model.{InputExpected, InvalidColumnNumber}
import de.htwg.se.ConnectFour.util.UndoManager

import scala.util.Failure

class ControllerImpl @Inject () (var grid:Grid, val playerBuilder:PlayerBuilder) extends Controller{
  var players: Vector[Player] = Vector.empty
  var move = 0
  var currentPlayer:Player = _
  val maxPlayers = 2
  val colCount = 7
  val rowCount = 6
  override val undoManager: UndoManager = new UndoManager
  val injector: Any = Guice.createInjector(new GameModule)

  def createGrid(): Unit = {
    reset()
    notifyObservers
  }

  def addPlayer(name:String):Unit = {
    val playerBuilder = PlayerBuilderImpl()
    if (players.size == 0) {
      val player = playerBuilder.setPlayer(name,1).build()
      players = players.appended(player)
      println("Player 1 is called: " + name)
    }
    else {
      val player = playerBuilder.setPlayer(name,2).build()
      players = players.appended(player)
      println("Player 2 is called: " + name)
    }
  }

  def whoseTurnIsIt(): Unit = {
    currentPlayer = if (move % 2 == 0) players(0) else players(1)
    notifyObservers
  }

  def checkWin():Boolean = {
    val checkList:List[Option[Boolean]] = List(winPatternHorizontal(),winPatternVertical(),winPatternAscendingDiagonal(),winPatternDescendingDiagonal())
    val win = checkList.filterNot(f => f.isEmpty).contains((Some(true)))
    if (win)
      return true
    false
  }

  def winPatternHorizontal():Option[Boolean] = {
    try {
      val currentPiece = Some(Piece(currentPlayer))
      for (i <- 0 to rowCount - 1) {
        for (j <- 0 to colCount - 1) {
          if (grid.cell(i, j).piece == currentPiece && grid.cell(i, j + 1).piece == currentPiece && grid.cell(i, j + 2).piece == currentPiece && grid.cell(i, j + 3).piece == currentPiece)
            return Some(true)
        }
      }
      None
    } catch {
      case e: Exception => None
    }
  }


  def winPatternVertical():Option[Boolean] = {
    try {
      val currentPiece = Some(Piece(currentPlayer : Player))
      for (i <- 0 to rowCount - 3) {
        for (j <- 0 to colCount - 1) {
          if (grid.cell(i, j).piece == currentPiece && grid.cell(i + 1, j).piece == currentPiece && grid.cell(i + 2, j).piece == currentPiece && grid.cell(i + 3, j).piece == currentPiece)
            return Some(true)
        }
      }
      None
    } catch {
      case e: Exception => None
    }
  }
  def winPatternAscendingDiagonal():Option[Boolean] = {
    try {
      val currentPiece = Some(Piece(currentPlayer))
      for (i <- 0 to rowCount-4){
        for (j <- 0 to colCount-4){
          if (grid.cell(i,j).piece == currentPiece && grid.cell(i+1,j+1).piece == currentPiece && grid.cell(i+2,j+2).piece == currentPiece && grid.cell(i+3,j+3).piece == currentPiece)
            return Some(true)
        }
      }
      None
    } catch {
      case e: Exception => None
    }
  }
  def winPatternDescendingDiagonal():Option[Boolean] = {
    try {
      val currentPiece = Some(Piece(currentPlayer))
      for (i <- 3 to rowCount - 1) {
        for (j <- 0 to colCount - 4) {
          if (grid.cell(i, j).piece == currentPiece && grid.cell(i - 1, j + 1).piece == currentPiece && grid.cell(i - 2, j + 2).piece == currentPiece && grid.cell(i - 3, j + 3).piece == currentPiece)
            return Some(true)
        }
      }
      None
    } catch {
      case e: Exception => None
    }
  }

  def drop(input:Option[String]): Unit = {
    whoseTurnIsIt()
    var validCol = 0
    input match {
      case Some(col) => if (col.toInt <= 6) validCol = col.toInt else Failure(new InvalidColumnNumber)
      case None => Failure(new InputExpected)
    }

    undoManager.doStep(new SetCommandImpl(validCol,Piece(currentPlayer),this));
    move += 1
    print(this.gridPrint)
    notifyObservers
  }
  def undoDrop(): Unit = {
    undoManager.undoStep
    move -= 1
    print (gridPrint)
    notifyObservers
  }

  def redoDrop(): Unit = {
    undoManager.redoStep
    move += 1
    print(gridPrint)
    notifyObservers
  }

  def reset(): Unit = {
    grid = grid.reset()
    notifyObservers
  }

  def gridPrint(): String = grid.toString

}

