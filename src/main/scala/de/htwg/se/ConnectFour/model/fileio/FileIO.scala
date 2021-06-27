package de.htwg.se.ConnectFour.model.fileio

import de.htwg.se.ConnectFour.controller.Controller

/**
 * FileIO Trait
 */
trait FileIO {
  def load(controller:Controller):Unit
  def save(game: Controller): Unit
}
