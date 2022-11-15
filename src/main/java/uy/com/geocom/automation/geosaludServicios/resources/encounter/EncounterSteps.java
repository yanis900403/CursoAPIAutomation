package uy.com.geocom.automation.geosaludServicios.resources.encounter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class EncounterSteps {
   private RequestSpecification request;
    private Response response;

     private ValidatableResponse json;

     @Autowired
    private EncounterFacade encounterFacade;

   /* @Given("I send a GET request to the endpoint")
    public void iSendAGETRequestToTheEndpoint() {

        request = given()
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
                .contentType(ContentType.JSON);
    }*/

    @And("I send a GET Encounter request")
    public void iSendAGETEncounterRequest() {

        response= request
            .when()
            .get("Encounter/1-614355");
    }

    @Then("I get a {int} status code")
    public void iGetAStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Given("I send to the endpoint Fhir to create a new Encounter")
public void iSendEndPointToCreateNewEncounter(){

        request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
                .contentType(ContentType.JSON);

    }

    @Then("I send a POST request and complete parameters")
    public void iSendAPOSTRequestAndCompleteParameters() {

        String requestBodyEncounter="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"VariosActosAsist_POST_Yanis3\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "    \"class\": {\n" +
                "        \"system\": \"http://terminology.pruebaAgustin.org/CodeSystem/v3-ActCode\",\n" +
                "        \"code\": \"AMB\",\n" +
                "        \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "   \"type\": [\n" +
                "       {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"11333\",\n" +
                "\n" +
                "                   \"display\": \"11333 - ACTO ASISTENCIAL TEST\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"4567\",\n" +
                "\n" +
                "                   \"display\": \"CONS CIRUJANO\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"3390\",\n" +
                "\n" +
                "                   \"display\": \"CONS RADIOLOGIA\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       }\n" +
                "   ],\n" +
                "\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/2615\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-09-13T11:52:36\",\n" +
                "        \"end\":\"2023-09-09T12:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/3\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
                "                \"display\": \"CONSULTA\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}\n" +
                "\n";

          response = request.when().body(requestBodyEncounter).post("/Encounter").then().log().all().extract().response();

        //System.out.println(response);
    //   System.out.println(response2 + "Yanis");
    }

    @Then("I can validate I receive a valid status code")
    public void iCanValidateIReceiveAValidStatusCode() {
        response.then().statusCode(201);
        String jsonEncounterPOST="";
        jsonEncounterPOST=response.getContentType();

        System.out.println(jsonEncounterPOST);


    }
    @Then("I send a PUT request")
    public void iSendAPUTRequest() {
        String requestBodyEncounter="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "\"id\": \"1-614355\" ,\n"+
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"VariosActosAsist_PUT_Yanis115\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "    \"class\": {\n" +
                "        \"system\": \"http://terminology.pruebaAgustin.org/CodeSystem/v3-ActCode\",\n" +
                "        \"code\": \"AMB\",\n" +
                "        \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "   \"type\": [\n" +
                "       {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"11333\",\n" +
                "\n" +
                "                   \"display\": \"11333 - ACTO ASISTENCIAL TEST\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"4567\",\n" +
                "\n" +
                "                   \"display\": \"CONS CIRUJANO\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"3390\",\n" +
                "\n" +
                "                   \"display\": \"CONS RADIOLOGIA\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       }\n" +
                "   ],\n" +
                "\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/3016\",\n" +
                "        \"display\": \"GEO712\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-10-13T11:52:36\",\n" +
                "        \"end\":\"2022-12-20T12:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/3\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
                "                \"display\": \"CONSULTA\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}\n";

        response = request.when().body(requestBodyEncounter).put("/Encounter/1-614355").then().log().all().extract().response();

    }
    @Then("I can validate I receive a valid value")
    public void iCanValidateIReceiveAValidValue() {
        response.then().statusCode(400);
        System.out.println("The status received: " + response.statusLine());


    }

    @Then("I send a PUT request with successful parameters")
    public void iSendAPUTRequestWithSuccessfulParameters() {
     String requestBodyEncounter="{\n" +
             "    \"resourceType\": \"Encounter\",\n" +
             "    \"id\": \"1-614296\",\n" +
             "    \"meta\": {\n" +
             "        \"lastUpdated\": \"2022-10-20T15:23:42\"\n" +
             "    },\n" +
             "    \"identifier\": [\n" +
             "        {\n" +
             "            \"value\": \"VariosActosAsist_POST_Yanis3\"\n" +
             "        }\n" +
             "    ],\n" +
             "    \"status\": \"in-progress\",\n" +
             "    \"class\": {\n" +
             "        \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActCode\",\n" +
             "        \"code\": \"AMB\"\n" +
             "    },\n" +
             "    \"type\": [\n" +
             "        {\n" +
             "            \"coding\": [\n" +
             "                {\n" +
             "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
             "                    \"code\": \"4567\",\n" +
             "                    \"display\": \"CONS CIRUJANO\"\n" +
             "                }\n" +
             "            ]\n" +
             "        },\n" +
             "        {\n" +
             "            \"coding\": [\n" +
             "                {\n" +
             "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
             "                    \"code\": \"11333\",\n" +
             "                    \"display\": \"CONSULTA MEDICA DE URGENCIA\"\n" +
             "                }\n" +
             "            ]\n" +
             "        },\n" +
             "        {\n" +
             "            \"coding\": [\n" +
             "                {\n" +
             "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
             "                    \"code\": \"11467\",\n" +
             "                    \"display\": \"CONSULTA MEDICA AMBULATORIA.\"\n" +
             "                }\n" +
             "            ]\n" +
             "        }\n" +
             "    ],\n" +
             "    \"serviceType\": {\n" +
             "        \"coding\": [\n" +
             "            {\n" +
             "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
             "                \"code\": \"1\",\n" +
             "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
             "            }\n" +
             "        ]\n" +
             "    },\n" +
             "    \"priority\": {\n" +
             "        \"coding\": [\n" +
             "            {\n" +
             "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
             "                \"code\": \"MUU\"\n" +
             "            }\n" +
             "        ]\n" +
             "    },\n" +
             "    \"subject\": {\n" +
             "        \"reference\": \"Patient/2615\",\n" +
             "        \"display\": \"COM472, GEO472\"\n" +
             "    },\n" +
             "    \"participant\": [\n" +
             "        {\n" +
             "            \"individual\": {\n" +
             "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
             "                \"display\": \"Dr ALEJANDRO MUNYO - MEDICO GENERAL\"\n" +
             "            }\n" +
             "        }\n" +
             "    ],\n" +
             "    \"period\": {\n" +
             "        \"start\": \"2022-09-13T11:52:36\",\n" +
             "        \"end\": \"2023-09-24T14:26:11\"\n" +
             "    },\n" +
             "    \"location\": [\n" +
             "        {\n" +
             "            \"location\": {\n" +
             "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
             "                \"display\": \"GEOCOM-HOSPITAL-SERVICIO DE EMERGENCIA-PUERTA DE EMERGENCIA\"\n" +
             "            }\n" +
             "        }\n" +
             "    ],\n" +
             "    \"serviceProvider\": {\n" +
             "        \"reference\": \"Organization/3\",\n" +
             "        \"display\": \"GEOCOM\"\n" +
             "    },\n" +
             "    \"partOf\": {\n" +
             "        \"reference\": \"Encounter/0\"\n" +
             "    }\n" +
             "}";

            response = request.when().body(requestBodyEncounter).put("/Encounter/1-614296").then().log().all().extract().response();
    }

    @Then("I can validate I receive a valid value {int}")
    public void iCanValidateIReceiveAValidValue(int statusCodeValue) {
        response.then().statusCode(statusCodeValue);
       // System.out.println("The status received: " + response.statusLine());

    }

    @Given("I send a GET request to the endpoint Test")
    public void iSendAGETRequestToTheEndpointTest() {
        request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
                .contentType(ContentType.JSON);
      response=  request.get("/Encounter/1-614355");
    }

    @Then("I send a GET Encounter request Test")
    public void iSendAGETEncounterRequestTest() {
        Headers headers=response.getHeaders();
        int statusCod= response.getStatusCode();
        String body=response.getBody().asString();
        String contentType=response.getContentType();
        assertThat(statusCod,equalTo(HttpStatus.SC_OK));
        System.out.println(headers);
        System.out.println(statusCod);
        System.out.println(body);
        System.out.println(contentType);
    }

    @Given("I send to the endpoint Fhir")
    public void iSendToTheEndpointFhir() {
        request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir");
    }

    @Then("I send to the endpoint to create a new Encounter")
    public void iSendToTheEndpointToCreateANewEncounter() {
        request.basePath("/Encounter")
                .contentType(ContentType.JSON);
    }
    @Then("I send a POST request and it completes with the status value is not Unknown for example planned")
    public void iSendAPOSTRequestAndItCompletesWithTheStatusValueIsNotUnknownForExamplePlanned() {

    /*    EncounterParameters encounter= EncounterBuilder.with()
                .resourceType("Encounter")
                .identifier(
                        (List<IdentifierItem>) IdentifierItemBuilder
                                .withIdentifierItem()
                                .useIdentifierContainedItem("dvsd")
                                .systemIdentifierContainedItem("dgd")
                                .valueIdentifierContainedItem("fbbfbd")
                                .buildIdentifierItem())
                .

                .addressContainedItem().buildEncounterParameter();

        IdentifierItem identifierItemParam= IdentifierItemBuilder
                .withIdentifierItem()
                .systemIdentifierContainedItem("ve")
                .useIdentifierContainedItem("eww")
                .valueIdentifierContainedItem("efwe")
                .buildIdentifierItem();


        JsonObject requestParametersEncounter=new JsonObject();
        requestParametersEncounter.add(identifierItemParam);

        List<IdentifierItem> identifierItems=new ArrayList<>();
        if (identifierItems.size()>1){
            int i=0;
          for(i=0;i<=identifierItems.size();i++){
              identifierItems.add()
          }
        }

*/

        String requestBodyEncounterStatusIsNotUnKnow="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"VariosActosAsist_POST_Yanis3\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"in-progress\",\n" +
                "    \"class\": {\n" +
                "        \"system\": \"http://terminology.pruebaAgustin.org/CodeSystem/v3-ActCode\",\n" +
                "        \"code\": \"AMB\",\n" +
                "        \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "   \"type\": [\n" +
                "       {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"11333\",\n" +
                "\n" +
                "                   \"display\": \"11333 - ACTO ASISTENCIAL TEST\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"4567\",\n" +
                "\n" +
                "                   \"display\": \"CONS CIRUJANO\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"3390\",\n" +
                "\n" +
                "                   \"display\": \"CONS RADIOLOGIA\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       }\n" +
                "   ],\n" +
                "\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/2615\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-09-13T11:52:36\",\n" +
                "        \"end\":\"2023-09-09T12:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/3\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
                "                \"display\": \"CONSULTA\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}\n" +
                "\n";

        response = request.when().body(requestBodyEncounterStatusIsNotUnKnow).post().then().log().all().extract().response();

    }

    @Then("I can validate I receive a valid status code {int}")
    public void iCanValidateIReceiveAValidStatusCode(int statusCode) {

        Assert.assertEquals(response.getStatusCode(),statusCode);

    }
    @And("I verify that message is {string}")
    public void iVerifyThatMessageIs(String messageError) {
        //Retrieving the response body using getBody() method
        ResponseBody body = response.getBody();
        //Converting the response body to string object
        String responseBody=body.asString();
        //Creating object of JsonPath and passing the string response body as parameter
       //JsonPath jsonPath=new JsonPath(responseBody);
        //Storing publisher name in a string variable
      // String diagnostics=jsonPath.getString("diagnostics");
        Assertions.assertTrue(responseBody.contains("El alta de Encounter solo acepta estado 'unknown'"), messageError);
      System.out.println("The diagnostics is: "+responseBody);
    }
    @Then("I send a POST request and leave status value empty")
    public void iSendAPOSTRequestAndLeaveStatusValueEmpty() {

         String requestBodyEncounterStatusIsNotUnKnow="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"VariosActosAsist_POST_Yanis8\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"\",\n" +
                "    \"class\": {\n" +
                "        \"system\": \"http://terminology.pruebaAgustin.org/CodeSystem/v3-ActCode\",\n" +
                "        \"code\": \"AMB\",\n" +
                "        \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "   \"type\": [\n" +
                "       {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"11333\",\n" +
                "\n" +
                "                   \"display\": \"11333 - ACTO ASISTENCIAL TEST\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"4567\",\n" +
                "\n" +
                "                   \"display\": \"CONS CIRUJANO\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       },\n" +
                "        {\n" +
                "\n" +
                "           \"coding\": [\n" +
                "               {\n" +
                "\n" +
                "                   \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "\n" +
                "                   \"code\": \"3390\",\n" +
                "\n" +
                "                   \"display\": \"CONS RADIOLOGIA\"\n" +
                "\n" +
                "               }\n" +
                "\n" +
                "           ]\n" +
                "\n" +
                "       }\n" +
                "   ],\n" +
                "\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/2615\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-09-13T11:52:36\",\n" +
                "        \"end\":\"2023-09-09T12:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/3\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
                "                \"display\": \"CONSULTA\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}\n" +
                "\n";

        response = request.when().body(requestBodyEncounterStatusIsNotUnKnow).post().then().log().all().extract().response();

    }
    @Then("I send a POST request and it completes without not subject")
    public void iSendAPOSTRequestAndItCompletesWithoutNotSubject() {
        String requestBodyEncounterCodigoPersonaNoExiste="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Prueba-03_02-2022_2\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "    \"class\": {\n" +
                "        \"system\": \"http://terminology.pruebaAgustin.org/CodeSystem/v3-ActCode\",\n" +
                "        \"code\": \"AMB\",\n" +
                "        \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "    \"type\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "                    \"code\": \"12\",\n" +
                "                    \"display\": \"HEMOGLUTOTEST (HGT)\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2021-12-25T13:52:36\",\n" +
                "        \"end\":\"2021-12-25T15:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/3\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
                "                \"display\": \"CONSULTA\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}";
        response = request.when().body(requestBodyEncounterCodigoPersonaNoExiste).post().then().log().all().extract().response();
    }
    @And("I verify that message is {string} and the OS isn't created")
    public void iVerifyThatMessageIsAndTheOSIsnTCreated(String messageError) {
        //Retrieving the response body using getBody() method
        ResponseBody body = response.getBody();
        //Converting the response body to string object
        String responseBody=body.asString();
        //Creating object of JsonPath and passing the string response body as parameter
        //JsonPath jsonPath=new JsonPath(responseBody);
        //Storing publisher name in a string variable
        // String diagnostics=jsonPath.getString("diagnostics");
        Assertions.assertTrue(responseBody.contains("El código de Persona 0 no existe."), messageError);
        System.out.println("The diagnostics is: "+responseBody);
    }
    @Then("I send a POST request and it completes without order type service")
    public void iSendAPOSTRequestAndItCompletesWithoutOrderTypeService() {

        String requestBodyEncounterWithoutCodeTypeService="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Prueba-03_02-2022_2\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "    \"class\": {\n" +
                "        \"system\": \"http://terminology.pruebaAgustin.org/CodeSystem/v3-ActCode\",\n" +
                "        \"code\": \"AMB\",\n" +
                "        \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "    \"type\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                    \n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"https://www.hl7.org/fhir/v3/ActPriority/vs.html\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/4510\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2021-12-25T13:52:36\",\n" +
                "        \"end\":\"2021-12-25T15:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/3\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-1-3\",\n" +
                "                \"display\": \"CONSULTA\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}";
        response = request.when().body(requestBodyEncounterWithoutCodeTypeService).post().then().log().all().extract().response();
    }

    @And("I verify that message is {string} and the OS isn't created without code")
    public void iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutCode(String messageError) {

        ResponseBody body = response.getBody();
        String responseBody=body.asString();
        Assertions.assertTrue(responseBody.contains("Debe indicar System y Code para serviceType"), messageError);
        System.out.println("The diagnostics is: "+responseBody);
    }

    /*
    @Given("I send to the endpoint Fhir Test")
    public void iSendToTheEndpointFhirTest() {
       /* request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir");
        encounterFacade.iSendToTheEndpointFhirTest();

    }
    @Then("I send to the endpoint to create a new Encounter Test")
    public void iSendToTheEndpointToCreateANewEncounterTest() {
        encounterFacade.iSendToTheEndpointToCreateANewEncounterTest();
    }

    @Then("I send a POST request and it completes without act of care")
    public void iSendAPOSTRequestAndItCompletesWithoutActOfCare() {
        encounterFacade.iSendAPOSTRequestAndItCompletesWithoutActOfCare();
    }

    @Then("I can validate I receive a valid status code {int} Test")
    public void iCanValidateIReceiveAValidStatusCodeTest(int codeError) {
        encounterFacade.iCanValidateIReceiveAValidStatusCodeTest(codeError);
    }

    @And("I verify that message is {string} and the OS isn't created without act of care")
    public void iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutActOfCare(String messageError) {
        encounterFacade.iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutActOfCare(messageError);
    }
*/
    @Then("I send to the endpoint to consult GET by Encounter with incorrect format")
    public void iSendToTheEndpointToConsultGETByEncounterWithIncorrectFormat() {
        response= request
        .when()
        .get("Encouner/1-614355");
    }

    @And("I verify that error message is {string}")
    public void iVerifyThatErrorMessageIs(String messageError) {
        //Retrieving the response body using getBody() method
        ResponseBody body = response.getBody();
        //Converting the response body to string object
        String responseBody=body.asString();
        Assertions.assertTrue(responseBody.contains(messageError));
        System.out.println("The diagnostics is: "+responseBody);
    }

    @Then("I send a POST request and it completes without act of care")
    public void iSendAPOSTRequestAndItCompletesWithoutActOfCare() {
        String requestBodyEncounterWithoutCodeTypeService="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Prueba9_Yanis\"\n" +
                "        }\n" +
                "        \n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "\n" +
                "   \"class\": {\n" +
                "    \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActCode\",\n" +
                "    \"code\": \"AMB\",\n" +
                "    \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "    \"type\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                  \n" +
                "                   \n" +
                "                    \"display\": \"CONSULTA MEDICA DE URGENCIA\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\":\"http://terminology.hl7.org/ValueSet/v3-ActPriority\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/4012\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-02-03T11:22:36\",\n" +
                "        \"end\":\"2022-02-03T11:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/2\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-3-1\",\n" +
                "                \"display\": \"Hospital\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}";
        response = request.when().body(requestBodyEncounterWithoutCodeTypeService).post().then().log().all().extract().response();
    }

    @Then("I send a POST request and it complete with incorrectly formatted Period.Start")
    public void iSendAPOSTRequestAndItCompleteWithIncorrectlyFormattedPeriodStart() {
        String requestBodyEncounterWithoutCodeTypeService="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Prueba9_Yanis\"\n" +
                "        }\n" +
                "        \n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "\n" +
                "   \"class\": {\n" +
                "    \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActCode\",\n" +
                "    \"code\": \"AMB\",\n" +
                "    \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "    \"type\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "                    \"code\": \"11333\",\n" +
                "                    \"display\": \"CONSULTA MEDICA DE URGENCIA\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\":\"http://terminology.hl7.org/ValueSet/v3-ActPriority\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/4012\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"202-02-03T11:22:36\",\n" +
                "        \"end\":\"2022-02-03T11:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/2\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-3-1\",\n" +
                "                \"display\": \"Hospital\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}";
        response = request.when().body(requestBodyEncounterWithoutCodeTypeService).post().then().log().all().extract().response();
    }

    @Then("I send a POST request and it leaves the field in Period. start it empty")
    public void iSendAPOSTRequestAndItLeavesTheFieldInPeriodStartItEmpty() {
        String requestBodyEncounterWithoutCodeTypeService="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Prueba9_Yanis\"\n" +
                "        }\n" +
                "        \n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "\n" +
                "   \"class\": {\n" +
                "    \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActCode\",\n" +
                "    \"code\": \"AMB\",\n" +
                "    \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "    \"type\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "                    \"code\": \"11333\",\n" +
                "                    \"display\": \"CONSULTA MEDICA DE URGENCIA\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\":\"http://terminology.hl7.org/ValueSet/v3-ActPriority\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/4012\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"\",\n" +
                "        \"end\":\"2022-02-03T11:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/2\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-3-1\",\n" +
                "                \"display\": \"Hospital\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}";
        response = request.when().body(requestBodyEncounterWithoutCodeTypeService).post().then().log().all().extract().response();

    }

    @Then("I send a POST request without consultation reason")
    public void iSendAPOSTRequestWithoutConsultationReason() {
        String requestBodyEncounterWithoutCodeTypeService="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Prueb45_Yanis\"\n" +
                "        }\n" +
                "        \n" +
                "    ],\n" +
                "    \"status\": \"unknown\",\n" +
                "\n" +
                "   \"class\": {\n" +
                "    \"system\": \"http://terminology.hl7.org/CodeSystem/v3-ActCode\",\n" +
                "    \"code\": \"AMB\",\n" +
                "    \"display\": \"ambulatory\"\n" +
                "    },\n" +
                "    \"type\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                    \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/ActoAsistencial\",\n" +
                "                    \"code\": \"11333\",\n" +
                "                    \"display\": \"CONSULTA MEDICA DE URGENCIA\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceType\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"http://fhir.geocom.com.uy/r4/CodeSystem/TipoOrdenServicio\",\n" +
                "                \"code\": \"1\",\n" +
                "                \"display\": \"PUERTA DE EMERGENCIA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\":\"http://terminology.hl7.org/ValueSet/v3-ActPriority\",\n" +
                "                \"code\": \"MUU\",\n" +
                "                \"display\": \"MUY URGENTE\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/2084\",\n" +
                "        \"display\": \"\"\n" +
                "    },\n" +
                "    \"participant\": [\n" +
                "        {\n" +
                "            \"individual\": {\n" +
                "                \"reference\": \"PractitionerRole/2267-1-20120101\",\n" +
                "                \"display\": \"Dra. PEREZ, JOSEFINA - MEDICO GENERAL\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-11-14T11:22:36\",\n" +
                "        \"end\":\"2023-02-03T11:52:36\"\n" +
                "    },\n" +
                "    \"hospitalization\": {\n" +
                "        \"origin\": {\n" +
                "            \"reference\": \"Organization/2\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"location\": [\n" +
                "        {\n" +
                "            \"location\": {\n" +
                "                \"reference\": \"Location/wa-3-2-3-1\",\n" +
                "                \"display\": \"Hospital\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceProvider\": {\n" +
                "        \"reference\": \"Organization/3\"\n" +
                "    },\n" +
                "    \"partOf\": {\n" +
                "        \"reference\": \"Encounter/0\"\n" +
                "    }\n" +
                "}";
        response = request.when().body(requestBodyEncounterWithoutCodeTypeService).post().then().log().all().extract().response();

    }

    @Then("I send a GET Encounter request with Encounter created")
    public void iSendAGETEncounterRequestWithEncounterCreated() {
        request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
                .contentType(ContentType.JSON);
       response = request.get("/Encounter/1-614355");
        //Retrieving the response body using getBody() method
        String ContentLocation = response.getContentType();
        System.out.println("The diagnostics is: "+ContentLocation);
        request.get(ContentLocation);
    }
}
