package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.model.{Grid, Piece}
import de.htwg.se.ConnectFour.util.Observable

class Controller(var grid:Grid) extends Observable {
  def createGrid(): Unit = {
    reset()
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

