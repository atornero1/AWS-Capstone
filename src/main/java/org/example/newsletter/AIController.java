package org.example.newsletter;

import org.springframework.stereotype.Controller;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.*;
import software.amazon.awssdk.services.rekognition.model.Image;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AIController {

    @GetMapping("/ai-check")
    public String showAiPage() {
        return "ai-check";
    }

    @PostMapping("/api/ai/verify-face")
    @ResponseBody
    public Map<String, Object> verifyFace(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();

        RekognitionClient rekClient = RekognitionClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .build();

        try {
            SdkBytes sdkBytes = SdkBytes.fromInputStream(file.getInputStream());

            DetectFacesRequest request = DetectFacesRequest.builder()
                    .image(Image.builder().bytes(sdkBytes).build())
                    .attributes(Attribute.DEFAULT)
                    .build();

            DetectFacesResponse response = rekClient.detectFaces(request);

            boolean isHuman = !response.faceDetails().isEmpty();
            double confidence = isHuman ? response.faceDetails().get(0).confidence().doubleValue() : 0.0;

            result.put("isHuman", isHuman);
            result.put("confidence", confidence);
            result.put("message", isHuman ? "Human Face Verified!" : "No Face Detected.");

        } catch (RekognitionException e) {
            result.put("isHuman", false);
            result.put("message", "AWS Error: " + e.awsErrorDetails().errorMessage());
        } finally {
            rekClient.close();
        }

        return result;
    }
}