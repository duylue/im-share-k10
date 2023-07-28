package com.imShare.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.imShare.domain.FileMetadata;
import com.imShare.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StorageService extends BaseResponse {
    private final AmazonS3 s3Client;
    private final Tika tika = new Tika();

    @Value("${application.bucket.name}")
    private String bucketName;

    public Bucket createBucket(String bucketName) {
        if (s3Client.doesBucketExistV2(bucketName)) {
            return null;
        } else return s3Client.createBucket(bucketName);
    }

    public ResponseEntity<?> createAttachment(List<MultipartFile> files) {
        List<FileMetadata> attachments = files.stream()
                .map(file -> {
                    String fileKey = "uploadFile-" + file.getOriginalFilename();
                    return put(bucketName, fileKey, file, true);
                })
                .collect(Collectors.toList());
        return getResponseEntity(attachments);
    }

    public FileMetadata put(String bucket, String key, MultipartFile file, Boolean publicAccess) {
        FileMetadata metadata = FileMetadata.builder()
                .bucket(bucket)
                .key(key)
                .name(file.getOriginalFilename())
                .extension(StringUtils.getFilenameExtension(file.getOriginalFilename()))
                .mime(tika.detect(file.getOriginalFilename()))
                .size(file.getSize())
                .build();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(metadata.getSize());
        objectMetadata.setContentType(metadata.getMime());

        try {
            InputStream stream = file.getInputStream();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, stream, objectMetadata);
            PutObjectResult putObjectResult = s3Client.putObject(putObjectRequest);
            metadata.setUrl(s3Client.getUrl(bucket, key).toString());
            metadata.setHash(putObjectResult.getContentMd5());
            metadata.setEtag(putObjectResult.getETag());
            metadata.setPublicAccess(publicAccess);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metadata;
    }


}