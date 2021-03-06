package by.andd3dfx.lambda;

import by.andd3dfx.dto.PersonRequest;
import by.andd3dfx.dto.PersonResponse;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaSavePersonHandler implements RequestHandler<PersonRequest, PersonResponse> {

    private final Regions REGION = Regions.US_EAST_1;
    private final String DYNAMODB_TABLE_NAME = "Person";

    private DynamoDB dynamoDb;

    public PersonResponse handleRequest(PersonRequest personRequest, Context context) {
        context.getLogger().log("Input: " + personRequest.toString());

        persistData(personRequest);
        return new PersonResponse("Saved to DynamoDB successfully!!!");
    }

    private PutItemOutcome persistData(PersonRequest personRequest) throws ConditionalCheckFailedException {
        dynamoDb = new DynamoDB(
            AmazonDynamoDBClientBuilder.standard()
                .withRegion(Region.getRegion(REGION).getName())
                .build()
        );

        return dynamoDb.getTable(DYNAMODB_TABLE_NAME)
            .putItem(
                new PutItemSpec().withItem(new Item()
                    .withNumber("id", personRequest.getId())
                    .withString("firstName", personRequest.getFirstName())
                    .withString("lastName", personRequest.getLastName())
                    .withNumber("age", personRequest.getAge())
                    .withString("address", personRequest.getAddress())));
    }
}
