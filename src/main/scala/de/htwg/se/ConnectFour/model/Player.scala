package de.htwg.se.ConnectFour.model

import de.htwg.se.ConnectFour.util.Strategy

trait Player {
  def pname:String
  def pnumber: Int
  def pcolor: String
}

private class Player1(playerName: String, playerNumber: Int) extends Player {
  override def pname: String = playerName
  override def pnumber: Int = playerNumber
  override def pcolor: String = "red"
  override def toString:String = "Der Spieler " + pname + " mit der Nummer "+
                                  pnumber + " hat die Farbe " + pcolor
}

private class Player2(playerName: String, playerNumber: Int) extends Player {
  override def pname: String = playerName
  override def pnumber: Int = playerNumber
  override def pcolor: String = "yellow"
  override def toString:String = "Der Spieler " + pname + " mit der Nummer "+
    pnumber + " hat die Farbe " + pcolor
}

object Player {
  def apply(playerName: String, playerNumber: Int) = playerNumber match {
      case playerNumber => new Player1(playerName,playerNumber)
      case playerNumber=> new Player2(playerName,playerNumber)
    }
}



