package de.htwg.se.ConnectFour.model

case class Piece(player: Player) {
  override def toString: String = player.playerNumber match {
    case 1 => "red"
    case 2 => "yellow"
  }
}
