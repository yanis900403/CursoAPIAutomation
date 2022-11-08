package uy.com.geocom.automation.geosaludServicios.resources.encounter;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders.EncounterBuilder;
import uy.com.geocom.automation.geosaludServicios.resources.encounter.Interfaces.EncounterManager;
import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class EncounterGSSManager implements EncounterManager {

    private RequestSpecification request;
    private Response response;

    private ValidatableResponse json;

    @Override
    public EncounterBuilder resourceType(String resourceType) {
        return null;
    }

    @Override
    public EncounterBuilder identifier(List<IdentifierItem> identifier) {
        return null;
    }

    @Override
    public EncounterBuilder type(List<TypeItem> type) {
        return null;
    }

    @Override
    public EncounterBuilder serviceType(ServiceType serviceType) {
        return null;
    }

    @Override
    public EncounterBuilder partOf(PartOf partOf) {
        return null;
    }

    @Override
    public EncounterBuilder period(Period period) {
        return null;
    }

    @Override
    public EncounterBuilder hospitalization(Hospitalization hospitalization) {
        return null;
    }

    @Override
    public EncounterBuilder subject(Subject subject) {
        return null;
    }

    @Override
    public EncounterBuilder reasonCode(List<ReasonCodeItem> reasonCode) {
        return null;
    }

    @Override
    public EncounterBuilder priority(Priority priority) {
        return null;
    }

    @Override
    public EncounterBuilder participant(List<ParticipantItem> participant) {
        return null;
    }

    @Override
    public EncounterBuilder serviceProvider(ServiceProvider serviceProvider) {
        return null;
    }

    @Override
    public EncounterBuilder location(List<LocationItem> location) {
        return null;
    }

    @Override
    public EncounterBuilder contained(List<ContainedItem> contained) {
        return null;
    }

    @Override
    public EncounterBuilder id(String id) {
        return null;
    }

    @Override
    public EncounterBuilder jsonMemberClass(JsonMemberClass jsonMemberClass) {
        return null;
    }

    @Override
    public EncounterBuilder status(String status) {
        return null;
    }

    @Override
    public EncounterParameters buildEncounterParameter() {
        return null;
    }

    @Override
    public IdentifierItem buildIdentifierItem() {
        return null;
    }

    @Override
    public void iSendToTheEndpointFhirTest() {
        request = given()
                .log().all() //loguear la respuesta
                .baseUri("https://geosaludtestha.geocom.com.uy/hapigeosalud/fhir");
    }

    @Override
    public void iSendToTheEndpointToCreateANewEncounterTest() {
        request.basePath("/Encounter")
                .contentType(ContentType.JSON);
    }

    @Override
    public void iSendAPOSTRequestAndItCompletesWithoutActOfCare() {
        String requestBodyEncounterStatusIsNotUnKnow="{\n" +
                "    \"resourceType\": \"Encounter\",\n" +
                "    \"identifier\": [\n" +
                "        {\n" +
                "            \"value\": \"VariosActosAsist_POST_Yanis55\"\n" +
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

        response = request.when().body(requestBodyEncounterStatusIsNotUnKnow).post().then().log().all().extract().response();

    }

    @Override
    public void iCanValidateIReceiveAValidStatusCodeTest(int codeError) {
        Assert.assertEquals(response.getStatusCode(),500);
    }

    @Override
    public void iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutActOfCare(String messageError) {
        ResponseBody body = response.getBody();
        String responseBody=body.asString();
        Assertions.assertTrue(responseBody.contains("Parametro obligatorio ActAsistId vacio"), messageError);
        System.out.println("The diagnostics is: "+responseBody);
    }
}
