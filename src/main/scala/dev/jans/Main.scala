package dev.jans
import pureconfig._
import pureconfig.generic.auto._
import cats.effect.{ExitCode, IO, IOApp}
import pureconfig.ConfigReader.Result

object Main extends IOApp {
  case class Config (username:String,password:String)
  val loadedConfig: Result[Config] =ConfigSource.default.load[Config]

  override def run(args: List[String]): IO[ExitCode] = {
   val msg = loadedConfig match  {
      case Right(config) => config
      case Left(failures) => failures
    }
    IO { println(msg)} .flatMap(_ => IO(ExitCode.Success))
  }
}
