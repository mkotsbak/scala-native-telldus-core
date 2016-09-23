import TelldusCoreFull.TDDeviceEvent

import scalanative.native._
import stdio._
import string._
import FunctionPtr._

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

  def callback(deviceId: CInt, method: CInt, data: CString, callbackId: CInt, context: Ptr[_]) = {
    //fprintf(stdout, c"DeviceId: %i, method: %i, data: %s", deviceId, method, data)
    stdlib.malloc(1)
  }

  def main(args: Array[String]): Unit = {
    fprintf(stdout, c"Hi!")
    TelldusCore.tdInit()
    //
     //val cb: TDDeviceEvent = callback
    //
    TelldusCoreFull.tdRegisterDeviceEvent( (deviceId: CInt, method: CInt, data: CString, callbackId: CInt, context: Ptr[_]) => {
      fprintf(stdout, c"DeviceId: %i, method: %i, data: %s\n", deviceId, method, data)
      fflush(stdout)
      stdlib.malloc(1)
    }, stdlib.malloc(1))

    TelldusCore.tdTurnOn(1)
    Thread.sleep(2000)
    TelldusCore.tdTurnOff(1)

    Thread.sleep(5000)

    getchar()
    getchar()
    TelldusCore.tdClose()
  }
}
