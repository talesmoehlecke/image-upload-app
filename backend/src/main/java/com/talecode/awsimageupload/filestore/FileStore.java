package com.talecode.awsimageupload.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {
    @Resource
    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3){
        this.s3 = s3;
    }

    public void save(String path,
                     String fileName,
                     Optional<Map<String, String>> optionalMetaData,
                     InputStream inputStream){
        ObjectMetadata metaData = mapOptionalMetaDataIntoObjectMetaData(optionalMetaData);

        try{
           s3.putObject(path, fileName, inputStream, metaData);
        } catch (AmazonServiceException e){
            throw new IllegalStateException("Failed to store file to S3", e);
        }
    }

    private ObjectMetadata mapOptionalMetaDataIntoObjectMetaData(Optional<Map<String, String>> optionalMetaData) {
        ObjectMetadata metaData = new ObjectMetadata();

        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(metaData::addUserMetadata);
            }
        });
        return metaData;
    }
}
