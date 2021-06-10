package de.htwg.se.ConnectFour.model

trait Grid {
  def cell : Cell

  def drop() : Grid

  def reset() : Grid

  def toString : String
}
