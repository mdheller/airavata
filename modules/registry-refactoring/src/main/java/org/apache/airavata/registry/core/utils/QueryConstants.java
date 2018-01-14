package org.apache.airavata.registry.core.utils;

import org.apache.airavata.model.user.UserProfile;

import org.apache.airavata.registry.core.entities.appcatalog.*;

public interface QueryConstants {

    String FIND_USER_PROFILE_BY_USER_ID = "SELECT u FROM UserProfileEntity u " +
            "where u.userId LIKE :" + UserProfile._Fields.USER_ID.getFieldName() + " " +
            "AND u.gatewayId LIKE :"+ UserProfile._Fields.GATEWAY_ID.getFieldName() + "";

    String FIND_ALL_USER_PROFILES_BY_GATEWAY_ID = "SELECT u FROM UserProfileEntity u " +
            "where u.gatewayId LIKE :"+ UserProfile._Fields.GATEWAY_ID.getFieldName() + "";

    String FIND_ALL_GATEWAY_PROFILES = "SELECT G FROM " + GatewayProfileEntity.class.getSimpleName() + " G";
    String FIND_ALL_COMPUTE_RESOURCE_PREFERENCES = "SELECT DISTINCT CR FROM " + ComputeResourcePreferenceEntity.class.getSimpleName() + " CR " +
            "WHERE CR.id.gatewayId LIKE : " + DBConstants.ComputeResourcePreference.GATEWAY_ID;
    String FIND_ALL_STORAGE_RESOURCE_PREFERENCES = "SELECT DISTINCT S FROM " + StoragePreferenceEntity.class.getSimpleName() + " S " +
            "WHERE S.id.gatewayId LIKE : " + DBConstants.StorageResourcePreference.GATEWAY_ID;

    String FIND_COMPUTE_RESOURCE = "SELECT DISTINCT CR FROM " + ComputeResourceEntity.class.getSimpleName() + " CR " +
            "WHERE CR.hostName LIKE : " + DBConstants.ComputeResource.HOST_NAME;
    String FIND_ALL_COMPUTE_RESOURCES = "SELECT CR FROM " + ComputeResourceEntity.class.getSimpleName() + " CR";
    String GET_FILE_SYSTEM = "SELECT DISTINCT FS FROM " + ComputeResourceFileSystemEntity.class.getSimpleName() + " FS " +
            "WHERE FS.computeResourceId LIKE: " + DBConstants.ComputeResource.COMPUTE_RESOURCE_ID;
    String GET_JOB_MANAGER_COMMAND = "SELECT DISTINCT JM FROM " + JobManagerCommandEntity.class.getSimpleName() + " JM " +
            "WHERE JM.id.resourceJobManagerId LIKE: " + DBConstants.ResourceJobManager.RESOURCE_JOB_MANAGER_ID;
    String GET_PARALLELISM_PREFIX = "SELECT DISTINCT PF FROM " + ParallelismCommandEntity.class.getSimpleName() + " PF " +
            "WHERE PF.id.resourceJobManagerId LIKE: " + DBConstants.ResourceJobManager.RESOURCE_JOB_MANAGER_ID;
}
