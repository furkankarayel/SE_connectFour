package de.htwg.se.ConnectFour.model.fieldbase

case class PieceImpl(player: PlayerImpl) {
  override def toString: String = {
    player.playerNumber match {
      case 1 => Console.RED + "☻ "
      case 2 => Console.YELLOW + "☻ "
    }
  }
}
