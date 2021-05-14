package de.htwg.se.ConnectFour.util

trait Command {
  def doStep:Unit
  def undoStep:Unit
  def redoStep:Unit
}


