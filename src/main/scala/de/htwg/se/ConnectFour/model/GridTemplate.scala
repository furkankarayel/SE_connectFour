package de.htwg.se.ConnectFour.model

abstract class GridTemplate {
  def cell(row: Int, col: Int): Cell
  def toString(): String
}