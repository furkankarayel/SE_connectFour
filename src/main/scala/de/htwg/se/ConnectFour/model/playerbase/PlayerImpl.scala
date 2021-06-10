package de.htwg.se.ConnectFour.model.playerbase

import de.htwg.se.ConnectFour.model.Player

case class PlayerImpl(playerName: String, playerNumber: Int) extends Player {
  val name: String = playerName
  val number: Int = playerNumber
  val color: Option[String] = {
    number match {
      case 1 => Some("red")
      case 2 => Some("yellow")
    }
  }

  override def toString: String = "Der Spieler " + name + " mit der Nummer " +
    number + " hat die Farbe " + color
}
