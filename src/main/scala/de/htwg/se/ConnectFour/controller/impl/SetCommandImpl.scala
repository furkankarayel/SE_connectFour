package de.htwg.se.ConnectFour.controller.impl

import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.grid.impl.Piece
import de.htwg.se.ConnectFour.util.Command

/**
 *  Command/Memento pattern implementation
 */
class SetCommandImpl(col: Int, piece:Piece, controller: ControllerImpl) extends Command {
  var memento:Grid = controller.grid
  
  override def doStep: Unit = {
    memento = controller.grid
    controller.setGrid(controller.grid.drop(col:Int, piece:Piece))
  }
  override def undoStep: Unit = {
    val new_memento = controller.grid //save actual grid before undo
    controller.setGrid(memento)       //reverting to old grid
    memento = new_memento             //step after
  }
  override def redoStep: Unit = {
    val new_memento = controller.grid //save actual grid before redo
    controller.setGrid(memento)       //reverting to new grid
    memento = new_memento             //step before
  }
}
