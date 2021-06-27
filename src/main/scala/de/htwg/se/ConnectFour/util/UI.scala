package de.htwg.se.ConnectFour.util

/**
 * UI Trait
 * factory method pattern
 */
trait UI{
  def processInput(input: String)
  def run():Unit
}
