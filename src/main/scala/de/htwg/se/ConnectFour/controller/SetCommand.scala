package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour.model.{Grid, Piece}
import de.htwg.se.ConnectFour.util.Command

class SetCommand(col: Int, piece:Piece, controller: Controller) extends Command {
  var memento:Grid = controller.grid
  override def doStep: Unit = {
    memento = controller.grid
    controller.grid.drop(col:Int, piece:Piece)
  }
  override def undoStep: Unit = {
    val new_memento = controller.grid //save actual grid before undo
    controller.grid = memento         //reverting to old grid
    memento = new_memento             //step after
  }
  override def redoStep: Unit = {
    val new_memento = controller.grid //save actual grid before redo
    controller.grid = memento         //reverting to new grid
    memento = new_memento             //step before
  }
}
