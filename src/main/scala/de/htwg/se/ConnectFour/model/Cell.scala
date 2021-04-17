package de.htwg.se.ConnectFour.model

case class Cell (value: Int){
  def isSet: Boolean = value != 0
}
