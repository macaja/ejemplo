package example.dominio.factura.commands

import example.dominio.factura.Factura

import scala.concurrent.{ExecutionContext, Future}

case class CrearFactura(factura:Factura)(implicit ex: ExecutionContext) {
  def ejecutar: Future[Either[String, Factura]] = for{
    f <- getFacturaE(factura)
  }yield {
    f.fold[Either[String,Factura]](Right(guardarFactura(factura)))(_ => Left("la factura ya existe"))
  }

  def getFacturaS(factura: Factura):Future[Option[Factura]] = Future.successful(Some(Factura(1,"xxx")))
  def getFacturaE(factura: Factura):Future[Option[Factura]] = Future.successful(None)
  def guardarFactura(factura: Factura): Factura = factura
}
