package org.apache.airavata.registry.core.repositories.appcatalog;

import org.apache.airavata.model.appcatalog.computeresource.*;
import org.apache.airavata.model.data.movement.*;
import org.apache.airavata.model.data.movement.DMType;
import org.apache.airavata.model.parallelism.ApplicationParallelismType;
import org.apache.airavata.registry.core.entities.appcatalog.*;
import org.apache.airavata.registry.core.utils.AppCatalogUtils;
import org.apache.airavata.registry.core.utils.DBConstants;
import org.apache.airavata.registry.core.utils.ObjectMapperSingleton;
import org.apache.airavata.registry.core.utils.QueryConstants;
import org.apache.airavata.registry.cpi.AppCatalogException;
import org.apache.airavata.registry.cpi.ComputeResource;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeResourceRepository extends AppCatAbstractRepository<ComputeResourceDescription, ComputeResourceEntity, String> implements ComputeResource {

    private final static Logger logger = LoggerFactory.getLogger(ComputeResourceRepository.class);


    public ComputeResourceRepository() {
        super(ComputeResourceDescription.class, ComputeResourceEntity.class);
    }

    @Override
    public String addComputeResource(ComputeResourceDescription description) throws AppCatalogException {
        if (description.getComputeResourceId().equals("") || description.getComputeResourceId().equals(compute_resource_modelConstants.DEFAULT_ID)){
            description.setComputeResourceId(AppCatalogUtils.getID(description.getHostName()));
        }
        return saveComputeResourceDescriptorData(description);
    }

    protected String saveComputeResourceDescriptorData(
            ComputeResourceDescription description) throws AppCatalogException {
        //TODO remove existing one
        ComputeResourceEntity computeResourceEntity = saveComputeResource(description);
        saveFileSystems(description, computeResourceEntity);
        return computeResourceEntity.getComputeResourceId();
    }

    protected ComputeResourceEntity saveComputeResource(
            ComputeResourceDescription description) throws AppCatalogException {
        String computeResourceId = description.getComputeResourceId();
        Mapper mapper = ObjectMapperSingleton.getInstance();
        ComputeResourceEntity computeResourceEntity = mapper.map(description, ComputeResourceEntity.class);
        if (computeResourceEntity.getBatchQueues() != null) {
            computeResourceEntity.getBatchQueues().forEach(batchQueueEntity -> batchQueueEntity.setComputeResourceId(computeResourceId));
        }
        if (computeResourceEntity.getDataMovementInterfaces() != null) {
            computeResourceEntity.getDataMovementInterfaces().forEach(dataMovementInterfaceEntity -> dataMovementInterfaceEntity.setComputeResourceId(computeResourceId));
        }
        if (computeResourceEntity.getJobSubmissionInterfaces() != null) {
            computeResourceEntity.getJobSubmissionInterfaces().forEach(jobSubmissionInterfaceEntity -> jobSubmissionInterfaceEntity.setComputeResourceId(computeResourceId));
        }
        return execute(entityManager -> entityManager.merge(computeResourceEntity));
    }

    protected void saveFileSystems(ComputeResourceDescription description,
                                   ComputeResourceEntity computeHostResource)
            throws AppCatalogException {
        Map<FileSystems, String> fileSystems = description.getFileSystems();
        if (fileSystems != null && !fileSystems.isEmpty()) {
            for (FileSystems key : fileSystems.keySet()) {
                ComputeResourceFileSystemEntity computeResourceFileSystemEntity = new ComputeResourceFileSystemEntity();
                computeResourceFileSystemEntity.setComputeResourceId(computeHostResource.getComputeResourceId());
                computeResourceFileSystemEntity.setFileSystem(key.toString());
                computeResourceFileSystemEntity.setPath(fileSystems.get(key));
                computeResourceFileSystemEntity.setComputeResource(computeHostResource);
                execute(entityManager -> entityManager.merge(computeResourceFileSystemEntity));
            }
        }
    }

    protected Map<FileSystems, String> getFileSystems(String computeResourceId) {
        Map<String,Object> queryParameters = new HashMap<>();
        queryParameters.put(DBConstants.ComputeResource.COMPUTE_RESOURCE_ID, computeResourceId);

        List resultSet = (List) execute(entityManager -> {
            Query jpaQuery = entityManager.createQuery(QueryConstants.GET_FILE_SYSTEM);
            for (Map.Entry<String, Object> entry : queryParameters.entrySet()) {
                jpaQuery.setParameter(entry.getKey(), entry.getValue());
            }
            return jpaQuery.setFirstResult(0).getResultList();
        });

        List<ComputeResourceFileSystemEntity> computeResourceFileSystemEntityList = resultSet;
        Map<FileSystems, String> fileSystemsMap= new HashMap<FileSystems,String>();
        for (ComputeResourceFileSystemEntity fs: computeResourceFileSystemEntityList) {
            fileSystemsMap.put(FileSystems.valueOf(fs.getFileSystem()), fs.getPath());
        }
        return fileSystemsMap;
    }

    @Override
    public void updateComputeResource(String computeResourceId, ComputeResourceDescription updatedComputeResource) throws AppCatalogException {
            saveComputeResourceDescriptorData(updatedComputeResource);
    }

    @Override
    public ComputeResourceDescription getComputeResource(String resourceId) throws AppCatalogException {
        ComputeResourceDescription computeResourceDescription = get(resourceId);
        computeResourceDescription.setFileSystems(getFileSystems(resourceId));
        return computeResourceDescription;
    }

    @Override
    public List<ComputeResourceDescription> getComputeResourceList(Map<String, String> filters) throws AppCatalogException {
        if (filters.containsKey(DBConstants.ComputeResource.HOST_NAME)) {
            Map<String,Object> queryParameters = new HashMap<>();
            queryParameters.put(DBConstants.ComputeResource.HOST_NAME, filters.get(DBConstants.ComputeResource.HOST_NAME));
            List<ComputeResourceDescription> computeResourceDescriptionList = select(QueryConstants.FIND_COMPUTE_RESOURCE, -1, 0, queryParameters);
            for (ComputeResourceDescription cd: computeResourceDescriptionList) {
                cd.setFileSystems(getFileSystems(cd.getComputeResourceId()));
            }
            return computeResourceDescriptionList;
        }
        else {
            logger.error("Unsupported field name for compute resource.", new IllegalArgumentException());
            throw new IllegalArgumentException("Unsupported field name for compute resource.");
        }
    }

    @Override
    public List<ComputeResourceDescription> getAllComputeResourceList() throws AppCatalogException {
        List<ComputeResourceDescription> computeResourceDescriptionList =  select(QueryConstants.FIND_ALL_COMPUTE_RESOURCES, 0);
        for (ComputeResourceDescription cd: computeResourceDescriptionList) {
            cd.setFileSystems(getFileSystems(cd.getComputeResourceId()));
        }
        return computeResourceDescriptionList;
    }

    @Override
    public Map<String, String> getAllComputeResourceIdList() throws AppCatalogException {
        Map<String, String> computeResourceMap = new HashMap<String, String>();
        List<ComputeResourceDescription> computeResourceDescriptionList = select(QueryConstants.FIND_ALL_COMPUTE_RESOURCES, 0);
        if (computeResourceDescriptionList != null && !computeResourceDescriptionList.isEmpty()) {
            for (ComputeResourceDescription computeResourceDescription: computeResourceDescriptionList) {
                computeResourceMap.put(computeResourceDescription.getComputeResourceId(), computeResourceDescription.getHostName());
            }
        }
        return computeResourceMap;
    }

    @Override
    public Map<String, String> getAvailableComputeResourceIdList() throws AppCatalogException {
        Map<String, String> computeResourceMap = new HashMap<String, String>();
        List<ComputeResourceDescription> computeResourceDescriptionList = select(QueryConstants.FIND_ALL_COMPUTE_RESOURCES, 0);
        if (computeResourceDescriptionList != null && !computeResourceDescriptionList.isEmpty()) {
            for (ComputeResourceDescription computeResourceDescription : computeResourceDescriptionList) {
                if (computeResourceDescription.isEnabled()){
                    computeResourceMap.put(computeResourceDescription.getComputeResourceId(), computeResourceDescription.getHostName());
                }
            }
        }
        return computeResourceMap;
    }

    @Override
    public boolean isComputeResourceExists(String resourceId) throws AppCatalogException {
        return isExists(resourceId);
    }

    @Override
    public void removeComputeResource(String resourceId) throws AppCatalogException {
        delete(resourceId);
    }

    @Override
    public String addSSHJobSubmission(SSHJobSubmission sshJobSubmission) throws AppCatalogException {
        String submissionId = AppCatalogUtils.getID("SSH");
        sshJobSubmission.setJobSubmissionInterfaceId(submissionId);
        String resourceJobManagerId = addResourceJobManager(sshJobSubmission.getResourceJobManager());
        Mapper mapper = ObjectMapperSingleton.getInstance();
        SshJobSubmissionEntity sshJobSubmissionEntity = mapper.map(sshJobSubmission, SshJobSubmissionEntity.class);
        sshJobSubmissionEntity.setResourceJobManagerId(resourceJobManagerId);
        sshJobSubmissionEntity.getResourceJobManager().setResourceJobManagerId(resourceJobManagerId);
        if (sshJobSubmission.getResourceJobManager().getParallelismPrefix() != null) {
            (new ResourceJobManagerRepository()).createParallesimPrefix(sshJobSubmission.getResourceJobManager().getParallelismPrefix(), sshJobSubmissionEntity.getResourceJobManager());
        }
        if (sshJobSubmission.getResourceJobManager().getJobManagerCommands() != null) {
            (new ResourceJobManagerRepository()).createJobManagerCommand(sshJobSubmission.getResourceJobManager().getJobManagerCommands(), sshJobSubmissionEntity.getResourceJobManager());
        }
        if (sshJobSubmission.getMonitorMode() != null){
            sshJobSubmissionEntity.setMonitorMode(sshJobSubmission.getMonitorMode().toString());
        }
        execute(entityManager -> entityManager.merge(sshJobSubmissionEntity));
        return submissionId;
    }

    @Override
    public String addCloudJobSubmission(CloudJobSubmission cloudJobSubmission) throws AppCatalogException {
        cloudJobSubmission.setJobSubmissionInterfaceId(AppCatalogUtils.getID("Cloud"));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        CloudJobSubmissionEntity cloudJobSubmissionEntity = mapper.map(cloudJobSubmission, CloudJobSubmissionEntity.class);
        execute(entityManager -> entityManager.merge(cloudJobSubmissionEntity));
        return cloudJobSubmissionEntity.getJobSubmissionInterfaceId();
    }

    @Override
    public String addResourceJobManager(ResourceJobManager resourceJobManager) throws AppCatalogException {
        ResourceJobManagerRepository resourceJobManagerRepository = new ResourceJobManagerRepository();
        resourceJobManager.setResourceJobManagerId(AppCatalogUtils.getID("RJM"));
        resourceJobManagerRepository.create(resourceJobManager);
        Mapper mapper = ObjectMapperSingleton.getInstance();
        ResourceJobManagerEntity resourceJobManagerEntity = mapper.map(resourceJobManager, ResourceJobManagerEntity.class);
        Map<JobManagerCommand, String> jobManagerCommands = resourceJobManager.getJobManagerCommands();
        if (jobManagerCommands!=null && jobManagerCommands.size() != 0) {
            resourceJobManagerRepository.createJobManagerCommand(jobManagerCommands, resourceJobManagerEntity);
        }

        Map<ApplicationParallelismType, String> parallelismPrefix = resourceJobManager.getParallelismPrefix();
        if (parallelismPrefix!=null && parallelismPrefix.size() != 0) {
            resourceJobManagerRepository.createParallesimPrefix(parallelismPrefix, resourceJobManagerEntity);
        }
        return resourceJobManager.getResourceJobManagerId();
    }

    @Override
    public void updateResourceJobManager(String resourceJobManagerId, ResourceJobManager updatedResourceJobManager) throws AppCatalogException {
        ResourceJobManagerRepository resourceJobManagerRepository = new ResourceJobManagerRepository();
        updatedResourceJobManager.setResourceJobManagerId(resourceJobManagerId);
        ResourceJobManager resourceJobManager = resourceJobManagerRepository.create(updatedResourceJobManager);
        Mapper mapper = ObjectMapperSingleton.getInstance();
        ResourceJobManagerEntity resourceJobManagerEntity = mapper.map(resourceJobManager, ResourceJobManagerEntity.class);
        Map<JobManagerCommand, String> jobManagerCommands = updatedResourceJobManager.getJobManagerCommands();
        if (jobManagerCommands!=null && jobManagerCommands.size() != 0) {
            resourceJobManagerRepository.createJobManagerCommand(jobManagerCommands, resourceJobManagerEntity);
        }

        Map<ApplicationParallelismType, String> parallelismPrefix = updatedResourceJobManager.getParallelismPrefix();
        if (parallelismPrefix!=null && parallelismPrefix.size() != 0) {
            resourceJobManagerRepository.createParallesimPrefix(parallelismPrefix, resourceJobManagerEntity);
        }
    }

    @Override
    public ResourceJobManager getResourceJobManager(String resourceJobManagerId) throws AppCatalogException {
        ResourceJobManagerRepository resourceJobManagerRepository = new ResourceJobManagerRepository();
        ResourceJobManager resourceJobManager = resourceJobManagerRepository.get(resourceJobManagerId);
        resourceJobManager.setJobManagerCommands(resourceJobManagerRepository.getJobManagerCommand(resourceJobManagerId));
        resourceJobManager.setParallelismPrefix(resourceJobManagerRepository.getParallelismPrefix(resourceJobManagerId));
        return resourceJobManager;
    }

    @Override
    public void deleteResourceJobManager(String resourceJobManagerId) throws AppCatalogException {
        (new ResourceJobManagerRepository()).delete(resourceJobManagerId);
    }

    @Override
    public String addJobSubmissionProtocol(String computeResourceId, JobSubmissionInterface jobSubmissionInterface) throws AppCatalogException {
        Mapper mapper = ObjectMapperSingleton.getInstance();
        JobSubmissionInterfaceEntity jobSubmissionInterfaceEntity = mapper.map(jobSubmissionInterface, JobSubmissionInterfaceEntity.class);
        ComputeResourceDescription computeResourceDescription = get(computeResourceId);
        ComputeResourceEntity computeResourceEntity = mapper.map(computeResourceDescription, ComputeResourceEntity.class);
        jobSubmissionInterfaceEntity.setComputeResource(computeResourceEntity);
        jobSubmissionInterfaceEntity.setComputeResourceId(computeResourceId);
        execute(entityManager -> entityManager.merge(jobSubmissionInterfaceEntity));

        return jobSubmissionInterfaceEntity.getJobSubmissionInterfaceId();
    }

    @Override
    public String addLocalJobSubmission(LOCALSubmission localSubmission) throws AppCatalogException {
        localSubmission.setJobSubmissionInterfaceId(AppCatalogUtils.getID("LOCAL"));
        String resourceJobManagerId = addResourceJobManager(localSubmission.getResourceJobManager());
        Mapper mapper = ObjectMapperSingleton.getInstance();
        LocalSubmissionEntity localSubmissionEntity = mapper.map(localSubmission, LocalSubmissionEntity.class);
        localSubmissionEntity.setResourceJobManagerId(resourceJobManagerId);
        localSubmissionEntity.getResourceJobManager().setResourceJobManagerId(resourceJobManagerId);
        if (localSubmission.getResourceJobManager().getParallelismPrefix() != null) {
            (new ResourceJobManagerRepository()).createParallesimPrefix(localSubmission.getResourceJobManager().getParallelismPrefix(), localSubmissionEntity.getResourceJobManager());
        }
        if (localSubmission.getResourceJobManager().getJobManagerCommands() != null) {
            (new ResourceJobManagerRepository()).createJobManagerCommand(localSubmission.getResourceJobManager().getJobManagerCommands(), localSubmissionEntity.getResourceJobManager());
        }

        localSubmissionEntity.setSecurityProtocol(localSubmission.getSecurityProtocol().toString());
        execute(entityManager -> entityManager.merge(localSubmissionEntity));
        return localSubmissionEntity.getJobSubmissionInterfaceId();
    }

    @Override
    public String addGlobusJobSubmission(GlobusJobSubmission globusJobSubmission) throws AppCatalogException {
        return null;
    }

    @Override
    public String addUNICOREJobSubmission(UnicoreJobSubmission unicoreJobSubmission) throws AppCatalogException {
        unicoreJobSubmission.setJobSubmissionInterfaceId(AppCatalogUtils.getID("UNICORE"));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        UnicoreSubmissionEntity unicoreSubmissionEntity = mapper.map(unicoreJobSubmission, UnicoreSubmissionEntity.class);
        if (unicoreJobSubmission.getSecurityProtocol() !=  null) {
            unicoreSubmissionEntity.setSecurityProtocol(unicoreJobSubmission.getSecurityProtocol().toString());
        }
        execute(entityManager -> entityManager.merge(unicoreSubmissionEntity));
        return unicoreJobSubmission.getJobSubmissionInterfaceId();
    }

    @Override
    public String addLocalDataMovement(LOCALDataMovement localDataMovement) throws AppCatalogException {
        localDataMovement.setDataMovementInterfaceId(AppCatalogUtils.getID("LOCAL"));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        LocalDataMovementEntity localDataMovementEntity = mapper.map(localDataMovement, LocalDataMovementEntity.class);
        execute(entityManager -> entityManager.merge(localDataMovementEntity));
        return localDataMovementEntity.getDataMovementInterfaceId();
    }

    @Override
    public String addScpDataMovement(SCPDataMovement scpDataMovement) throws AppCatalogException {
        scpDataMovement.setDataMovementInterfaceId(AppCatalogUtils.getID("SCP"));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        ScpDataMovementEntity scpDataMovementEntity = mapper.map(scpDataMovement, ScpDataMovementEntity.class);
        execute(entityManager -> entityManager.merge(scpDataMovementEntity));
        return scpDataMovementEntity.getDataMovementInterfaceId();
    }

    @Override
    public String addUnicoreDataMovement(UnicoreDataMovement unicoreDataMovement) throws AppCatalogException {
        unicoreDataMovement.setDataMovementInterfaceId(AppCatalogUtils.getID("UNICORE"));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        UnicoreDatamovementEntity unicoreDatamovementEntity = mapper.map(unicoreDataMovement, UnicoreDatamovementEntity.class);
        execute(entityManager -> entityManager.merge(unicoreDatamovementEntity));
        return unicoreDatamovementEntity.getDataMovementInterfaceId();
    }

    @Override
    public String addDataMovementProtocol(String resourceId, DMType dmType, DataMovementInterface dataMovementInterface) throws AppCatalogException {
        if (dmType.equals(DMType.COMPUTE_RESOURCE)){
            Mapper mapper = ObjectMapperSingleton.getInstance();
            DataMovementInterfaceEntity dataMovementInterfaceEntity = mapper.map(dataMovementInterface, DataMovementInterfaceEntity.class);
            ComputeResourceEntity computeResourceEntity = mapper.map(get(resourceId), ComputeResourceEntity.class);
            dataMovementInterfaceEntity.setComputeResource(computeResourceEntity);
            dataMovementInterfaceEntity.setComputeResourceId(resourceId);
            execute(entityManager -> entityManager.merge(dataMovementInterfaceEntity));
            return dataMovementInterfaceEntity.getDataMovementInterfaceId();
        }
        else if (dmType.equals(DMType.STORAGE_RESOURCE)){
            //TODO - COMPLETE this after StorageResourceRepo implementation
            return null;
        }
        return null;
    }

    @Override
    public String addGridFTPDataMovement(GridFTPDataMovement gridFTPDataMovement) throws AppCatalogException {
        gridFTPDataMovement.setDataMovementInterfaceId(AppCatalogUtils.getID("GRIDFTP"));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        GridftpDataMovementEntity gridftpDataMovementEntity = mapper.map(gridFTPDataMovement, GridftpDataMovementEntity.class);
        execute(entityManager -> entityManager.merge(gridftpDataMovementEntity));
        List<String> gridFTPEndPoint = gridFTPDataMovement.getGridFTPEndPoints();
        if (gridFTPEndPoint != null && !gridFTPEndPoint.isEmpty()) {
            for (String endpoint : gridFTPEndPoint) {
                GridftpEndpointPK gridftpEndpointPK = new GridftpEndpointPK();
                gridftpEndpointPK.setDataMovementInterfaceId(gridFTPDataMovement.getDataMovementInterfaceId());
                gridftpEndpointPK.setEndpoint(endpoint);
                GridftpEndpointEntity gridftpEndpointEntity = new GridftpEndpointEntity();
                gridftpEndpointEntity.setGridftpDataMovement(gridftpDataMovementEntity);
                gridftpEndpointEntity.setId(gridftpEndpointPK);
                execute(entityManager -> entityManager.merge(gridftpEndpointEntity));
            }
        }
        return gridftpDataMovementEntity.getDataMovementInterfaceId();
    }

    @Override
    public SSHJobSubmission getSSHJobSubmission(String submissionId) throws AppCatalogException {
        SshJobSubmissionEntity entity = execute(entityManager -> entityManager
                .find(SshJobSubmissionEntity.class, submissionId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        SSHJobSubmission sshJobSubmission = mapper.map(entity, SSHJobSubmission.class);
        sshJobSubmission.getResourceJobManager().setParallelismPrefix((new ResourceJobManagerRepository().getParallelismPrefix(sshJobSubmission.getResourceJobManager().getResourceJobManagerId())));
        sshJobSubmission.getResourceJobManager().setJobManagerCommands((new ResourceJobManagerRepository().getJobManagerCommand(sshJobSubmission.getResourceJobManager().getResourceJobManagerId())));
        return sshJobSubmission;
    }

    @Override
    public UnicoreJobSubmission getUNICOREJobSubmission(String submissionId) throws AppCatalogException {
        UnicoreSubmissionEntity entity = execute(entityManager -> entityManager
                .find(UnicoreSubmissionEntity.class, submissionId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, UnicoreJobSubmission.class);
    }

    @Override
    public UnicoreDataMovement getUNICOREDataMovement(String dataMovementId) throws AppCatalogException {
        UnicoreDatamovementEntity entity = execute(entityManager -> entityManager
                .find(UnicoreDatamovementEntity.class, dataMovementId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, UnicoreDataMovement.class);
    }

    @Override
    public CloudJobSubmission getCloudJobSubmission(String submissionId) throws AppCatalogException {
        CloudJobSubmissionEntity entity = execute(entityManager -> entityManager
                .find(CloudJobSubmissionEntity.class, submissionId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, CloudJobSubmission.class);
    }

    @Override
    public SCPDataMovement getSCPDataMovement(String dataMoveId) throws AppCatalogException {
        ScpDataMovementEntity entity = execute(entityManager -> entityManager
                .find(ScpDataMovementEntity.class, dataMoveId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, SCPDataMovement.class);
    }

    @Override
    public GridFTPDataMovement getGridFTPDataMovement(String dataMoveId) throws AppCatalogException {
        GridftpDataMovementEntity entity = execute(entityManager -> entityManager
                .find(GridftpDataMovementEntity.class, dataMoveId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, GridFTPDataMovement.class);
    }

    @Override
    public void removeJobSubmissionInterface(String computeResourceId, String jobSubmissionInterfaceId) throws AppCatalogException {
        JobSubmissionInterfacePK jobSubmissionInterfacePK = new JobSubmissionInterfacePK();
        jobSubmissionInterfacePK.setComputeResourceId(computeResourceId);
        jobSubmissionInterfacePK.setJobSubmissionInterfaceId(jobSubmissionInterfaceId);
        execute(entityManager -> {
            JobSubmissionInterfaceEntity entity = entityManager.find(JobSubmissionInterfaceEntity.class, jobSubmissionInterfacePK);
            entityManager.remove(entity);
            return entity;
        });
    }

    @Override
    public void removeDataMovementInterface(String computeResourceId, String dataMovementInterfaceId) throws AppCatalogException {
        DataMovementInterfacePK dataMovementInterfacePK = new DataMovementInterfacePK();
        dataMovementInterfacePK.setDataMovementInterfaceId(dataMovementInterfaceId);
        dataMovementInterfacePK.setComputeResourceId(computeResourceId);
        execute(entityManager -> {
            DataMovementInterfaceEntity entity = entityManager.find(DataMovementInterfaceEntity.class, dataMovementInterfacePK);
            entityManager.remove(entity);
            return entity;
        });
    }

    @Override
    public void removeBatchQueue(String computeResourceId, String queueName) throws AppCatalogException {
        BatchQueuePK batchQueuePK = new BatchQueuePK();
        batchQueuePK.setQueueName(queueName);
        batchQueuePK.setComputeResourceId(computeResourceId);
        execute(entityManager -> {
            BatchQueueEntity entity = entityManager.find(BatchQueueEntity.class, batchQueuePK);
            entityManager.remove(entity);
            return entity;
        });
    }

    @Override
    public LOCALSubmission getLocalJobSubmission(String submissionId) throws AppCatalogException {
        LocalSubmissionEntity entity = execute(entityManager -> entityManager
                .find(LocalSubmissionEntity.class, submissionId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        LOCALSubmission localSubmission = mapper.map(entity, LOCALSubmission.class);
        localSubmission.getResourceJobManager().setParallelismPrefix((new ResourceJobManagerRepository().getParallelismPrefix(localSubmission.getResourceJobManager().getResourceJobManagerId())));
        localSubmission.getResourceJobManager().setJobManagerCommands((new ResourceJobManagerRepository().getJobManagerCommand(localSubmission.getResourceJobManager().getResourceJobManagerId())));
        return localSubmission;
    }

    @Override
    public LOCALDataMovement getLocalDataMovement(String datamovementId) throws AppCatalogException {
        LocalDataMovementEntity entity = execute(entityManager -> entityManager
                .find(LocalDataMovementEntity.class, datamovementId));
        if(entity == null)
            return null;
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, LOCALDataMovement.class);
    }
}
