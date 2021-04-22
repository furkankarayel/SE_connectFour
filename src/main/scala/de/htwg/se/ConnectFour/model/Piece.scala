package de.htwg.se.ConnectFour.model

case class Piece(player: Player) {
  override def toString: String = player.playerNumber match {
    case 1 => "R"
    case 2 => "Y"
  }
}
