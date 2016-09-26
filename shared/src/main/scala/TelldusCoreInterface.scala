/**
  * Created by marius on 27.09.16.
  */
trait TelldusCoreInterface {
  def tdInit(): Unit
  def tdClose(): Unit

  def tdTurnOn(intDeviceId: Int): Int
  def tdTurnOff(intDeviceId: Int): Int
}
