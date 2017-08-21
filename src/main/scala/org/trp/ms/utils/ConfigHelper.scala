package org.trp.ms.utils

import scala.concurrent.duration.{Duration => sd, FiniteDuration}
import java.time.{Duration => jd}

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.Try

/**
 * Created by ipapp on 21/08/17.
 */
object ConfigHelper {

  implicit class EnrichJavaDuration(javaDuration: jd) {
    def toScalaDuration(): sd = sd.fromNanos(javaDuration.toNanos)
  }

  implicit class EnrichFiniteDuration(duration: sd) {
    def configFiniteDurationOrElse(default: FiniteDuration): FiniteDuration = Try { duration.toMillis milliseconds } getOrElse default
  }
}
