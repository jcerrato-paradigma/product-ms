# Product microservice (ms-product)

## Design
For this microservice I have used an hexagonal architecture approach. This architecture allows the layers to be decoupled as much as possible.

The microservice has three layers:

- **Infrastructure**: in this layer I have built all the implementations needed, known as adapters in hexagonal architecture. First, the persistence implementation to connect to the database with JPA. In the other hand, the controller to receive requests from outside. Moreover, the controller is built with OpenAPI specification that allow to build the controller automatically from a contract.
- **Application**: in this layer I have built a service to orchestrate the flows from infrastructure layer to domain layer. This layer has no knowledge of infrastructure layer.
- **Domain**: this is the core layer and it lacks knowledge of the outer layers. In this layer I have built the interfaces that defines the flows. This interfaces are known as ports in hexagonal architecture.

Finally, I have decided that the name of the microservice as well as the main descriptions in it were with the domain **product**. I have decided this because, although the main table proposed and the purpose of the endpoint was to retrieve the price of a product, the main entity in this case was the product, not the price. In a real project, all the endpoints in this microservice must be designed with the product domain in mind, and individual specifications like the price of the product must be built around the main domain.

## Building the project

This service is built using Maven. It is included in the project with Maven Wrapper that is using 3.9.5 version. From command line, if you have Maven installed, you can use `mvn` command to execute commands, of if you don't, use Maven Wrapper one `mvnw`.

To compile the code of the project use next command:

`mvn clean compile`

To run the tests, use next command:

`mvn clean test`

To build the jar:

`mvn clean package`

To build the entire project and install dependencies:

`mvn clean install`

## Running the microservice

The microservice is built using Spring Boot. Once the project is built, you can launch it with next command:

`mvn spring-boot:run` 

Once the microservice is launched, requests can be done to the 8080 port of localhost. 

Moreover, a H2 console is launched too to connect to the database.

URLs used are explained in the next sections.

## Running the microservice with Docker

The project include a Dockerfile to containerize the microservice. It is built using an openjdk 17 with Alpine Linux image. To build the image, the command used is:

`docker build -t jcerrato/ms-product:0.0.1-SNAPSHOT .`

To run the container use:

`docker run -p 8080:8080 jcerrato/ms-product:0.0.1-SNAPSHOT`

Once the container is running, the microservice is fully functional as if it were launched with Spring Boot.

## Concluding remarks

To test the microservice, a H2 database is automatically populated with data once it is running. To access to the console of the database go to:

`localhost:8080/h2-console`

Params to access are:

- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:inditex-db
- User Name: h2-user
- Password: [empty]

Moreover, a Postman collection is included to test the endpoint. It is in next path:

`api/postman/products.postman_collection.json`

In addition, the contract of the API used for OpenAPI is here:

`src/main/resources/api/products.yml`

