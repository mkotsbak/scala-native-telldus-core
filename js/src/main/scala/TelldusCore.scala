import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

object TelldusCore extends TelldusCoreInterface {
  import js.Dynamic.{global => g}
  private val tsl = g.require("telldus").asInstanceOf[TelldusCoreNative]

  override def tdInit(): Unit = {} // Done automatically
  override def tdClose(): Unit = {} // Done automatically

  override def tdTurnOn(intDeviceId: Int): Int = tsl.tdTurnOn(intDeviceId)
  override def tdTurnOff(intDeviceId: Int): Int = tsl.tdTurnOff(intDeviceId)
}

@js.native
@JSName("telldus")
trait TelldusCoreNative extends js.Object {
  @JSName("turnOnSync")
  def tdTurnOn(intDeviceId: Int): Int = js.native

  @JSName("turnOffSync")
  def tdTurnOff(intDeviceId: Int): Int = js.native
}
