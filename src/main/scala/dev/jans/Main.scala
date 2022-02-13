package dev.jans

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    IO {
      println("jan")
    }.flatMap(_ => IO(ExitCode.Success))
  }
}
