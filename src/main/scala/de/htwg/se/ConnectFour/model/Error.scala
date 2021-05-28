package de.htwg.se.ConnectFour.model

trait Error extends Throwable

case class CannotDropPiece() extends Error
case class ColumnFull() extends Error
case class InvalidPiece() extends Error

