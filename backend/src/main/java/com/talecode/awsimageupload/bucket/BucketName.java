package com.talecode.awsimageupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("talecode-image-upload-app");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
