package de.htwg.se.ConnectFour.model

case class Cell (piece: Option[Piece]){
  def isSet: Boolean = piece.isDefined
  override def toString: String = piece match {
    case None => "_"
    case Some(value) => value.toString
  }
}
