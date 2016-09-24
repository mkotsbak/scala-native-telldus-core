import scalanative.native._

@link("telldus-core")
@extern object TelldusCore {
  //void (WINAPI *TDDeviceEvent)(int deviceId, int method, const char *data, int callbackId, void *context);
  type TDDeviceEvent = FunctionPtr5[CInt, CInt, CString, CInt, Ptr[_], Unit]

  // void (WINAPI *TDDeviceChangeEvent)(int deviceId, int changeEvent, int changeType, int callbackId, void *context);
  type TDDeviceChangeEvent = FunctionPtr5[CInt, CInt, CInt, CInt, Ptr[_], Unit]

  // void (WINAPI *TDRawDeviceEvent)(const char *data, int controllerId, int callbackId, void *context);
  type TDRawDeviceEvent = FunctionPtr4[CString, CInt, CInt, Ptr[_], Unit]

  // void (WINAPI *TDSensorEvent)(const char *protocol, const char *model, int id, int dataType, const char *value, int timestamp, int callbackId, void *context);
  type TDSensorEvent = FunctionPtr8[CString, CString, CInt, CInt, CString, CInt, CInt, Ptr[_], Unit]

  // void (WINAPI *TDControllerEvent)(int controllerId, int changeEvent, int changeType, const char *newValue, int callbackId, void *context);
  type TDControllerEvent = FunctionPtr6[CInt, CInt, CInt, CString, CInt, Ptr[_], Unit]

  def tdInit(): Unit = extern
  def tdClose(): Unit = extern

  def tdRegisterDeviceEvent(eventFunction: TDDeviceEvent, context: Ptr[_]): CInt = extern
  def tdRegisterDeviceChangeEvent(eventFunction: TDDeviceChangeEvent, context: Ptr[_]): CInt = extern
  def tdRegisterRawDeviceEvent(eventFunction: TDRawDeviceEvent, context: Ptr[_]): CInt = extern
  def tdRegisterSensorEvent(eventFunction: TDSensorEvent, context: Ptr[_]): CInt = extern
  def tdRegisterControllerEvent(eventFunction: TDControllerEvent, context: Ptr[_]): CInt = extern
  def tdUnregisterCallback(callbackId: CInt): CInt = extern

  def tdReleaseString(thestring: CString): Unit = extern

  def tdTurnOn(intDeviceId: CInt): CInt = extern
  def tdTurnOff(intDeviceId: CInt): CInt = extern
  def tdBell(intDeviceId: CInt): CInt = extern
  def tdDim(intDeviceId: CInt, level: CUnsignedChar): CInt = extern
  def tdExecute(intDeviceId: CInt): CInt = extern
  def tdUp(intDeviceId: CInt): CInt = extern
  def tdDown(intDeviceId: CInt): CInt = extern
  def tdStop(intDeviceId: CInt): CInt = extern
  def tdLearn(intDeviceId: CInt): CInt = extern

  def tdMethods(id: CInt, methodsSupported: CInt): CInt = extern
  def tdLastSentCommand(intDeviceId: CInt, methodsSupported: CInt): CInt = extern
  def tdLastSentValue(intDeviceId: CInt): CString = extern
  def tdGetNumberOfDevices(): CInt = extern
  def tdGetDeviceId(intDeviceIndex: CInt): CInt = extern
  def tdGetDeviceType(intDeviceId: CInt): CInt = extern
  def tdGetErrorString(intErrorNo: CInt): CString = extern

  def tdGetName(intDeviceId: CInt): CString = extern
  def tdSetName(intDeviceId: CInt, chNewName: CString): CChar = extern
  def tdGetProtocol(intDeviceId: CInt): CString = extern
  def tdSetProtocol(intDeviceId: CInt, strProtocol: CString): CChar = extern
  def tdGetModel(intDeviceId: CInt): CString = extern
  def tdSetModel(intDeviceId: CInt, intModel: CString): CChar = extern
  def tdGetDeviceParameter(intDeviceId: CInt, strName: CString, defaultValue: CString): CString = extern
  def tdSetDeviceParameter(intDeviceId: CInt, strName: CString, strValue: CString): CChar = extern
  def tdAddDevice(): CInt = extern
  def tdRemoveDevice(intDeviceId: CInt): CChar = extern
  def tdSendRawCommand(command: CString, reserved: CInt): CInt = extern
  def tdConnectTellStickController(vid: CInt, pid: CInt, serial: CString): Unit = extern
  def tdDisconnectTellStickController(vid: CInt, pid: CInt, serial: CString): Unit = extern

  def tdSensor(protocol: CString, protocolLen: CInt, model: CString, modelLen: CInt, id: Ptr[Int], dataTypes: Ptr[Int]): CInt = extern
  def tdSensorValue(protocol: CString, model: CString, id: CInt, dataType: CInt, value: CString, len: CInt, timestamp: Ptr[Int]): CInt = extern

  def tdController(controllerId: Ptr[Int], controllerType: Ptr[Int], name: CString, nameLen: CInt, available: Ptr[Int]): CInt = extern
  def tdControllerValue(controllerId: CInt, name: CString, value: CString, valueLen: CInt): CInt = extern
  def tdSetControllerValue(controllerId: CInt, name: CString, value: CString): CInt = extern
  def tdRemoveController(controllerId: CInt): CInt = extern

  object DeviceMethods {
    final val TURNON = 1
    final val TURNOFF = 2
    final val BELL = 4
    final val TOGGLE = 8
    final val DIM = 16
    final val LEARN = 32
    final val EXECUTE = 64
    final val UP = 128
    final val DOWN = 256
    final val STOP = 512
  }

  object SensorValueTypes {
    final val TEMPERATURE = 1
    final val HUMIDITY = 2
    final val RAINRATE = 4
    final val RAINTOTAL = 8
    final val WINDDIRECTION = 6
  }

  object ErrorCodes {
    final val SUCCESS = 0
    final val ERROR_NOT_FOUND: Int = -1
    final val ERROR_PERMISSION_DENIED: Int = -2
    final val ERROR_DEVICE_NOT_FOUND: Int = -3
    final val ERROR_METHOD_NOT_SUPPORTED: Int = -4
    final val ERROR_COMMUNICATION: Int = -5
    final val ERROR_CONNECTING_SERVICE: Int = -6
    final val ERROR_UNKNOWN_RESPONSE: Int = -7
    final val ERROR_SYNTAX: Int = -8
    final val ERROR_BROKEN_PIPE: Int = -9
    final val ERROR_COMMUNICATING_SERVICE: Int = -10
    final val ERROR_CONFIG_SYNTAX: Int = -11
    final val ERROR_UNKNOWN: Int = -99
  }

  object DeviceTypes {
    final val DEVICE = 1
    final val GROUP = 2
    final val SCENE = 3
  }

  object ControllerTypes {
    final val TELLSTICK     = 1
    final val TELLSTICK_DUO = 2
    final val TELLSTICK_NET = 3
  }

  object DeviceChanges {
    final val ADDED         = 1
    final val CHANGED       = 2
    final val REMOVED       = 3
    final val STATE_CHANGED = 4
  }

  object ChangeTypes {
    final val NAME      = 1
    final val PROTOCOL  = 2
    final val MODEL     = 3
    final val METHOD    = 4
    final val AVAILABLE = 5
    final val FIRMWARE  = 6
  }
}
