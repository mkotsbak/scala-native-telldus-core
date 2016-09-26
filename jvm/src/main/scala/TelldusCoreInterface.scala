import net.jstick.api.TellstickLibrary

/**
  * Created by marius on 27.09.16.
  */
object TelldusCore extends TelldusCoreInterface {
  val tsc = TellstickLibrary.INSTANCE
  def tdInit(): Unit = tsc.tdInit()
  def tdClose(): Unit = tsc.tdClose()

  def tdTurnOn(intDeviceId: Int): Int = tsc.tdTurnOn(intDeviceId)
  def tdTurnOff(intDeviceId: Int): Int = tsc.tdTurnOff(intDeviceId)
}
