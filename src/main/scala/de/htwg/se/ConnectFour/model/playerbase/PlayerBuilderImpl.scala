package de.htwg.se.ConnectFour.model.playerbase

import de.htwg.se.ConnectFour.model.{PlayerBuilder,Player}

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
