package de.htwg.se.ConnectFour.model.player.impl

import de.htwg.se.ConnectFour.model.player.{Player, PlayerBuilder}
import com.google.inject.Inject

case class PlayerBuilderImpl @Inject()() extends PlayerBuilder {

   override def createPlayer(name: String, number: Int): Player = {
     PlayerImpl(name, number)
  }

}
