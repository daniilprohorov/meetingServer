package controllers

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._
import controllers.MainController

class Router @Inject()(controller: MainController) extends SimpleRouter {
  override def routes: Routes = {
    case POST(p"/") =>
      controller.find

//    case GET(p"/$id") =>
//      controller.show(id)
  }

}
