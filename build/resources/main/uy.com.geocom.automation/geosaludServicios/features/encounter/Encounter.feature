Feature: Resources Encounter

  @Encounter
    #Prospective warnings of potential issues when providing care to the patient
  Scenario: POST resource Encounter with parameters
    Given I send to the endpoint Fhir to create a new Encounter
    Then I send a POST request and complete parameters
    Then I can validate I receive a valid status code


  @Encounter
  Scenario: GET resource Encounter
    Given I send a GET request to the endpoint
    And   I send a GET Encounter request
    Then  I get a 200 status code


  @Encounter
    Scenario: PUT resource Encounter with parameters-Message:No se puede ejecutar la acción para el estado actual de la OS
    #PUT Encounter-Message:No se puede ejecutar la acción para el estado actual de la OS
    Given I send to the endpoint Fhir to create a new Encounter
    Then I send a PUT request
    Then I can validate I receive a valid value

  @Encounter
  Scenario: POST resource Encounter Not Status UnKnown
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and it completes with the status value is not Unknown for example planned
    Then I can validate I receive a valid status code 500
    And I verify that message is "El alta de Encounter solo acepta estado 'unknown'"

  @Encounter
  Scenario: POST resource Encounter with Status empty
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and leave status value empty
    Then I can validate I receive a valid status code 500
    And I verify that message is "El alta de Encounter solo acepta estado 'unknown'"

 @Encounter
 Scenario: POST resource Encounter not subject
  Given I send to the endpoint Fhir
  Then I send to the endpoint to create a new Encounter
  Then I send a POST request and it completes without not subject
  Then I can validate I receive a valid status code 500
  And I verify that message is "El código de Persona 0 no existe." and the OS isn't created

  @Encounter
  Scenario: POST resource Encounter without code in the type OS
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and it completes without order type service
    Then I can validate I receive a valid status code 500
    And I verify that message is "Debe indicar System y Code para serviceType" and the OS isn't created without code

@Encounter
Scenario: POST resource Encounter not act of care
  Given I send to the endpoint Fhir Test
  Then I send to the endpoint to create a new Encounter Test
  Then I send a POST request and it completes without act of care
  Then I can validate I receive a valid status code 500 Test
  And I verify that message is "Parametro obligatorio ActAsistId vacio" and the OS isn't created without act of care