package de.htwg.se.ConnectFour.model

case class Player(playerName: String, playerNumber: Int) {
  val name: String = playerName
  val number: Int = playerNumber
  val color: String = number match {
    case 1 => "red"
    case 2 => "yellow"
  }
  override def toString:String = "Der Spieler " + name + " mit der Nummer "+
                                  number + " hat die Farbe " + color
}

private class Player2(playerName: String, playerNumber: Int) extends Player {
  override def pname: String = playerName
  override def pnumber: Int = playerNumber
  override def pcolor: String = "yellow"
  override def toString:String = "Der Spieler " + pname + " mit der Nummer "+
    pnumber + " hat die Farbe " + pcolor
}

object Player {
  def apply(playerName: String, playerNumber: Int) = playerNumber match {
      case playerNumber => new Player1(playerName,playerNumber)
      case playerNumber=> new Player2(playerName,playerNumber)
    }
}


