package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.model.{Grid, Piece, Player}
import de.htwg.se.ConnectFour.util.{Observable, UndoManager}

class Controller(var grid:Grid, val p1:Player,val p2:Player) extends Observable {

  private val undoManager = new UndoManager
  def createGrid(): Unit = {
    reset()
    notifyObservers
  }

  def whoseTurnIsIt(): Unit = {
    Game.player = if (Game.move % 2 == 0) Game.player1 else Game.player2
    notifyObservers
  }

  def doStep(input:String): Unit = {
    whoseTurnIsIt()
    input.toList.filter(c => c != " ").map(c => c.toString.toInt) match {
      case col :: Nil =>
        undoManager.doStep(new SetCommand(col,Piece(Game.player),this))
        Game.move += 1
        print(gridPrint)
    }
    notifyObservers
  }

  def undoStep(): Unit = {
    undoManager.undoStep
    Game.move -= 1
    print (gridPrint)
    notifyObservers
  }

  def redoStep(): Unit = {
    undoManager.redoStep
    Game.move += 1
    print(gridPrint)
    notifyObservers
  }

  def reset(): Unit = {
    grid = new Grid
    notifyObservers
  }
  def dropPiece(col: Int,piece: Piece): Unit = {
    grid = grid.drop(col,piece)
    notifyObservers
  }
  def gridPrint(): String = grid.toString

}

