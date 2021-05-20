package de.htwg.se.ConnectFour.aUI;

import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{UI,Observer}

class GUI(controller: Controller) extends UI with Observer{
    override def processInput(input: String):Unit = {}
    override def update: Boolean =  { println(controller.toString);true }
}