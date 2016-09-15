import scalanative.native._, stdio._
import java.lang.Math.{PI, sin, cos, abs, pow, sqrt}

@link("telldus-core")
@extern object TelldusCore {
  def tdInit(): Unit = extern
  def tdTurnOn(deviceId: Int): Int = extern
  def tdTurnOff(deviceId: Int): Int = extern
  def tdClose(): Unit = extern
}

@extern object Unistd {
  def usleep(usecs: Long): Int = extern
}

object Thread {
  def sleep(millis: Long) = Unistd.usleep(millis * 1000)
}

object TellstickTest {
  def main(args: Array[String]): Unit = {
    TelldusCore.tdInit()

    TelldusCore.tdTurnOn(1)
    Thread.sleep(2000)
    TelldusCore.tdTurnOff(1)

    fprintf(stdout, c"Hi!")
    TelldusCore.tdClose()
  }
}
