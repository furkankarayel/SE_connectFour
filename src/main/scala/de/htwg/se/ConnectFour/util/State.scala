package de.htwg.se.ConnectFour.util

trait State[T] {
  def handle(input:String,state:T)
}
