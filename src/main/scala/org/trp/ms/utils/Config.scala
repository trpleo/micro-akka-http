package org.trp.ms.utils

import com.typesafe.config.ConfigFactory
import org.trp.ms.utils.ConfigHelper._
import scala.concurrent.duration._
import scala.language.postfixOps

/**
 * Created by ipapp on 21/08/17.
 */
trait Config {
  private val config = ConfigFactory.load()

  private val http = config.getConfig("http")

  private val ms = config.getConfig("ms")

  private val akka = config.getConfig("akka")
  val akkaSystemShutdownTimeout = akka.getDuration("akkaSystemShutdownTimeout").toScalaDuration().configFiniteDurationOrElse(5 seconds)
}
