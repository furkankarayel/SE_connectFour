package de.htwg.se.ConnectFour.model

case class Cell (value: String){
  def isSet: Boolean = value != ""
}
