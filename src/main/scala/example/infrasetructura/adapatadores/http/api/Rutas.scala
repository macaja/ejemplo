package example.infrasetructura.adapatadores.http.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes.{InternalServerError, OK}
import akka.http.scaladsl.server.Route
import example.dominio.factura.Factura
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import example.dominio.factura.commands.CrearFactura

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}
trait Rutas {

  def crearFactura(implicit ex: ExecutionContext): Route =
    path("factura"){
      post{
        entity(as[Factura]){ f =>
          onComplete(CrearFactura(f).ejecutar) {
            case Success(e) => e.fold(
              _ => complete("Factura ya existe"),
              f => complete(OK -> f.toString)
            )
            case Failure(ex) => complete(InternalServerError -> ex.toString)
          }
        }
      }
    }

}
