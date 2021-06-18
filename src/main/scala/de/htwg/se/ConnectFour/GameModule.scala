package de.htwg.se.ConnectFour
import com.google.inject.AbstractModule
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl
import net.codingwell.scalaguice.ScalaModule
import java.lang.ModuleLayer.Controller

class GameModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
      bind[Grid].to[GridImpl]
      bind[Grid].toInstance(new GridImpl())
      bind[Controller].to[ControllerImpl]
  }
}
