    /*
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
package org.apache.airavata.credential.store.datamodel;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2015-12-21")
public class APICredential implements org.apache.thrift.TBase<APICredential, APICredential._Fields>, java.io.Serializable, Cloneable, Comparable<APICredential> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("APICredential");

  private static final org.apache.thrift.protocol.TField API_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("apiKey", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField API_SECRET_FIELD_DESC = new org.apache.thrift.protocol.TField("apiSecret", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PERSISTED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("persistedTime", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("token", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new APICredentialStandardSchemeFactory());
    schemes.put(TupleScheme.class, new APICredentialTupleSchemeFactory());
  }

  public String apiKey; // required
  public String apiSecret; // required
  public long persistedTime; // optional
  public String token; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    API_KEY((short)1, "apiKey"),
    API_SECRET((short)2, "apiSecret"),
    PERSISTED_TIME((short)3, "persistedTime"),
    TOKEN((short)4, "token");

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
        case 1: // API_KEY
          return API_KEY;
        case 2: // API_SECRET
          return API_SECRET;
        case 3: // PERSISTED_TIME
          return PERSISTED_TIME;
        case 4: // TOKEN
          return TOKEN;
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
  private static final int __PERSISTEDTIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PERSISTED_TIME,_Fields.TOKEN};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.API_KEY, new org.apache.thrift.meta_data.FieldMetaData("apiKey", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.API_SECRET, new org.apache.thrift.meta_data.FieldMetaData("apiSecret", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PERSISTED_TIME, new org.apache.thrift.meta_data.FieldMetaData("persistedTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TOKEN, new org.apache.thrift.meta_data.FieldMetaData("token", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(APICredential.class, metaDataMap);
  }

  public APICredential() {
  }

  public APICredential(
    String apiKey,
    String apiSecret)
  {
    this();
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public APICredential(APICredential other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetApiKey()) {
      this.apiKey = other.apiKey;
    }
    if (other.isSetApiSecret()) {
      this.apiSecret = other.apiSecret;
    }
    this.persistedTime = other.persistedTime;
    if (other.isSetToken()) {
      this.token = other.token;
    }
  }

  public APICredential deepCopy() {
    return new APICredential(this);
  }

  @Override
  public void clear() {
    this.apiKey = null;
    this.apiSecret = null;
    setPersistedTimeIsSet(false);
    this.persistedTime = 0;
    this.token = null;
  }

  public String getApiKey() {
    return this.apiKey;
  }

  public APICredential setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  public void unsetApiKey() {
    this.apiKey = null;
  }

  /** Returns true if field apiKey is set (has been assigned a value) and false otherwise */
  public boolean isSetApiKey() {
    return this.apiKey != null;
  }

  public void setApiKeyIsSet(boolean value) {
    if (!value) {
      this.apiKey = null;
    }
  }

  public String getApiSecret() {
    return this.apiSecret;
  }

  public APICredential setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
    return this;
  }

  public void unsetApiSecret() {
    this.apiSecret = null;
  }

  /** Returns true if field apiSecret is set (has been assigned a value) and false otherwise */
  public boolean isSetApiSecret() {
    return this.apiSecret != null;
  }

  public void setApiSecretIsSet(boolean value) {
    if (!value) {
      this.apiSecret = null;
    }
  }

  public long getPersistedTime() {
    return this.persistedTime;
  }

  public APICredential setPersistedTime(long persistedTime) {
    this.persistedTime = persistedTime;
    setPersistedTimeIsSet(true);
    return this;
  }

  public void unsetPersistedTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PERSISTEDTIME_ISSET_ID);
  }

  /** Returns true if field persistedTime is set (has been assigned a value) and false otherwise */
  public boolean isSetPersistedTime() {
    return EncodingUtils.testBit(__isset_bitfield, __PERSISTEDTIME_ISSET_ID);
  }

  public void setPersistedTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PERSISTEDTIME_ISSET_ID, value);
  }

  public String getToken() {
    return this.token;
  }

  public APICredential setToken(String token) {
    this.token = token;
    return this;
  }

  public void unsetToken() {
    this.token = null;
  }

  /** Returns true if field token is set (has been assigned a value) and false otherwise */
  public boolean isSetToken() {
    return this.token != null;
  }

  public void setTokenIsSet(boolean value) {
    if (!value) {
      this.token = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case API_KEY:
      if (value == null) {
        unsetApiKey();
      } else {
        setApiKey((String)value);
      }
      break;

    case API_SECRET:
      if (value == null) {
        unsetApiSecret();
      } else {
        setApiSecret((String)value);
      }
      break;

    case PERSISTED_TIME:
      if (value == null) {
        unsetPersistedTime();
      } else {
        setPersistedTime((Long)value);
      }
      break;

    case TOKEN:
      if (value == null) {
        unsetToken();
      } else {
        setToken((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case API_KEY:
      return getApiKey();

    case API_SECRET:
      return getApiSecret();

    case PERSISTED_TIME:
      return getPersistedTime();

    case TOKEN:
      return getToken();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case API_KEY:
      return isSetApiKey();
    case API_SECRET:
      return isSetApiSecret();
    case PERSISTED_TIME:
      return isSetPersistedTime();
    case TOKEN:
      return isSetToken();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof APICredential)
      return this.equals((APICredential)that);
    return false;
  }

  public boolean equals(APICredential that) {
    if (that == null)
      return false;

    boolean this_present_apiKey = true && this.isSetApiKey();
    boolean that_present_apiKey = true && that.isSetApiKey();
    if (this_present_apiKey || that_present_apiKey) {
      if (!(this_present_apiKey && that_present_apiKey))
        return false;
      if (!this.apiKey.equals(that.apiKey))
        return false;
    }

    boolean this_present_apiSecret = true && this.isSetApiSecret();
    boolean that_present_apiSecret = true && that.isSetApiSecret();
    if (this_present_apiSecret || that_present_apiSecret) {
      if (!(this_present_apiSecret && that_present_apiSecret))
        return false;
      if (!this.apiSecret.equals(that.apiSecret))
        return false;
    }

    boolean this_present_persistedTime = true && this.isSetPersistedTime();
    boolean that_present_persistedTime = true && that.isSetPersistedTime();
    if (this_present_persistedTime || that_present_persistedTime) {
      if (!(this_present_persistedTime && that_present_persistedTime))
        return false;
      if (this.persistedTime != that.persistedTime)
        return false;
    }

    boolean this_present_token = true && this.isSetToken();
    boolean that_present_token = true && that.isSetToken();
    if (this_present_token || that_present_token) {
      if (!(this_present_token && that_present_token))
        return false;
      if (!this.token.equals(that.token))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_apiKey = true && (isSetApiKey());
    list.add(present_apiKey);
    if (present_apiKey)
      list.add(apiKey);

    boolean present_apiSecret = true && (isSetApiSecret());
    list.add(present_apiSecret);
    if (present_apiSecret)
      list.add(apiSecret);

    boolean present_persistedTime = true && (isSetPersistedTime());
    list.add(present_persistedTime);
    if (present_persistedTime)
      list.add(persistedTime);

    boolean present_token = true && (isSetToken());
    list.add(present_token);
    if (present_token)
      list.add(token);

    return list.hashCode();
  }

  @Override
  public int compareTo(APICredential other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetApiKey()).compareTo(other.isSetApiKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApiKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.apiKey, other.apiKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApiSecret()).compareTo(other.isSetApiSecret());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApiSecret()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.apiSecret, other.apiSecret);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPersistedTime()).compareTo(other.isSetPersistedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPersistedTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.persistedTime, other.persistedTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetToken()).compareTo(other.isSetToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.token, other.token);
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
    StringBuilder sb = new StringBuilder("APICredential(");
    boolean first = true;

    sb.append("apiKey:");
    if (this.apiKey == null) {
      sb.append("null");
    } else {
      sb.append(this.apiKey);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("apiSecret:");
    if (this.apiSecret == null) {
      sb.append("null");
    } else {
      sb.append(this.apiSecret);
    }
    first = false;
    if (isSetPersistedTime()) {
      if (!first) sb.append(", ");
      sb.append("persistedTime:");
      sb.append(this.persistedTime);
      first = false;
    }
    if (isSetToken()) {
      if (!first) sb.append(", ");
      sb.append("token:");
      if (this.token == null) {
        sb.append("null");
      } else {
        sb.append(this.token);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (apiKey == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'apiKey' was not present! Struct: " + toString());
    }
    if (apiSecret == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'apiSecret' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class APICredentialStandardSchemeFactory implements SchemeFactory {
    public APICredentialStandardScheme getScheme() {
      return new APICredentialStandardScheme();
    }
  }

  private static class APICredentialStandardScheme extends StandardScheme<APICredential> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, APICredential struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // API_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.apiKey = iprot.readString();
              struct.setApiKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // API_SECRET
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.apiSecret = iprot.readString();
              struct.setApiSecretIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PERSISTED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.persistedTime = iprot.readI64();
              struct.setPersistedTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.token = iprot.readString();
              struct.setTokenIsSet(true);
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

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, APICredential struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.apiKey != null) {
        oprot.writeFieldBegin(API_KEY_FIELD_DESC);
        oprot.writeString(struct.apiKey);
        oprot.writeFieldEnd();
      }
      if (struct.apiSecret != null) {
        oprot.writeFieldBegin(API_SECRET_FIELD_DESC);
        oprot.writeString(struct.apiSecret);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPersistedTime()) {
        oprot.writeFieldBegin(PERSISTED_TIME_FIELD_DESC);
        oprot.writeI64(struct.persistedTime);
        oprot.writeFieldEnd();
      }
      if (struct.token != null) {
        if (struct.isSetToken()) {
          oprot.writeFieldBegin(TOKEN_FIELD_DESC);
          oprot.writeString(struct.token);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class APICredentialTupleSchemeFactory implements SchemeFactory {
    public APICredentialTupleScheme getScheme() {
      return new APICredentialTupleScheme();
    }
  }

  private static class APICredentialTupleScheme extends TupleScheme<APICredential> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, APICredential struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.apiKey);
      oprot.writeString(struct.apiSecret);
      BitSet optionals = new BitSet();
      if (struct.isSetPersistedTime()) {
        optionals.set(0);
      }
      if (struct.isSetToken()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetPersistedTime()) {
        oprot.writeI64(struct.persistedTime);
      }
      if (struct.isSetToken()) {
        oprot.writeString(struct.token);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, APICredential struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.apiKey = iprot.readString();
      struct.setApiKeyIsSet(true);
      struct.apiSecret = iprot.readString();
      struct.setApiSecretIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.persistedTime = iprot.readI64();
        struct.setPersistedTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.token = iprot.readString();
        struct.setTokenIsSet(true);
      }
    }
  }

}

