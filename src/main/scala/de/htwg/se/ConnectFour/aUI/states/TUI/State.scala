package de.htwg.se.ConnectFour.aUI.states.TUI

trait State[T] {
  def handle(input:String,state:T)
}