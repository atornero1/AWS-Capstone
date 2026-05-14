package org.example.newsletter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Service
public class DynamoService {
    private final DynamoDbTable<User> userTable;
    private final SnsAlertService snsAlertService;

    public DynamoService(
            @Value("${aws.region}") String awsRegion,
            @Value("${aws.dynamodb.table-name}") String tableName,
            SnsAlertService snsAlertService) {

        this.snsAlertService = snsAlertService;

        DynamoDbClient standardClient = DynamoDbClient.builder()
                .region(Region.of(awsRegion))
                .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(standardClient)
                .build();

        this.userTable = enhancedClient.table(tableName, TableSchema.fromBean(User.class));
    }

    public void saveUser(String email) {
        try {
            User newUser = new User();
            newUser.setEmail(email);
            userTable.putItem(newUser);

            System.out.println("User saved successfully to AWS!");
        } catch (Exception e) {
            System.err.println("Database write failed. Triggering SNS alert...");
            snsAlertService.sendErrorAlert(e.getMessage());
            throw e;
        }
    }
}