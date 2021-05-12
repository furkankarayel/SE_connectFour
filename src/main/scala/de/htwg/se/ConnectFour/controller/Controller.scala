package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour._
import de.htwg.se.ConnectFour.model.{Grid, Piece, Player}
import de.htwg.se.ConnectFour.util.Observable



class Controller(var grid:Grid, val p1:Player,val p2:Player) extends Observable {
  def createGrid(): Unit = {
    grid = new Grid
    notifyObservers
  }

  def doMove(input:String): Unit = {
    Game.player = if (Game.move % 2 == 0) Player(p1.pname,p1.pnumber) else Player(p2.pname,p2.pnumber)
    input.toList.filter(c => c != " ").map(c => c.toString.toInt) match {
      case col :: Nil =>
        dropPiece(col, Piece(Game.player.pnumber))
        Game.move += 1
        print(gridPrint)
    }
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

