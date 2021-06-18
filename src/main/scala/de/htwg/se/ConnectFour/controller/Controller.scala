package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.player.Player
import de.htwg.se.ConnectFour.util.{Observable, UndoManager}

trait Controller extends Observable{
  var grid:Grid
  var players: Vector[Player]
  var move:Int
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
  def drop(input:Option[String]): Unit
  def undoDrop(): Unit
  def redoDrop(): Unit
  def reset(): Unit
  def gridPrint(): String
}
