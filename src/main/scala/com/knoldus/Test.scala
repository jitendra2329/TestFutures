package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Success, Failure}

object Test extends App {
  private val firstFuture: Future[String] = Future {
    "I am from future first"
  }

  private val secondFuture: Future[String] = Future {
    "I am from second future"
  }

  //  firstFuture.onComplete {
  //    case Success(value) => {
  //      println(value)
  //      secondFuture.foreach(println)
  //    }
  //    case Failure(exception) => println("First future failed")
  //  }

  firstFuture.foreach { value =>
    println(value)
    secondFuture.foreach(println)
  }

  Thread.sleep(2000)
}
