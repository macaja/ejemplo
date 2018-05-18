package example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import example.infrasetructura.adapatadores.http.api.Rutas

import scala.util.{Failure, Success}

object Main extends Rutas with App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  Http().bindAndHandle(crearFactura, "localhost", 8080) onComplete{
    case Failure(ex) => println(s"fallo $ex")
    case Success(_) => println("works")
  }

}
