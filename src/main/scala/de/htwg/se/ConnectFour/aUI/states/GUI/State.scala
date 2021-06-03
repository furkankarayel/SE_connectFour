package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI

trait State[T] {
  def handle(input:String,gui:GUI,state:T)
}