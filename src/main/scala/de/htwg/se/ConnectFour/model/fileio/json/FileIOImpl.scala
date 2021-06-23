package de.htwg.se.ConnectFour.model.fileio.json

import com.google.inject.{Guice, Inject}
import de.htwg.se.ConnectFour.GameModule
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fileio.FileIO
import de.htwg.se.ConnectFour.model.grid.Grid
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import play.api.libs.json._

import java.io.{File, PrintWriter}
import scala.io.Source


class FileIOImpl @Inject () extends FileIO {

  override def load: Controller = {
    val source: String = Source.fromFile("game.json").getLines.mkString
    val injector = Guice.createInjector(new GameModule)
    val controller = injector.instance[Controller]
    val gameJson: JsValue = Json.parse(source)
    val grid = (gameJson \ "grid")
    val moveCount = (gameJson \ "player" \ "moveCount").get.toString().toInt
    val currentPlayer = (gameJson \ "player" \ "currentPlayer").get.toString()
    val player1 = (gameJson \ "player" \ "player1").get.toString()
    val player2 = (gameJson \ "player" \ "player2").get.toString()


    var newGrid: Grid = controller.getGrid()
    controller.setMoveCount(moveCount)
    controller.addPlayer(player1)
    controller.addPlayer(player2)
    currentPlayer match {
      case player1 => controller.setCurrentPlayer(controller.players(0))
      case player2 => controller.setCurrentPlayer(controller.players(1))
    }


    controller
  }

  def gameToJson(controller: Controller): JsValue = {
    Json.obj(
      "player" -> Json.obj(
        "moveCount" -> Json.obj(
          "value"  -> controller.moveCount
        ),
        "currentPlayer" -> Json.obj(
          "name" -> controller.currentPlayer.playerName
        ),
        "player1" -> Json.obj(
          "name" -> controller.players(0).playerName
        ),
        "player2" -> Json.obj(
          "name" -> controller.players(1).playerName
        )
      ),
      "grid" -> Json.obj(
        "cells" -> Json.toJson(
          for {col <- 0 to controller.colCount - 1;
               row <- (0 to controller.rowCount - 1).reverse
               }
          yield {
            Json.obj(
              "row" -> row,
              "col" -> col,
              "value" -> Json.toJson(controller.getGrid().cell(row, col).toString)
            )
          }
        )
      )
    )
  }

  override def save(game: Controller): Unit = {
    val pw = new PrintWriter(new File("game.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close
  }
}
