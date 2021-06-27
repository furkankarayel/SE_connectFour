package de.htwg.se.ConnectFour.model.player

/**
 * Player Builder Trait
 * Builder pattern
 */
trait PlayerBuilder {
  def createPlayer(name: String, number: Int): Player
}
