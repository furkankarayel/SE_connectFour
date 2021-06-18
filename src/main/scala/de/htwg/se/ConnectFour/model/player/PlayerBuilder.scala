package de.htwg.se.ConnectFour.model.player

trait PlayerBuilder {
  def createPlayer(name: String, number: Int): Player
}
