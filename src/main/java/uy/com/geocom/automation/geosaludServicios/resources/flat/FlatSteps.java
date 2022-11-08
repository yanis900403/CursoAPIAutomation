package uy.com.geocom.automation.geosaludServicios.resources.flat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;


public class FlatSteps {

   private static RequestSpecification request;
   private Response response;
    private FlagFacade flagFacade;
  // private FlagServiceManager jsonParametersFlag;

    FlagParameters newFlag= new FlagParameters();

   private ValidatableResponse json;
   private String response2=null ;

    private String responsePOST=null ;
    private String categoryJson=null;


    @Given("I send a GET request to the endpoint")
   public void iSendAGETRequestToTheEndpoint() {

    request = given()
            .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
            .contentType(ContentType.JSON);
}
    @Then("I get a {int} status code for flag {int}")
    public void iGetAStatusCodeForFlag(int expectedStatusCode, int flag) {
         response = request
                 .when()
                 .get("/Flag/26");
         json=response.then().statusCode(expectedStatusCode);
    }

    @Given("I send a GET request to the endpointTest")
    public void iSendAGETRequestToTheEndpointTest() {

        request = given()
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir/flag")
                .contentType(ContentType.JSON);
    }
    @Then("I send a GET request to the flag {int}")
    public void iSendAGETRequestToTheFlat(int flag) {
        response2 =request
               .when()
               .get("26").then().extract().body().asString();

    }


    @Then("I validate there is a value: {string} in the response")
    public void iValidateThereIsAValueInTheResponse(String category) {
          //    int idFlag=from(response2).get("id");
           //   int statusFlag=from(response2).get("status");
              categoryJson=from(response2).get("category[0].coding.code");
              //El findAll siempre se aplica sobre un arreglo. Ejemplo: [0]
        List<Map> listJson=from(response2).get("category.findAll {category -> coding.code = category }");
       // String code= listJson.get(0).get("code").toString();


   }

    @Given("I send a POST request to the endpoint")
    public void iSendAPOSTRequestToTheEndpoint() {

Map<String,Object> postFlag=new HashMap<String, Object>();
        postFlag.put("name","Alejandro" );
        postFlag.put("job","Customer Success" );

    response=  given()
            .baseUri("https://reqres.in/api")
              .log().all()
              .body(postFlag.toString())
              .when()
              .post("/users");

         //   FlagParameters flag=from(responsePOST).getObject("", FlagParameters.class);
    //  System.out.println(flag.getId());

    }
    @Then("I get a {int} status code")
    public void iGetAStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Given("I send a request to the endpoint Fhir")
    public void iSendARequestToTheEndpointFhir() {
        request = given()
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
                .contentType(ContentType.JSON);

    }

    @Given("I send to the endpoint Fhir to create a new Flag")
    public void iSendToTheEndpointFhirToCreateANewFlat() {

        request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir")
                .contentType(ContentType.JSON);
    }

    @Then("I send a POST request")
    public void iSendAPOSTRequest() {
        String requestBodyFlat="{\n" +
                "    \"resourceType\": \"Flag\",\n" +
                "   \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"Yanis test4\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"active\",\n" +
                "    \"category\": [\n" +
                "        {\n" +
                "            \"coding\": [\n" +
                "                {\n" +
                "                    \"system\": \"http://terminology.hl7.org/CodeSystem/flag-category\",\n" +
                "                    \"code\": \"clinical\",\n" +
                "                    \"display\": \"Clinical\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"code\": {\n" +
                "        \"coding\": [\n" +
                "            {\n" +
                "                \"system\": \"CodeSystem/TiposDeAviso\",\n" +
                "                \"code\": \"11\",\n" +
                "                \"display\": \"PruebaMay\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"subject\": {\n" +
                "        \"reference\": \"Patient/4604\",\n" +
                "        \"display\": \"ECHAZABAL ESTEVEZ, PABLO ALBERTO\"\n" +
                "    },\n" +
                "    \"period\": {\n" +
                "        \"start\": \"2022-10-15\",\n" +
                "        \"end\": \"2022-12-10\"\n" +
                "    }\n" +
                "}";

        response = request.when().body(requestBodyFlat).post("/Flag").then().log().all().extract().response();

    }

    @Then("I can validate response I receive a valid status code")
    public void iCanValidateResponseIReceiveAValidStatusCode() {
        response.then().statusCode(201);
        String jsonFlatPOST="";
        jsonFlatPOST=response.getContentType();

        System.out.println(jsonFlatPOST);
    }

 /*   @Then("I send a POST request to the endpoint to create a Flag")
    public void iSendAPOSTRequestToTheEndpointToCreateAFlag() {
        request = given()
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir/flag")
                .contentType(ContentType.JSON);
        RestAssured.given().log().all().body().when().post();
    }
*/
   /* @And("Complete parameters to create a new Flag")
    public void completeParametersToCreateANewFlag(DataTable jsonFlag) {
       List<Map<String,String>> jsonTable=jsonFlag.asMaps(String.class, String.class);
       flagFacade.completeJsonResourceFlag(jsonTable);
    }
*/
/*    @Then("I complete parameters to create a new Flag")
    public void iCompleteParametersToCreateANewFlag() {
        List<Map<String,Object>> jsonFlag=new ArrayList<Map<String, Object>>();
         jsonFlag.add(flagFacade.completeParametersJsonResourceFlag());

    }

*/
}
