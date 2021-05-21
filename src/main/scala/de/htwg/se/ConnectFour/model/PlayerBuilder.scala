package de.htwg.se.ConnectFour.model

import de.htwg.se.ConnectFour.util.Builder

case class PlayerBuilder() extends Builder {
  var name: String = ""
  var number: Int = 0

  override def setPlayer(name: String, number: Int): PlayerBuilder = {
    this.name = name
    this
  }
  def build(): Player = Player(name, number)
}
