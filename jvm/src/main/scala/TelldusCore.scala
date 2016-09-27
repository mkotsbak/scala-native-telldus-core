import net.jstick.api.TellstickLibrary

object TelldusCore extends TelldusCoreInterface {
  private final val tsl = TellstickLibrary.INSTANCE

  def tdInit(): Unit = tsl.tdInit()
  def tdClose(): Unit = tsl.tdClose()

  def tdTurnOn(intDeviceId: Int): Int = tsl.tdTurnOn(intDeviceId)
  def tdTurnOff(intDeviceId: Int): Int = tsl.tdTurnOff(intDeviceId)
}
