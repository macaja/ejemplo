package example.infrasetructura.adapatadores.http.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes.OK
trait Rutas {

  def crearFactura =
    path("factura"){
      post{
        complete(OK -> "FACTURA CREADA")
      }
    }

}
