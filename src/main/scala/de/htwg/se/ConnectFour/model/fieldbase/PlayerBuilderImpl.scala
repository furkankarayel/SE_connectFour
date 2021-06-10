package de.htwg.se.ConnectFour.model.fieldbase

import de.htwg.se.ConnectFour.util.Builder

case class  PlayerBuilderImpl() extends PlayerBuilderImpl with Builder {
  var name: String = ""
  var number: Int = 0

  override def setPlayer(name: String, number: Int): PlayerBuilderImpl = {
    this.name = name
    this.number = number
    this
  }

  def build(): PlayerImpl = PlayerImpl(name, number)
}
