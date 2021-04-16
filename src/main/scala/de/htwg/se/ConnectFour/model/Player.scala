package de.htwg.se.ConnectFour.model

case class Player(playerName: String, playerColor: String) {
  val name: String = playerName
  val color: String = playerColor
  override def toString:String = "Der Spieler " + name + " hat die Farbe "+ color
}
