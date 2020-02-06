#
# Autogenerated by Thrift Compiler (0.10.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thrift.Thrift import TType, TMessageType, TFrozenDict, TException, TApplicationException
from thrift.protocol.TProtocol import TProtocolException
import sys
import airavata.model.application.io.ttypes
import airavata.model.commons.ttypes

from thrift.transport import TTransport


class ApplicationInterfaceDescription(object):
    """
    Application Interface Description

    applicationModules:
      Associate all application modules with versions which interface is applicable to.

    applicationInputs:
      Inputs to be passed to the application

    applicationOutputs:
      Outputs generated from the application


    Attributes:
     - applicationInterfaceId
     - applicationName
     - applicationDescription
     - applicationModules
     - applicationInputs
     - applicationOutputs
     - archiveWorkingDirectory
     - hasOptionalFileInputs
    """

    thrift_spec = (
        None,  # 0
        (1, TType.STRING, 'applicationInterfaceId', 'UTF8', "DO_NOT_SET_AT_CLIENTS", ),  # 1
        (2, TType.STRING, 'applicationName', 'UTF8', None, ),  # 2
        (3, TType.STRING, 'applicationDescription', 'UTF8', None, ),  # 3
        (4, TType.LIST, 'applicationModules', (TType.STRING, 'UTF8', False), None, ),  # 4
        (5, TType.LIST, 'applicationInputs', (TType.STRUCT, (airavata.model.application.io.ttypes.InputDataObjectType, airavata.model.application.io.ttypes.InputDataObjectType.thrift_spec), False), None, ),  # 5
        (6, TType.LIST, 'applicationOutputs', (TType.STRUCT, (airavata.model.application.io.ttypes.OutputDataObjectType, airavata.model.application.io.ttypes.OutputDataObjectType.thrift_spec), False), None, ),  # 6
        (7, TType.BOOL, 'archiveWorkingDirectory', None, False, ),  # 7
        (8, TType.BOOL, 'hasOptionalFileInputs', None, None, ),  # 8
    )

    def __init__(self, applicationInterfaceId=thrift_spec[1][4], applicationName=None, applicationDescription=None, applicationModules=None, applicationInputs=None, applicationOutputs=None, archiveWorkingDirectory=thrift_spec[7][4], hasOptionalFileInputs=None,):
        self.applicationInterfaceId = applicationInterfaceId
        self.applicationName = applicationName
        self.applicationDescription = applicationDescription
        self.applicationModules = applicationModules
        self.applicationInputs = applicationInputs
        self.applicationOutputs = applicationOutputs
        self.archiveWorkingDirectory = archiveWorkingDirectory
        self.hasOptionalFileInputs = hasOptionalFileInputs

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, (self.__class__, self.thrift_spec))
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRING:
                    self.applicationInterfaceId = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRING:
                    self.applicationName = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.STRING:
                    self.applicationDescription = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 4:
                if ftype == TType.LIST:
                    self.applicationModules = []
                    (_etype3, _size0) = iprot.readListBegin()
                    for _i4 in range(_size0):
                        _elem5 = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                        self.applicationModules.append(_elem5)
                    iprot.readListEnd()
                else:
                    iprot.skip(ftype)
            elif fid == 5:
                if ftype == TType.LIST:
                    self.applicationInputs = []
                    (_etype9, _size6) = iprot.readListBegin()
                    for _i10 in range(_size6):
                        _elem11 = airavata.model.application.io.ttypes.InputDataObjectType()
                        _elem11.read(iprot)
                        self.applicationInputs.append(_elem11)
                    iprot.readListEnd()
                else:
                    iprot.skip(ftype)
            elif fid == 6:
                if ftype == TType.LIST:
                    self.applicationOutputs = []
                    (_etype15, _size12) = iprot.readListBegin()
                    for _i16 in range(_size12):
                        _elem17 = airavata.model.application.io.ttypes.OutputDataObjectType()
                        _elem17.read(iprot)
                        self.applicationOutputs.append(_elem17)
                    iprot.readListEnd()
                else:
                    iprot.skip(ftype)
            elif fid == 7:
                if ftype == TType.BOOL:
                    self.archiveWorkingDirectory = iprot.readBool()
                else:
                    iprot.skip(ftype)
            elif fid == 8:
                if ftype == TType.BOOL:
                    self.hasOptionalFileInputs = iprot.readBool()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, (self.__class__, self.thrift_spec)))
            return
        oprot.writeStructBegin('ApplicationInterfaceDescription')
        if self.applicationInterfaceId is not None:
            oprot.writeFieldBegin('applicationInterfaceId', TType.STRING, 1)
            oprot.writeString(self.applicationInterfaceId.encode('utf-8') if sys.version_info[0] == 2 else self.applicationInterfaceId)
            oprot.writeFieldEnd()
        if self.applicationName is not None:
            oprot.writeFieldBegin('applicationName', TType.STRING, 2)
            oprot.writeString(self.applicationName.encode('utf-8') if sys.version_info[0] == 2 else self.applicationName)
            oprot.writeFieldEnd()
        if self.applicationDescription is not None:
            oprot.writeFieldBegin('applicationDescription', TType.STRING, 3)
            oprot.writeString(self.applicationDescription.encode('utf-8') if sys.version_info[0] == 2 else self.applicationDescription)
            oprot.writeFieldEnd()
        if self.applicationModules is not None:
            oprot.writeFieldBegin('applicationModules', TType.LIST, 4)
            oprot.writeListBegin(TType.STRING, len(self.applicationModules))
            for iter18 in self.applicationModules:
                oprot.writeString(iter18.encode('utf-8') if sys.version_info[0] == 2 else iter18)
            oprot.writeListEnd()
            oprot.writeFieldEnd()
        if self.applicationInputs is not None:
            oprot.writeFieldBegin('applicationInputs', TType.LIST, 5)
            oprot.writeListBegin(TType.STRUCT, len(self.applicationInputs))
            for iter19 in self.applicationInputs:
                iter19.write(oprot)
            oprot.writeListEnd()
            oprot.writeFieldEnd()
        if self.applicationOutputs is not None:
            oprot.writeFieldBegin('applicationOutputs', TType.LIST, 6)
            oprot.writeListBegin(TType.STRUCT, len(self.applicationOutputs))
            for iter20 in self.applicationOutputs:
                iter20.write(oprot)
            oprot.writeListEnd()
            oprot.writeFieldEnd()
        if self.archiveWorkingDirectory is not None:
            oprot.writeFieldBegin('archiveWorkingDirectory', TType.BOOL, 7)
            oprot.writeBool(self.archiveWorkingDirectory)
            oprot.writeFieldEnd()
        if self.hasOptionalFileInputs is not None:
            oprot.writeFieldBegin('hasOptionalFileInputs', TType.BOOL, 8)
            oprot.writeBool(self.hasOptionalFileInputs)
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        if self.applicationInterfaceId is None:
            raise TProtocolException(message='Required field applicationInterfaceId is unset!')
        if self.applicationName is None:
            raise TProtocolException(message='Required field applicationName is unset!')
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
