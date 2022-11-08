
Feature: Resource Flag

@Flat
  Scenario: GET al endPoint
    Given I send a GET request to the endpoint
    Then I get a 200 status code for flag 26

@Flat
  Scenario: Validate that an element is found in the response
    Given I send a GET request to the endpointTest
    Then I send a GET request to the flag 26
    Then I validate there is a value: "code" in the response

  @Flat
  Scenario: POST resource Flag with parameters
    Given I send to the endpoint Fhir to create a new Flag
    Then I send a POST request
    Then I can validate response I receive a valid status code


