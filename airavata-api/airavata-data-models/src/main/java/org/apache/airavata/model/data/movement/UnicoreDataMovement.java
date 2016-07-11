/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.data.movement;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Data Movement through UnicoreStorage
 * 
 * unicoreEndPointURL:
 *  unicoreGateway End Point. The provider will query this service to fetch required service end points.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-07-11")
public class UnicoreDataMovement implements org.apache.thrift.TBase<UnicoreDataMovement, UnicoreDataMovement._Fields>, java.io.Serializable, Cloneable, Comparable<UnicoreDataMovement> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UnicoreDataMovement");

  private static final org.apache.thrift.protocol.TField DATA_MOVEMENT_INTERFACE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("dataMovementInterfaceId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SECURITY_PROTOCOL_FIELD_DESC = new org.apache.thrift.protocol.TField("securityProtocol", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField UNICORE_END_POINT_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("unicoreEndPointURL", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UnicoreDataMovementStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UnicoreDataMovementTupleSchemeFactory());
  }

  private String dataMovementInterfaceId; // required
  private SecurityProtocol securityProtocol; // required
  private String unicoreEndPointURL; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DATA_MOVEMENT_INTERFACE_ID((short)1, "dataMovementInterfaceId"),
    /**
     * 
     * @see SecurityProtocol
     */
    SECURITY_PROTOCOL((short)2, "securityProtocol"),
    UNICORE_END_POINT_URL((short)3, "unicoreEndPointURL");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DATA_MOVEMENT_INTERFACE_ID
          return DATA_MOVEMENT_INTERFACE_ID;
        case 2: // SECURITY_PROTOCOL
          return SECURITY_PROTOCOL;
        case 3: // UNICORE_END_POINT_URL
          return UNICORE_END_POINT_URL;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DATA_MOVEMENT_INTERFACE_ID, new org.apache.thrift.meta_data.FieldMetaData("dataMovementInterfaceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SECURITY_PROTOCOL, new org.apache.thrift.meta_data.FieldMetaData("securityProtocol", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, SecurityProtocol.class)));
    tmpMap.put(_Fields.UNICORE_END_POINT_URL, new org.apache.thrift.meta_data.FieldMetaData("unicoreEndPointURL", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UnicoreDataMovement.class, metaDataMap);
  }

  public UnicoreDataMovement() {
    this.dataMovementInterfaceId = "DO_NOT_SET_AT_CLIENTS";

  }

  public UnicoreDataMovement(
    String dataMovementInterfaceId,
    SecurityProtocol securityProtocol,
    String unicoreEndPointURL)
  {
    this();
    this.dataMovementInterfaceId = dataMovementInterfaceId;
    this.securityProtocol = securityProtocol;
    this.unicoreEndPointURL = unicoreEndPointURL;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UnicoreDataMovement(UnicoreDataMovement other) {
    if (other.isSetDataMovementInterfaceId()) {
      this.dataMovementInterfaceId = other.dataMovementInterfaceId;
    }
    if (other.isSetSecurityProtocol()) {
      this.securityProtocol = other.securityProtocol;
    }
    if (other.isSetUnicoreEndPointURL()) {
      this.unicoreEndPointURL = other.unicoreEndPointURL;
    }
  }

  public UnicoreDataMovement deepCopy() {
    return new UnicoreDataMovement(this);
  }

  @Override
  public void clear() {
    this.dataMovementInterfaceId = "DO_NOT_SET_AT_CLIENTS";

    this.securityProtocol = null;
    this.unicoreEndPointURL = null;
  }

  public String getDataMovementInterfaceId() {
    return this.dataMovementInterfaceId;
  }

  public void setDataMovementInterfaceId(String dataMovementInterfaceId) {
    this.dataMovementInterfaceId = dataMovementInterfaceId;
  }

  public void unsetDataMovementInterfaceId() {
    this.dataMovementInterfaceId = null;
  }

  /** Returns true if field dataMovementInterfaceId is set (has been assigned a value) and false otherwise */
  public boolean isSetDataMovementInterfaceId() {
    return this.dataMovementInterfaceId != null;
  }

  public void setDataMovementInterfaceIdIsSet(boolean value) {
    if (!value) {
      this.dataMovementInterfaceId = null;
    }
  }

  /**
   * 
   * @see SecurityProtocol
   */
  public SecurityProtocol getSecurityProtocol() {
    return this.securityProtocol;
  }

  /**
   * 
   * @see SecurityProtocol
   */
  public void setSecurityProtocol(SecurityProtocol securityProtocol) {
    this.securityProtocol = securityProtocol;
  }

  public void unsetSecurityProtocol() {
    this.securityProtocol = null;
  }

  /** Returns true if field securityProtocol is set (has been assigned a value) and false otherwise */
  public boolean isSetSecurityProtocol() {
    return this.securityProtocol != null;
  }

  public void setSecurityProtocolIsSet(boolean value) {
    if (!value) {
      this.securityProtocol = null;
    }
  }

  public String getUnicoreEndPointURL() {
    return this.unicoreEndPointURL;
  }

  public void setUnicoreEndPointURL(String unicoreEndPointURL) {
    this.unicoreEndPointURL = unicoreEndPointURL;
  }

  public void unsetUnicoreEndPointURL() {
    this.unicoreEndPointURL = null;
  }

  /** Returns true if field unicoreEndPointURL is set (has been assigned a value) and false otherwise */
  public boolean isSetUnicoreEndPointURL() {
    return this.unicoreEndPointURL != null;
  }

  public void setUnicoreEndPointURLIsSet(boolean value) {
    if (!value) {
      this.unicoreEndPointURL = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DATA_MOVEMENT_INTERFACE_ID:
      if (value == null) {
        unsetDataMovementInterfaceId();
      } else {
        setDataMovementInterfaceId((String)value);
      }
      break;

    case SECURITY_PROTOCOL:
      if (value == null) {
        unsetSecurityProtocol();
      } else {
        setSecurityProtocol((SecurityProtocol)value);
      }
      break;

    case UNICORE_END_POINT_URL:
      if (value == null) {
        unsetUnicoreEndPointURL();
      } else {
        setUnicoreEndPointURL((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DATA_MOVEMENT_INTERFACE_ID:
      return getDataMovementInterfaceId();

    case SECURITY_PROTOCOL:
      return getSecurityProtocol();

    case UNICORE_END_POINT_URL:
      return getUnicoreEndPointURL();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DATA_MOVEMENT_INTERFACE_ID:
      return isSetDataMovementInterfaceId();
    case SECURITY_PROTOCOL:
      return isSetSecurityProtocol();
    case UNICORE_END_POINT_URL:
      return isSetUnicoreEndPointURL();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UnicoreDataMovement)
      return this.equals((UnicoreDataMovement)that);
    return false;
  }

  public boolean equals(UnicoreDataMovement that) {
    if (that == null)
      return false;

    boolean this_present_dataMovementInterfaceId = true && this.isSetDataMovementInterfaceId();
    boolean that_present_dataMovementInterfaceId = true && that.isSetDataMovementInterfaceId();
    if (this_present_dataMovementInterfaceId || that_present_dataMovementInterfaceId) {
      if (!(this_present_dataMovementInterfaceId && that_present_dataMovementInterfaceId))
        return false;
      if (!this.dataMovementInterfaceId.equals(that.dataMovementInterfaceId))
        return false;
    }

    boolean this_present_securityProtocol = true && this.isSetSecurityProtocol();
    boolean that_present_securityProtocol = true && that.isSetSecurityProtocol();
    if (this_present_securityProtocol || that_present_securityProtocol) {
      if (!(this_present_securityProtocol && that_present_securityProtocol))
        return false;
      if (!this.securityProtocol.equals(that.securityProtocol))
        return false;
    }

    boolean this_present_unicoreEndPointURL = true && this.isSetUnicoreEndPointURL();
    boolean that_present_unicoreEndPointURL = true && that.isSetUnicoreEndPointURL();
    if (this_present_unicoreEndPointURL || that_present_unicoreEndPointURL) {
      if (!(this_present_unicoreEndPointURL && that_present_unicoreEndPointURL))
        return false;
      if (!this.unicoreEndPointURL.equals(that.unicoreEndPointURL))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_dataMovementInterfaceId = true && (isSetDataMovementInterfaceId());
    list.add(present_dataMovementInterfaceId);
    if (present_dataMovementInterfaceId)
      list.add(dataMovementInterfaceId);

    boolean present_securityProtocol = true && (isSetSecurityProtocol());
    list.add(present_securityProtocol);
    if (present_securityProtocol)
      list.add(securityProtocol.getValue());

    boolean present_unicoreEndPointURL = true && (isSetUnicoreEndPointURL());
    list.add(present_unicoreEndPointURL);
    if (present_unicoreEndPointURL)
      list.add(unicoreEndPointURL);

    return list.hashCode();
  }

  @Override
  public int compareTo(UnicoreDataMovement other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDataMovementInterfaceId()).compareTo(other.isSetDataMovementInterfaceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDataMovementInterfaceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dataMovementInterfaceId, other.dataMovementInterfaceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSecurityProtocol()).compareTo(other.isSetSecurityProtocol());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSecurityProtocol()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.securityProtocol, other.securityProtocol);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUnicoreEndPointURL()).compareTo(other.isSetUnicoreEndPointURL());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUnicoreEndPointURL()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.unicoreEndPointURL, other.unicoreEndPointURL);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UnicoreDataMovement(");
    boolean first = true;

    sb.append("dataMovementInterfaceId:");
    if (this.dataMovementInterfaceId == null) {
      sb.append("null");
    } else {
      sb.append(this.dataMovementInterfaceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("securityProtocol:");
    if (this.securityProtocol == null) {
      sb.append("null");
    } else {
      sb.append(this.securityProtocol);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("unicoreEndPointURL:");
    if (this.unicoreEndPointURL == null) {
      sb.append("null");
    } else {
      sb.append(this.unicoreEndPointURL);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetDataMovementInterfaceId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dataMovementInterfaceId' is unset! Struct:" + toString());
    }

    if (!isSetSecurityProtocol()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'securityProtocol' is unset! Struct:" + toString());
    }

    if (!isSetUnicoreEndPointURL()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'unicoreEndPointURL' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UnicoreDataMovementStandardSchemeFactory implements SchemeFactory {
    public UnicoreDataMovementStandardScheme getScheme() {
      return new UnicoreDataMovementStandardScheme();
    }
  }

  private static class UnicoreDataMovementStandardScheme extends StandardScheme<UnicoreDataMovement> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UnicoreDataMovement struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DATA_MOVEMENT_INTERFACE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dataMovementInterfaceId = iprot.readString();
              struct.setDataMovementInterfaceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SECURITY_PROTOCOL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.securityProtocol = org.apache.airavata.model.data.movement.SecurityProtocol.findByValue(iprot.readI32());
              struct.setSecurityProtocolIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // UNICORE_END_POINT_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.unicoreEndPointURL = iprot.readString();
              struct.setUnicoreEndPointURLIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UnicoreDataMovement struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.dataMovementInterfaceId != null) {
        oprot.writeFieldBegin(DATA_MOVEMENT_INTERFACE_ID_FIELD_DESC);
        oprot.writeString(struct.dataMovementInterfaceId);
        oprot.writeFieldEnd();
      }
      if (struct.securityProtocol != null) {
        oprot.writeFieldBegin(SECURITY_PROTOCOL_FIELD_DESC);
        oprot.writeI32(struct.securityProtocol.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.unicoreEndPointURL != null) {
        oprot.writeFieldBegin(UNICORE_END_POINT_URL_FIELD_DESC);
        oprot.writeString(struct.unicoreEndPointURL);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UnicoreDataMovementTupleSchemeFactory implements SchemeFactory {
    public UnicoreDataMovementTupleScheme getScheme() {
      return new UnicoreDataMovementTupleScheme();
    }
  }

  private static class UnicoreDataMovementTupleScheme extends TupleScheme<UnicoreDataMovement> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UnicoreDataMovement struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.dataMovementInterfaceId);
      oprot.writeI32(struct.securityProtocol.getValue());
      oprot.writeString(struct.unicoreEndPointURL);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UnicoreDataMovement struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.dataMovementInterfaceId = iprot.readString();
      struct.setDataMovementInterfaceIdIsSet(true);
      struct.securityProtocol = org.apache.airavata.model.data.movement.SecurityProtocol.findByValue(iprot.readI32());
      struct.setSecurityProtocolIsSet(true);
      struct.unicoreEndPointURL = iprot.readString();
      struct.setUnicoreEndPointURLIsSet(true);
    }
  }

}

