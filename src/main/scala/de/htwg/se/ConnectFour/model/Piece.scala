package de.htwg.se.ConnectFour.model

case class Piece(player: Player) {
  override def toString: String = player.playerNumber match {
    case 1 => Console.RED + "☻ "
    case 2 => Console.YELLOW + "☻ "
  }
}
