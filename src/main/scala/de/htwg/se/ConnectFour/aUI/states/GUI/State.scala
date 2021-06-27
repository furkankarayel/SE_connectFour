package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI

/**
 * State Trait
 * Implementation of State
 * pattern in the GUI package
 */
trait State[T] {
  def handle(input:String,gui:GUI,state:T)
}