# app-product-v1
____

Application to retrieve a product according to input fields

### Technologies
* Hexagonal architecture
* API-first approach
* Spring boot
* Openapi Generator
* H2 Database
* Project Reactor
* Lombok
* MapStruct
* Jacoco
* Junit5
* Mockito
* Karate
* BDD
* TDD
* Gherkin
* IDE: Intellij Idea

### Dependencies
* Java 11
* Maven 3.8.8

### Test (Jacoco)
To see code coverage, you can go to the file: **target/site/jacoco/index.html** and open it in a browser,\
after having executed the following command
```
    mvn clean pacakge
```

### Install
To run the application, run the following command

```
    mvn spring-boot:run
```

### Test (Karate)
After you have run the application, you can run the file: **src/test/java/karate/ApiProductV1Test**,\
here you will see 5 API tests with Karate.
\
\
You can also run the following links

* [Test 1: Request at 10:00 on the 14th for product 35455 for brand 1 (ZARA)](http://localhost:8080/product?application_date=2020-06-14-10.00.00&product_id=35455&brand_id=1)
* [Test 2: Request at 16:00 on the 14th for product 35455 for brand 1 (ZARA)](http://localhost:8080/product?application_date=2020-06-14-16.00.00&product_id=35455&brand_id=1)
* [Test 3: Request at 21:00 on the 14th for product 35455 for brand 1 (ZARA)](http://localhost:8080/product?application_date=2020-06-14-21.00.00&product_id=35455&brand_id=1)
* [Test 4: Request at 10:00 on the 15th for product 35455 for brand 1 (ZARA)](http://localhost:8080/product?application_date=2020-06-15-10.00.00&product_id=35455&brand_id=1)
* [Test 5: Request at 21:00 on the 16th for product 35455 for brand 1 (ZARA)](http://localhost:8080/product?application_date=2020-06-15-21.00.00&product_id=35455&brand_id=1)

