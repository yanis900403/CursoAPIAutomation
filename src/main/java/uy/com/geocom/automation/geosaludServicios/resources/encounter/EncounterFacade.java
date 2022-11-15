package uy.com.geocom.automation.geosaludServicios.resources.encounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterFacade {
    @Autowired
 EncounterManager encounterManager;

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
