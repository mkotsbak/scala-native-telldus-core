import scalanative.native._

@extern object TelldusCoreFull {
  //void (WINAPI *TDDeviceEvent)(int deviceId, int method, const char *data, int callbackId, void *context);
  type TDDeviceEvent = FunctionPtr5[CInt, CInt, CString, CInt, Ptr[_], Ptr[_]]

  // void (WINAPI *TDDeviceChangeEvent)(int deviceId, int changeEvent, int changeType, int callbackId, void *context);
  type TDDeviceChangeEvent = FunctionPtr5[CInt, CInt, CInt, CInt, Ptr[_], Ptr[_]]

  // void (WINAPI *TDRawDeviceEvent)(const char *data, int controllerId, int callbackId, void *context);
  type TDRawDeviceEvent = FunctionPtr4[CString, CInt, CInt, Ptr[_], Ptr[_]]

  // void (WINAPI *TDSensorEvent)(const char *protocol, const char *model, int id, int dataType, const char *value, int timestamp, int callbackId, void *context);
  type TDSensorEvent = FunctionPtr8[CString, CString, CInt, CInt, CString, CInt, CInt, Ptr[_], Ptr[_]]

  // void (WINAPI *TDControllerEvent)(int controllerId, int changeEvent, int changeType, const char *newValue, int callbackId, void *context);
  type TDControllerEvent = FunctionPtr6[CInt, CInt, CInt, CString, CInt, Ptr[_], Ptr[_]]

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
}
