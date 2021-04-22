package de.htwg.se.ConnectFour.model

case class Settings(dimRow: Int = 6,dimCol: Int = 7) {
  val player1color = "red"
  val player2color = "yellow"
  val dimensionRow = dimRow
  val dimensionColumn = dimCol
}
