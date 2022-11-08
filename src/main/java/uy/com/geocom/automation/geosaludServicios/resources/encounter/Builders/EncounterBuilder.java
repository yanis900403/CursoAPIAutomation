package uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.*;

import java.util.List;
//Clase EncounterBuilder que nos permite construir un recurso Encounter
public class EncounterBuilder /*implements EncounterManager, IdentifierItemManager, CodingItemManager*/ {

    private EncounterParameters encounterParameters=new EncounterParameters();
   // private CodingItem codingItem=new CodingItem();
    private Hospitalization hospitalization=new Hospitalization();
    private Origin origin=new Origin();
   // private IdentifierItem identifierItem=new IdentifierItem();
    private JsonMemberClass jsonMemberClass=new JsonMemberClass();
    private ServiceType serviceType=new ServiceType();
    private TypeItem typeItem=new TypeItem();
    private Priority priority=new Priority();
    private Subject subject=new Subject();
    private ReasonCodeItem reasonCodeItem=new ReasonCodeItem();
    private ParticipantItem participantItem=new ParticipantItem();
    private Individual individual=new Individual();
    private Period period=new Period();
    private Location location=new Location();
    private LocationItem locationItem=new LocationItem();
    private ContainedItem containedItem=new ContainedItem();
    private Address address=new Address();
    private ManagingOrganization managingOrganization=new ManagingOrganization();
    private PhysicalType physicalType=new PhysicalType();
    private TelecomItem telecomItem=new TelecomItem();
    private ServiceProvider serviceProvider=new ServiceProvider();
    private PartOf partOf=new PartOf();



     //retorna una instancia del mismo builder, para que nos de el encadenamiento
    //El with() que es el método de entrada, tiene que retornar la interfaz(EncounterManager)
  /*  public static EncounterManager with(){

        return new EncounterBuilder();
    }
*/

    //propiedades partof

    public EncounterBuilder referencePartOf(String referencePartOf){
        this.partOf.setReference(referencePartOf);
        return this;
    }
    public PartOf buildPartOf(){
        return partOf;
    }

    //propiedades serviceProvider
    public EncounterBuilder referenceServiceProvider(String referenceServiceProvider){
        this.serviceProvider.setReference(referenceServiceProvider);
        return this;
    }
    public EncounterBuilder displayServiceProvider(String displayServiceProvider){
        this.serviceProvider.setDisplay(displayServiceProvider);
        return this;
    }
    public ServiceProvider buildServiceProvider(){
        return serviceProvider;
    }

    //propiedades, valores del objeto telecomItem que se encuentra dentro del objeto ContainedItem
    public EncounterBuilder systemItemTelecomContainedItem(String systemItemTelecomContainedItem){
        this.telecomItem.setSystem(systemItemTelecomContainedItem);
        return this;
    }
    public EncounterBuilder valueItemTelecomContainedItem(String valueItemTelecomContainedItem){
        this.telecomItem.setValue(valueItemTelecomContainedItem);
        return this;
    }
    public TelecomItem buildTelecomItem(){
        return telecomItem;
    }


    //propiedades physicalType
    public EncounterBuilder codingPhysicalType(List<CodingItem> codingPhysicalType){
        this.physicalType.setCoding(codingPhysicalType);
        return this;
    }
    public PhysicalType buildPhysicalType(){
        return physicalType;
    }

    //propiedades managingOrganization
    public EncounterBuilder referenceManagingOrganization(String referenceManagingOrganization){
        this.managingOrganization.setReference(referenceManagingOrganization);
        return this;
    }
    public EncounterBuilder displayManagingOrganization(String displayManagingOrganization){
        this.managingOrganization.setDisplay(displayManagingOrganization);
        return this;
    }
    public ManagingOrganization buildManagingOrganization(){
        return managingOrganization;
    }

    //propiedades Address
    public EncounterBuilder countryAddress(String countryAddress){
        this.address.setCountry(countryAddress);
        return this;
    }
    public EncounterBuilder cityAddress(String cityAddress){
        this.address.setCity(cityAddress);
        return this;
    }
    public EncounterBuilder useAddress(String useAddress){
        this.address.setUse(useAddress);
        return this;
    }
  /*  public EncounterBuilder lineListAddress(List<String> lineListAddress){
        this.address.setLine(lineListAddress);
        return this;
    }*/
    public EncounterBuilder lineListAddress(String lineListAddress){
        this.address.getLine().add(lineListAddress);
        return this;
    }
    public EncounterBuilder postalCodeAddress(String postalCodeAddress){
        this.address.setPostalCode(postalCodeAddress);
        return this;
    }
    public EncounterBuilder textAddress(String textAddress){
        this.address.setText(textAddress);
        return this;
    }
    public EncounterBuilder stateAddress(String stateAddress){
        this.address.setState(stateAddress);
        return this;
    }
    public EncounterBuilder typeAddress(String typeAddress){
        this.address.setType(typeAddress);
        return this;
    }
    public Address buildAddress(){
        return address;
    }


    //propiedades identifierItem
    /*
    public EncounterBuilder systemIdentifierContainedItem(String systemIdentifierItem){
        this.identifierItem.setSystem(systemIdentifierItem);
        return this;
    }
    public EncounterBuilder useIdentifierContainedItem(String useIdentifierItem){
        this.identifierItem.setUse(useIdentifierItem);
        return this;
    }
    public EncounterBuilder valueIdentifierContainedItem(String valueIdentifierItem){
        this.identifierItem.setValue(valueIdentifierItem);
        return this;
    }
    public IdentifierItem buildIdentifierItem(){
        return identifierItem;
    }
*/
    //propiedades  containedItem
    public EncounterBuilder modeContainedItem(String modeContainedItem){
        this.containedItem.setMode(modeContainedItem);
        return this;
    }
    public EncounterBuilder identifierListContainedItem(List<IdentifierItem> identifierListContainedItem){
        this.containedItem.setIdentifier(identifierListContainedItem);
        return this;
    }
    public EncounterBuilder addressContainedItem(Address addressContainedItem){
        this.containedItem.setAddress(addressContainedItem);
        return this;
    }
    public EncounterBuilder managingOrganizationContainedItem(ManagingOrganization managingOrganizationContainedItem){
        this.containedItem.setManagingOrganization(managingOrganizationContainedItem);
        return this;
    }
    public EncounterBuilder nameContainedItem(String nameContainedItem){
        this.containedItem.setName(nameContainedItem);
        return this;
    }
    public EncounterBuilder physicalTypeContainedItem(PhysicalType physicalTypeContainedItem){
        this.containedItem.setPhysicalType(physicalTypeContainedItem);
        return this;
    }
    public EncounterBuilder descriptionContainedItem(String descriptionContainedItem){
        this.containedItem.setDescription(descriptionContainedItem);
        return this;
    }
    public EncounterBuilder telecomListContainedItem(List<TelecomItem> telecomListContainedItem){
        this.containedItem.setTelecom(telecomListContainedItem);
        return this;
    }
    public EncounterBuilder idContainedItem(String idContainedItem){
        this.containedItem.setId(idContainedItem);
        return this;
    }
    public EncounterBuilder typeListContainedItem(List<TypeItem> typeListContainedItem){
        this.containedItem.setType(typeListContainedItem);
        return this;
    }
    public EncounterBuilder resourceTypeContainedItem(String resourceTypeContainedItem){
        this.containedItem.setResourceType(resourceTypeContainedItem);
        return this;
    }
    public EncounterBuilder statusContainedItem(String statusContainedItem){
        this.containedItem.setStatus(statusContainedItem);
        return this;
    }
    public ContainedItem buildContainedItem(){
        return containedItem;
    }

    //propiedades location
    public EncounterBuilder referenceLocation(String referenceLocation){
        this.location.setReference(referenceLocation);
        return this;
    }
    public EncounterBuilder displayLocation(String displayLocation){
        this.location.setDisplay(displayLocation);
        return this;
    }
    public Location buildLocation(){
        return location;
    }

    //propiedades locationItem
    public EncounterBuilder locationItem(Location locationItem){
        this.locationItem.setLocation(locationItem);
        return this;
    }
    public LocationItem buildLocationItem(){
        return locationItem;
    }

    //propiedades period
    public EncounterBuilder startPeriod(String startPeriod){
        this.period.setStart(startPeriod);
        return this;
    }
    public EncounterBuilder endPeriod(String endPeriod){
        this.period.setEnd(endPeriod);
        return this;
    }
    public Period buildPeriod(){
        return period;
    }

    //propiedades individual
    public EncounterBuilder referenceIndividual(String referenceIndividual){
        this.individual.setReference(referenceIndividual);
        return this;
    }
    public EncounterBuilder displayIndividual(String displayIndividual){
        this.individual.setDisplay(displayIndividual);
        return this;
    }
    public Individual buildIndividual(){
        return individual;
    }

    //propiedades participantItem
    public EncounterBuilder individualParticipantItem(Individual individualParticipantItem){
        this.participantItem.setIndividual(individualParticipantItem);
        return this;
    }
    public ParticipantItem buildParticipantItem(){
        return participantItem;
    }

    //propiedades reasonCodeItem
    public EncounterBuilder codingReasonCodeItem(List<CodingItem> coding){
        this.reasonCodeItem.setCoding(coding);
        return this;
    }
    public EncounterBuilder textReasonCodeItem(String textReasonCodeItem){
        this.reasonCodeItem.setText(textReasonCodeItem);
        return this;
    }
    public ReasonCodeItem buildReasonCodeItem(){
        return reasonCodeItem;
    }

    //propiedades subject
    public EncounterBuilder referenceSubject(String referenceSubject){
        this.subject.setReference(referenceSubject);
        return this;
    }
    public EncounterBuilder displaySubject(String displaySubject){
        this.subject.setReference(displaySubject);
        return this;
    }
    public Subject buildSubject(){
        return subject;
    }

    //propiedades priority
    public EncounterBuilder codingPriority(List<CodingItem> codingPriority){
        this.priority.setCoding(codingPriority);
        return this;
    }
    public Priority buildPriority(){
        return priority;
    }

    //propiedades typeItem
    public EncounterBuilder codingTypeItem(List<CodingItem> coding){
        this.typeItem.setCoding(coding);
        return this;
    }
    public TypeItem buildTypeItem(){
        return typeItem;
    }


    //propiedades serviceType
public EncounterBuilder coding(List<CodingItem> coding){
        this.serviceType.setCoding(coding);
        return this;
}
    public ServiceType buildServiceType(){
        return serviceType;
    }

//propiedades jsonMemberClass

public EncounterBuilder systemMemberClass(String system){
        this.jsonMemberClass.setSystem(system);
        return this;
}

public EncounterBuilder codeMemberClass(String code){
        this.jsonMemberClass.setCode(code);
        return this;
}
    public JsonMemberClass buildJsonMemberClass(){
        return jsonMemberClass;
    }

    //propiedades origin
    public EncounterBuilder reference(String reference){
        this.origin.setReference(reference);
        return this;
    }

    public EncounterBuilder displayOrigin(String display){
        this.origin.setDisplay(display);
        return this;
    }
    public Origin buildOrigin(){
        return origin;
    }

    //propiedades hospitalization
public EncounterBuilder origin(Origin origin){
        this.hospitalization.setOrigin(origin);
        return this;
}
    public Hospitalization buildHospitalization(){
        return hospitalization;
    }

    //propiedades codingItem
/*
    public EncounterBuilder system(String system){
        this.codingItem.setSystem(system);
        return this;
    }

    public EncounterBuilder code(String code){
        this.codingItem.setCode(code);
        return this;
    }

    public EncounterBuilder displayCodingItem(String display){
        this.codingItem.setDisplay(display);
        return this;
    }
    public CodingItem buildCodingItem(){
        return codingItem;
    }
*/
    //propiedades encounterParameters

public EncounterBuilder serviceType(ServiceType serviceType)
{
        this.encounterParameters.setServiceType(serviceType);
        return this;
}

    public EncounterBuilder identifier(List<IdentifierItem> identifier){
        this.encounterParameters.setIdentifier(identifier);
        return this;
    }

    public EncounterBuilder type(List<TypeItem> type){
        this.encounterParameters.setType(type);
        return this;
            }

    public EncounterBuilder partOf(PartOf partOf){
        this.encounterParameters.setPartOf(partOf);
        return this;
    }

    public EncounterBuilder period(Period period){
        this.encounterParameters.setPeriod(period);
        return this;
    }

    public EncounterBuilder hospitalization(Hospitalization hospitalization){
        this.encounterParameters.setHospitalization(hospitalization);
        return this;
    }

    public EncounterBuilder subject(Subject subject){
        this.encounterParameters.setSubject(subject);
        return this;
    }

   public EncounterBuilder reasonCode(List<ReasonCodeItem> reasonCode){
        this.encounterParameters.setReasonCode(reasonCode);
        return this;
    }

    public EncounterBuilder priority(Priority priority){
        this.encounterParameters.setPriority(priority);
        return this;
    }

    public EncounterBuilder participant(List<ParticipantItem> participant){
        this.encounterParameters.setParticipant(participant);
        return this;
    }

    public EncounterBuilder serviceProvider(ServiceProvider serviceProvider){
        this.encounterParameters.setServiceProvider(serviceProvider);
        return this;
    }

    public EncounterBuilder location(List<LocationItem> location){
        this.encounterParameters.setLocation(location);
        return this;
    }

    public EncounterBuilder contained(List<ContainedItem> contained){
        this.encounterParameters.setContained(contained);
        return this;
    }
    public EncounterBuilder id(String id){
        this.encounterParameters.setId(id);
        return this;
    }

    public EncounterBuilder jsonMemberClass(JsonMemberClass jsonMemberClass){
        this.encounterParameters.setJsonMemberClass(jsonMemberClass);
        return this;
    }
    public EncounterBuilder resourceType(String resourceType){
        this.encounterParameters.setResourceType(resourceType);
        return this;
    }

    public EncounterBuilder status(String status){
        this.encounterParameters.setStatus(status);
        return this;
    }

    public EncounterParameters buildEncounterParameter(){
        return encounterParameters;
    }
}
