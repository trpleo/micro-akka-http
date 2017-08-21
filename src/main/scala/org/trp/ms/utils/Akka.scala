package org.trp.ms.utils

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

/**
 * Created by ipapp on 21/08/17.
 */
object Akka {
  implicit val system: ActorSystem = ActorSystem("ms")
  implicit val materializer: ActorMaterializer = ActorMaterializer(None, Some("ms-mat"))(system)
}
