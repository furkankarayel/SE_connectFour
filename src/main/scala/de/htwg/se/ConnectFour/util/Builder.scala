package de.htwg.se.ConnectFour.util

trait Builder {
  def setPlayer(name: String, number:Int): Builder
}