package de.htwg.se.ConnectFour.model

case class Piece(number: Int) {
  override def toString: String = number match {
    case 1 => Console.RED + "☻ "
    case 2 => Console.YELLOW + "☻ "
  }
}
