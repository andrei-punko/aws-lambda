# AWS Lambda usage example

[![Maven CI](https://github.com/andrei-punko/aws-lambda/actions/workflows/maven.yml/badge.svg)](https://github.com/andrei-punko/aws-lambda/actions/workflows/maven.yml)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/andrei-punko/aws-lambda/actions/workflows/gradle.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Based on [article](https://www.baeldung.com/java-aws-lambda) on Baeldung portal

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
