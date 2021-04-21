package de.htwg.se.ConnectFour.model

case class Player(playerName: String, playerNumber: Int) {
  val name: String = playerName
  val number: Int = playerNumber
  val color: String = number match {
    case 1 => "red"
    case 2 => "yellow"
  }
  override def toString:String = "Der Spieler " + name + " mit der Nummer "+
                                  number + " hat die Farbe " + color
}
