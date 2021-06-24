package de.htwg.se.ConnectFour.model.fileio.xml
import com.google.inject.Guice
import de.htwg.se.ConnectFour.GameModule
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fileio.FileIO
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector

import scala.xml.PrettyPrinter

class FileIOImpl() extends FileIO {

  override def load: Controller = {
    val injector = Guice.createInjector(new GameModule)
    val controller = injector.instance[Controller]
    val file = scala.xml.XML.loadFile("game.xml")

    val cellNodes = (file \\ "cell")
    for (cell <- cellNodes) {
      val row: Int = (cell \ "@row").text.toInt
      val col: Int = (cell \ "@col").text.toInt
      val value: String = cell.text.trim
    }

    controller
  }
  def gameToXml(controller: Controller) = {
    <game>
      <player>
        <moveCount>
          { controller.moveCount }
        </moveCount>
        <currentPlayer>
          { controller.currentPlayer.playerName }
        </currentPlayer>
        <player1>
          { controller.players(0).playerName }
        </player1>
        <player2>
          { controller.players(1).playerName }
        </player2>
      </player>
    <grid>
      {
      for {col <- 0 to controller.colCount - 1;
    row <- (0 to controller.rowCount - 1).reverse
    }
    yield {
      var player = controller.getGrid().cell(row, col).piece match {
        case Some(s) => s.player.playerNumber
        case None => -1
      }
      <cell row={ row.toString } col={ col.toString }>
        { player.toString }
      </cell>
    }
      }
    </grid>
    </game>
  }
  override def save(game: Controller): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("gameboard.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(gameToXml(game))
    pw.write(xml)
  }
}