package de.htwg.se.ConnectFour.model.fieldbase.gridbase.CellPieceBase

import de.htwg.se.ConnectFour.model.Player

case class Piece(player: Player) {

  override def toString: String = {
    player.playerNumber match {
      case 1 => Console.RED + "☻ "
      case 2 => Console.YELLOW + "☻ "
    }
  }
}
