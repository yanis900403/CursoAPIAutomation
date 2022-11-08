package uy.com.geocom.automation.geosaludServicios.resources.encounter.Interfaces;
//Se crea esta clase interfaz para guiar a la persona que vaya a consumir el EncounterBuilder.
// De esta forma se guía a la persona para crear el objeto Encounter con un orden específico

import uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders.EncounterBuilder;
import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.*;

import java.util.List;

public interface EncounterManager {


//Se va a tener  métodos que van a retornar nuestro builder

    EncounterBuilder resourceType (String resourceType);
    EncounterBuilder  identifier(List<IdentifierItem> identifier);
    EncounterBuilder type(List<TypeItem> type);
    EncounterBuilder serviceType(ServiceType serviceType);
    EncounterBuilder partOf(PartOf partOf);
    EncounterBuilder period(Period period);
    EncounterBuilder hospitalization(Hospitalization hospitalization);
    EncounterBuilder subject(Subject subject);
    EncounterBuilder reasonCode(List<ReasonCodeItem> reasonCode);
    EncounterBuilder priority(Priority priority);
    EncounterBuilder participant(List<ParticipantItem> participant);
    EncounterBuilder serviceProvider(ServiceProvider serviceProvider);
    EncounterBuilder location(List<LocationItem> location);
    EncounterBuilder contained(List<ContainedItem> contained);
    EncounterBuilder id(String id);
    EncounterBuilder jsonMemberClass(JsonMemberClass jsonMemberClass);
    EncounterBuilder status(String status);
    EncounterParameters buildEncounterParameter();

    //IdentifierItem
    IdentifierItem buildIdentifierItem();


    void iSendToTheEndpointFhirTest();

    void iSendToTheEndpointToCreateANewEncounterTest();

    void iSendAPOSTRequestAndItCompletesWithoutActOfCare();

    void iCanValidateIReceiveAValidStatusCodeTest(int codeError);

    void iVerifyThatMessageIsAndTheOSIsnTCreatedWithoutActOfCare(String messageError);
}
