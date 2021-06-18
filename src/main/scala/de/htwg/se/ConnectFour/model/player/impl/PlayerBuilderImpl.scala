package de.htwg.se.ConnectFour.model.player.impl

import de.htwg.se.ConnectFour.model.player.{Player, PlayerBuilder}

case class PlayerBuilderImpl() extends PlayerBuilder {
  var name: String = ""
  var number: Int = 0

  override def setPlayer(name: String, number: Int): PlayerBuilderImpl = {
    this.name = name
    this.number = number
    this
  }

  def build(): Player = PlayerImpl(name, number)
}
