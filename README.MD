
# AWS Lambda usage example

[![Java CI with Maven](https://github.com/andrei-punko/aws-lambda/actions/workflows/maven.yml/badge.svg)](https://github.com/andrei-punko/aws-lambda/actions/workflows/maven.yml)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/andrei-punko/aws-lambda/actions/workflows/gradle.yml)
[![Branches](.github/badges/branches.svg)](https://github.com/andrei-punko/aws-lambda/actions/workflows/gradle.yml)

Based on this article https://www.baeldung.com/java-aws-lambda

## Prerequisites
- Maven 3
- JDK 21

## How to build
    mvn clean install

## How to run on AWS

Create Lambda functions:
- MethodHandlerLambda
- RequestHandlerLambda
- StreamHandlerLambda
- SavePersonHandlerLambda

Upload result fat JAR from `./target` folder into each Lambda function

Set appropriate handler in Runtime settings section (on Code tab) of each Lambda function:
- `by.andd3dfx.lambda.LambdaMethodHandler::handleRequest`
- `by.andd3dfx.lambda.LambdaRequestHandler::handleRequest`
- `by.andd3dfx.lambda.LambdaRequestStreamHandler::handleRequest`
- `by.andd3dfx.lambda.LambdaSavePersonHandler::handleRequest`

Create DynamoDB Table `Person` with Partition key `id`

Created DynamoDB table should be in the same region that declared in `LambdaSavePersonHandler.REGION`

## How to check
From Test tab - send test event with some text in quotes

Green section "Execution result: succeeded" should appear. Check logs in it
