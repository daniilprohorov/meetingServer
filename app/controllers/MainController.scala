package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import logic.API._
import logic.Config._

import scala.util.{Failure, Success}
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class MainController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    println(request)
    Ok(views.html.index())
  }

  def find() = Action { implicit request: Request[AnyContent] =>
    request.body.asJson match {
        case Some(json) =>
          stringToConfig(json.toString) match {
              case Success(v) => Ok(events(configDataToInternal(v)))
              case Failure(_) => Ok("error")
          }
        case None => Ok("error json parse")
    }
  }

}
