package de.htwg.se.ConnectFour.model.grid.impl

/**
 * Cell case class
 */
case class Cell(piece: Option[Piece]) {
  def isSet: Boolean = piece.isDefined

  override def toString: String = {
    piece match {
      case None => Console.BLUE + "_ "
      case Some(value) => value.toString
    }
  }
}
