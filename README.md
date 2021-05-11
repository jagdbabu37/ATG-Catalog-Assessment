# ATG Catalog Interview Exercise

## Application Overview
This is a spring boot application that will serve `catalog` data via a REST API.

## Running the Application
This application can be ran different ways:
* Within the IDE of your choice:
* On the command line with `./gradlew bootRun`
* After compilation (still on the command line)
  * `./gradlew clean build`
  * `java -jar ./build/libs/catalog-0.0.1-SNAPSHOT.jar`

The application runs on port `8080`.  For example, http://localhost:8080/v1/catalogs/1

## Exercise Steps
Please enhance the application with the following requirements. 
You are free to pull in any dependencies you find fitting. 
There is already a `H2` in-memory database provided that can be used, but feel free to use a database that you are comfortable with,
as long as the steps are there for someone else to run the application.
* Create an endpoint that can add a catalog to the database with proper validation:
  * `id` is generated by the database
  * `name` is required
  * `description` is optional
  * `referenceId` is required and unique
* Update the `GET /v1/catalogs/{id}` to return the catalog by `id`, handling the "not found" scenario
* Add the ability to add an `Item` to a `Catalog`. `Catalog` can have many `Items`.
  * `Item` fields
    * `id` is generated by the database
    * `name` is required
    * `description` is optional
    * `referenceId` is required and unique
    * `price` is required
* Update the `GET /v1/catalogs/{id}` to return also return all `Item`s associated with the `Catalog`
* Create unit and functional tests to validate the code

#Assement Updates
Added 4 endpoints to the projects
a)http://localhost:8080/v1/catalogs/{id} (End pint  to retreive catalog deatils by catalog id)
b)http://localhost:8080/v1/catalogs/items/{id}(End pint  to retrieve list of  item  details by catalog id)
c)http://localhost:8080/v1/catalogs/addItem (End point to ad itesm to the catlog))
d)http://localhost:8080/v1/catalogs/createCatalog(End point to create the catlog)
Used the in memory Database H2 to manage the persistence.
Spring JDBC for Database operations.
Use the below CURL's to create catalog and Items
curl  http://localhost:8080/v1/catalog/createCatalog -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d "{\"id\":\"1234\",\"name\":\"jagdish\",\"description\":\"linuxize@example.com\",\"referenceId\":\"zyx\"}"
curl  curl  http://localhost:8080/v1/catalogs/addItem -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d "{\"id\":\"1234\",\"name\":\"tractor\",\"description\":\"heavyTractor\",\"referenceId\":\"zyx\",\"catalogId\":\"1\",\"price\":\"123.00\"}"
Updated the test cases.


## Submitting the Exercise
Thank you for taking the time to complete this exercise. You can submit by providing access to the forked or 
cloned repository in your GitHub account to `rwatts-atg` then emailing HR upon completion (preferred) 
or by archiving your project and sending it to HR. If you have questions regarding the exercise, please contact
HR and we will respond as quickly as possible.

## Getting Started with Spring Boot

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

