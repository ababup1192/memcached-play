package controllers

import javax.inject._
import play.api._
import play.api.cache.AsyncCacheApi
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, cache: AsyncCacheApi) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def getCache: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    cache.get[User]("user").map { userOpt =>
      Ok(userOpt.map(_.toString).getOrElse("Empty User"))
    }
  }

  def setCache(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    val user = User("John", 12)
    cache.set("user", user).map { done =>
      Ok(user.toString)
    }
  }


}

case class User(name: String, age: Int)
