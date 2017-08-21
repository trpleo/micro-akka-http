package org.trp.ms

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{BeforeAndAfterAll, FeatureSpec, GivenWhenThen, Matchers}

import scala.language.experimental.macros
import scala.language.postfixOps


/**
 * Created by ipapp on 21/08/17.
 */
class InterfaceSpec extends FeatureSpec with GivenWhenThen with Matchers with BeforeAndAfterAll with ScalatestRouteTest {

  val smallRoute: Route =
    get {
        path("ping") {
          complete(StatusCodes.Accepted, "pong")
        }
    }


  feature("The user can ping the service") {

    info("As a service user")
    info("I want to be able to know if the sevice is up")
    info("So I can be informed about the service state in a baic way.")

    scenario("blu sky bing scenario") {
      Given("the service is up and running")

      When("a ping request hits the service")
      Get("/ping") ~> smallRoute ~> check {

        Then("a pong response must be in the response")
        responseAs[String] should equal("pong")

        And("the header has to be 200 (OK)")
        status should equal(StatusCodes.Accepted)
      }
    }
  }
}
