package de.htwg.se.ConnectFour.model
import de.htwg.se.ConnectFour.util.Builder

trait PlayerBuilder extends Builder {
  def build(): Player
  def setPlayer(name: String, number: Int): PlayerBuilder
}
