
# AWS Lambda usage example

Based on this article https://www.baeldung.com/java-aws-lambda

## Prerequisites
- Maven 3
- JDK 11

## How to build
    mvn clean install

## How to run on AWS

Create Lambda functions:
- MethodHandlerLambda
- RequestHandlerLambda
- StreamHandlerLambda

Upload result fat JAR from ./target folder into each Lambda function

Set appropriate handler in Runtime settings section (on Code tab) of each Lambda function:
- by.andd3dfx.LambdaMethodHandler::handleRequest
- by.andd3dfx.LambdaRequestHandler::handleRequest
- by.andd3dfx.LambdaRequestStreamHandler::handleRequest

## How to check
From Test tab - send test event with some text in quotes

Green section "Execution result: succeeded" should appear. Check logs in it
