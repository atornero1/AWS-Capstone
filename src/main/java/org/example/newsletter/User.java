package org.example.newsletter;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class User {
    private String email;

    public User() {}

    @DynamoDbPartitionKey // Must match the partition key in AWS table
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}