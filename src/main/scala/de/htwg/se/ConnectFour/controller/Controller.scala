package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.player.Player
import de.htwg.se.ConnectFour.util.{Observable, UndoManager}

/**
 * Controller Trait
 */
trait Controller extends Observable{
  var players: Vector[Player]
  var moveCount:Int
  var currentPlayer:Player
  val maxPlayers:Int
  val colCount:Int
  val rowCount:Int
  val undoManager:UndoManager

  def createGrid(): Unit
  def addPlayer(name:String):Unit
  def whoseTurnIsIt(): Unit
  def checkWin():Boolean
  def winPatternHorizontal():Option[Boolean]
  def winPatternVertical():Option[Boolean]
  def winPatternAscendingDiagonal():Option[Boolean]
  def winPatternDescendingDiagonal():Option[Boolean]
  def drop(input:String): Unit
  def undoDrop(): Unit
  def redoDrop(): Unit
  def saveGame(): Unit
  def loadGame(): Unit
  def reset(): Unit
  def gridPrint(): String

  def getGrid(): Grid
  def getPlayers(): Vector[Player]
  def getCurrentPlayer(): Player
  def getMoveCount: Int
  def setGrid(grid:Grid): Unit
  def setPlayers(players:Vector[Player]): Unit
  def setCurrentPlayer(currentPlayer:Player): Unit
  def setMoveCount(moveCount:Int): Unit
}
