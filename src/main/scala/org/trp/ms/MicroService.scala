package org.trp.ms

import akka.event.Logging
import org.trp.ms.utils.{Akka, Config}

import scala.concurrent.Await

/**
 * Created by ipapp on 21/08/17.
 */
object MicroService extends App with Config {
  implicit val as = Akka.system
  implicit val log = Logging(Akka.system, getClass)

  log.info("Service is started...")

  Await.result(as.terminate(), akkaSystemShutdownTimeout)

  log.info(s"Service is down...")
}
