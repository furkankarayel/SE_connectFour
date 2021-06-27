package de.htwg.se.ConnectFour.model.player

/**
 * Player Trait
 */
trait Player {
  val playerNumber: Int
  val color: Option[String]
  val playerName: String
}
