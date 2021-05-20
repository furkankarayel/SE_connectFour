package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.model.{Grid, Piece, Player}
import de.htwg.se.ConnectFour.util.{Observable, UndoManager}

class Controller(var grid:Grid) extends Observable {
  var players: Vector[Player] = Vector.empty
  var move = 0
  var currentPlayer:Player = _
  val maxPlayers = 2
  val colCount = 7
  val rowCount = 6
  var gameState:GameState = GameState(this)

  private val undoManager = new UndoManager
  def createGrid(): Unit = {
    reset()
    notifyObservers
  }

  def execute(input:String): Unit = {
    gameState.handle(input)
  }

  def addPlayer(name:String):Unit = {
    if (players.size == 0) {
      players = players.appended(Player(name,1))
      println("Player 1 is called :" + name)
    }
    else {
      players = players.appended(Player(name,2))
      println("Player 2 is called :" + name)
    }
  }

  def whoseTurnIsIt(): Unit = {
    currentPlayer = if (move % 2 == 0) players(0) else players(1)
    notifyObservers
  }

  def checkWin():Boolean = {
    if(winPatternHorizontal() | winPatternVertical() | winPatternAscendingDiagonal() | winPatternDescendingDiagonal())
      true
    else
      false
  }

  def winPatternHorizontal():Boolean = {
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 0 to colCount-4){
      for (j <- 0 to rowCount){
        if (grid.cell(i,j).piece == currentPiece && grid.cell(i,j+1).piece == currentPiece && grid.cell(i,j+2).piece == currentPiece && grid.cell(i,j+3).piece == currentPiece)
          return true
      }
    }
    false
  }

  def winPatternVertical():Boolean = {
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 0 to colCount-4){
      for (j <- 0 to rowCount-1){
        if (grid.cell(i,j).piece == currentPiece && grid.cell(i+1,j).piece == currentPiece && grid.cell(i+2,j).piece == currentPiece && grid.cell(i+3,j).piece == currentPiece)
          return true
      }
    }
    false
  }
  def winPatternAscendingDiagonal():Boolean = {
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 3 to colCount-1){
      for (j <- 3 to rowCount-4){
        if (grid.cell(i,j).piece == currentPiece && grid.cell(i-1,j+1).piece == currentPiece && grid.cell(i-2,j+2).piece == currentPiece && grid.cell(i-3,j+3).piece == currentPiece)
          return true
      }
    }
    false
  }
  def winPatternDescendingDiagonal():Boolean = {
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 3 to colCount-1){
      for (j <- 3 to rowCount-4){
        if (grid.cell(i,j).piece == currentPiece && grid.cell(i-1,j-1).piece == currentPiece && grid.cell(i-2,j-2).piece == currentPiece && grid.cell(i-3,j-3).piece == currentPiece)
          return true
      }
    }
    false
  }

  def drop(input:String): Unit = {
    whoseTurnIsIt()
    input.toList.filter(c => c != " ").map(c => c.toString.toInt) match {
      case col :: Nil =>
        undoManager.doStep(new SetCommand(col,Piece(currentPlayer),this))
        move += 1
        print(gridPrint)
    }
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
    grid = new Grid
    notifyObservers
  }
  def gridPrint(): String = grid.toString

}

