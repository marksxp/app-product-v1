Feature: App Product v1 - tests

  Scenario: Retrieve product - 1
    Given url 'http://localhost:8080/product?application_date=2020-06-14-10.00.00&product_id=35455&brand_id=1'
    When method GET
    Then status 200
    And match response == {"productId":35455,"brandId":1,"priceList":1,"startDate":"2020-06-14-00.00.00","endDate":"2020-12-31-23.59.59","price":35.5,"curr":"EUR"}

  Scenario: Retrieve product - 2
    Given url 'http://localhost:8080/product?application_date=2020-06-14-16.00.00&product_id=35455&brand_id=1'
    When method GET
    Then status 200
    And match response == {"productId":35455,"brandId":1,"priceList":2,"startDate":"2020-06-14-15.00.00","endDate":"2020-06-14-18.30.00","price":25.45,"curr":"EUR"}

  Scenario: Retrieve product - 3
    Given url 'http://localhost:8080/product?application_date=2020-06-14-21.00.00&product_id=35455&brand_id=1'
    When method GET
    Then status 200
    And match response == {"productId":35455,"brandId":1,"priceList":1,"startDate":"2020-06-14-00.00.00","endDate":"2020-12-31-23.59.59","price":35.5,"curr":"EUR"}

  Scenario: Retrieve product - 4
    Given url 'http://localhost:8080/product?application_date=2020-06-15-10.00.00&product_id=35455&brand_id=1'
    When method GET
    Then status 200
    And match response == {"productId":35455,"brandId":1,"priceList":3,"startDate":"2020-06-15-00.00.00","endDate":"2020-06-15-11.00.00","price":30.50,"curr":"EUR"}

  Scenario: Retrieve product - 5
    Given url 'http://localhost:8080/product?application_date=2020-06-15-21.00.00&product_id=35455&brand_id=1'
    When method GET
    Then status 200
    And match response == {"productId":35455,"brandId":1,"priceList":4,"startDate":"2020-06-15-16.00.00","endDate":"2020-12-31-23.59.59","price":38.95,"curr":"EUR"}

    ## Others
  Scenario: Retrieve product - 6
    Given url 'http://localhost:8080/product?application_date=2020-06-15-21.00.00&product_id=35455&brand_id=2'
    When method GET
    Then status 204
    And match response == ""

  Scenario: Retrieve product - 7
    Given url 'http://localhost:8080/product?application_date=2020-06-15-21.00.00&product_id=35455'
    When method GET
    Then status 400
    And match response == {"errors": [{"code": "400","message": "Missing required parameters.","level": "ERROR"}]}
