package org.example.newsletter;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SnsAlertService {
    private static final String ALERT_TOPIC_ARN = "arn:aws:sns:us-east-1:568307822552:Capstone-Alerts";

    public void sendErrorAlert(String errorMessage) {
        SnsClient snsClient = SnsClient.builder()
                .region(Region.US_EAST_1)
                .build();

        PublishRequest request = PublishRequest.builder()
                .message("Alert: An error occurred in the Newsletter App: " + errorMessage)
                .topicArn(ALERT_TOPIC_ARN)
                .subject("Portfolio Project Error Alert")
                .build();

        snsClient.publish(request);
    }
}
