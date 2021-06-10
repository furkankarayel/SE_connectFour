package de.htwg.se.ConnectFour.model.gridbase.cellpiecebase

import de.htwg.se.ConnectFour.model.playerbase.Player

case class Piece(player: Player) {

  override def toString: String = {
    player.playerNumber match {
      case 1 => Console.RED + "☻ "
      case 2 => Console.YELLOW + "☻ "
    }
  }
}
