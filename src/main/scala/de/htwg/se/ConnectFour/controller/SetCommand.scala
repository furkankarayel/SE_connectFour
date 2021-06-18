package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.model.grid.Grid

trait SetCommand {
  var memento:Grid
  def doStep: Unit
  def undoStep: Unit
  def redoStep: Unit
}
