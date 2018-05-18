package example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import example.infrasetructura.adapatadores.http.api.Rutas

object Main extends Rutas with App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  Http().bindAndHandle(crearFactura, "localhost", 8080)

}
