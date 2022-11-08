package uy.com.geocom.automation.geosaludServicios.resources.encounter;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.Interfaces.EncounterManager;

public class EncounterFacade {

private EncounterManager encounterManager;
    public void iSendToTheEndpointFhirTest() {
        encounterManager.iSendToTheEndpointFhirTest();
    }

    public void iSendToTheEndpointToCreateANewEncounterTest() {
        encounterManager.iSendToTheEndpointToCreateANewEncounterTest();
    }

    public void iSendAPOSTRequestAndItCompletesWithoutActOfCare() {
        encounterManager.iSendAPOSTRequestAndItCompletesWithoutActOfCare();
    }

    public void iCanValidateIReceiveAValidStatusCodeTest(int codeError){
       encounterManager.iCanValidateIReceiveAValidStatusCodeTest(codeError);
    }

    public void iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutActOfCare(String messageError) {
        encounterManager.iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutActOfCare(messageError);
    }
}
