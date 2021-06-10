package de.htwg.se.ConnectFour.model.fieldbase

case class CellImpl(piece: Option[PieceImpl]) {
  def isSet: Boolean = piece.isDefined

  override def toString: String = {
    piece match {
      case None => Console.BLUE + "_ "
      case Some(value) => value.toString
    }
  }
}
