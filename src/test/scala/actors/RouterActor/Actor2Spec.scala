package actors.RouterActor

import akka.actor.{ActorRef, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatest.{FunSuite, Matchers, WordSpec}

import scala.concurrent.Await
import scala.concurrent.duration._

class Actor2Spec extends FunSuite with Matchers {
	val actorSystem = ActorSystem("ChildActorTest")
	var childActor = actorSystem.actorOf(Props[Actor2])
	implicit val timeout = Timeout(2.seconds)

	test("actor2 response with its name when requested") {
		val responseFuture = childActor ? "identify"
		val response = Await.result(responseFuture, timeout.duration)
		response should be("I'm Actor2")
	}
}
