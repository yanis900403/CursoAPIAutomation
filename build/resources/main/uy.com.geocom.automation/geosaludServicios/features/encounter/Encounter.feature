Feature: Resources Encounter

  @Encounter
    #Prospective warnings of potential issues when providing care to the patient
  Scenario: POST resource Encounter with parameters
    Given I send to the endpoint Fhir to create a new Encounter
    Then I send a POST request and complete parameters
    Then I can validate I receive a valid status code


  @Encounter
  Scenario: GET resource Encounter
    Given I send to the endpoint Fhir
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
    And I verify that error message is "El alta de Encounter solo acepta estado 'unknown'"

  @Encounter
  Scenario: POST resource Encounter with Status empty
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and leave status value empty
    Then I can validate I receive a valid status code 500
    And I verify that error message is "El alta de Encounter solo acepta estado 'unknown'"

 @Encounter
 Scenario: POST resource Encounter not subject
  Given I send to the endpoint Fhir
  Then I send to the endpoint to create a new Encounter
  Then I send a POST request and it completes without not subject
  Then I can validate I receive a valid status code 500
  And I verify that error message is "El código de Persona 0 no existe."

  @Encounter
  Scenario: POST resource Encounter without code in the type OS
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and it completes without order type service
    Then I can validate I receive a valid status code 500
    And I verify that error message is "Debe indicar System y Code para serviceType"

    @Encounter
  Scenario: ENCOUNTER GET Incorrect format
    Given I send to the endpoint Fhir
    Then I send to the endpoint to consult GET by Encounter with incorrect format
    Then I can validate I receive a valid status code 404
    And I verify that error message is "Unknown resource type 'Encouner' - Server knows how to handle: [Appointment, Organization, Questionnaire, MedicationDispense, DiagnosticReport, HealthcareService, CarePlan, FamilyMemberHistory, Medication, Encounter, Substance, AuditEvent, Subscription, OperationDefinition, DocumentReference, Condition, MedicationRequest, Parameters, MedicationKnowledge, Patient, Coverage, PractitionerRole, CodeSystem, Flag, QuestionnaireResponse, Practitioner, RequestGroup, Schedule, Observation, MedicationAdministration, Slot, Location]"

    @Encounter
  Scenario: POST resource Encounter not act of care
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and it completes without act of care
    Then I can validate I receive a valid status code 500
    And I verify that error message is "Parametro obligatorio ActAsistId vacio"

      @Encounter
  Scenario: POST ENCOUNTER Create a new OS with incorrectly formatted Period.Start
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and it complete with incorrectly formatted Period.Start
    Then I can validate I receive a valid status code 400
    And I verify that error message is "Failed to parse request body as JSON resource."

  Scenario: POST ENCOUNTER Create new OS whit empty field in Period.start
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request and it leaves the field in Period. start it empty
    Then I can validate I receive a valid status code 500
    And I verify that error message is "Parametro obligatorio OSFchHor vacio."

  Scenario: POST ENCOUNTER not Reason for consultation
    Given I send to the endpoint Fhir
    Then I send to the endpoint to create a new Encounter
    Then I send a POST request without consultation reason
    Then I can validate I receive a valid status code 201