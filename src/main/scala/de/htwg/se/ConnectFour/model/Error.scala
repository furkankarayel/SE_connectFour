package de.htwg.se.ConnectFour.model

trait Error extends Throwable

case class CannotDropPiece() extends Error
case class ColumnFull() extends Error
case class InvalidPiece() extends Error
case class InvalidColumnNumber() extends Error
case class InputExpected() extends Error

