package de.htwg.se.ConnectFour.model.fileio

import de.htwg.se.ConnectFour.controller.Controller


trait FileIO {

  def load: Controller

  def save(game: Controller): Unit

}
