package de.htwg.se.ConnectFour.model.player

trait Player {
  val playerNumber: Int
  val color: Option[String]
  val playerName: String
}
