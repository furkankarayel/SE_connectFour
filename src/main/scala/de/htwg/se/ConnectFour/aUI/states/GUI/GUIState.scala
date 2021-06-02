package de.htwg.se.ConnectFour.aUI.states.GUI

trait GUIState[T] {
  def handle(state: T)
  def handle(input: String, state: T)
}
