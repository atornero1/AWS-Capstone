package org.example.newsletter;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class S3Service {

    public void uploadResume(MultipartFile file) throws IOException {

        S3Client s3 = S3Client.builder()
                .region(Region.US_EAST_1)
                .build();


        PutObjectRequest putOb = PutObjectRequest.builder()
                .bucket("alexis-resume-api-data")
                .key("resume.json")
                .contentType("application/json")
                .cacheControl("no-cache")
                .build();

        s3.putObject(putOb, RequestBody.fromBytes(file.getBytes()));
    }
}