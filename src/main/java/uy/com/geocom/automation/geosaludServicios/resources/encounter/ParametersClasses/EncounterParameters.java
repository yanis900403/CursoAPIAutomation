package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

import java.util.List;

public class EncounterParameters{
	private ServiceType serviceType;
	private List<IdentifierItem> identifier;
	private List<TypeItem> type;
	private PartOf partOf;
	private Period period;
	private Hospitalization hospitalization;
	private Subject subject;
	private List<ReasonCodeItem> reasonCode;
	private Priority priority;
	private List<ParticipantItem> participant;
	private ServiceProvider serviceProvider;
	private List<LocationItem> location;
	private List<ContainedItem> contained;
	private String id;
	private JsonMemberClass jsonMemberClass;
	private String resourceType;
	private String status;

	public void setServiceType(ServiceType serviceType){
		this.serviceType = serviceType;
	}

	public ServiceType getServiceType(){
		return serviceType;
	}

	public void setIdentifier(List<IdentifierItem> identifier){
		this.identifier = identifier;
	}

	public List<IdentifierItem> getIdentifier(){
		return identifier;
	}

	public void setType(List<TypeItem> type){
		this.type = type;
	}

	public List<TypeItem> getType(){
		return type;
	}
	public void setPartOf(PartOf partOf){
		this.partOf = partOf;
	}

	public PartOf getPartOf(){
		return partOf;
	}

	public void setPeriod(Period period){
		this.period = period;
	}

	public Period getPeriod(){
		return period;
	}

	public void setHospitalization(Hospitalization hospitalization){
		this.hospitalization = hospitalization;
	}

	public Hospitalization getHospitalization(){
		return hospitalization;
	}

	public void setSubject(Subject subject){
		this.subject = subject;
	}

	public Subject getSubject(){
		return subject;
	}
	public void setReasonCode(List<ReasonCodeItem> reasonCode){
		this.reasonCode = reasonCode;
	}

	public List<ReasonCodeItem> getReasonCode(){
		return reasonCode;
	}

	public void setPriority(Priority priority){
		this.priority = priority;
	}

	public Priority getPriority(){
		return priority;
	}

	public void setParticipant(List<ParticipantItem> participant){
		this.participant = participant;
	}

	public List<ParticipantItem> getParticipant(){
		return participant;
	}

	public void setServiceProvider(ServiceProvider serviceProvider){
		this.serviceProvider = serviceProvider;
	}

	public ServiceProvider getServiceProvider(){
		return serviceProvider;
	}

	public void setLocation(List<LocationItem> location){
		this.location = location;
	}

	public List<LocationItem> getLocation(){
		return location;
	}

	public void setContained(List<ContainedItem> contained){
		this.contained = contained;
	}

	public List<ContainedItem> getContained(){
		return contained;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJsonMemberClass(JsonMemberClass jsonMemberClass){
		this.jsonMemberClass = jsonMemberClass;
	}

	public JsonMemberClass getJsonMemberClass(){
		return jsonMemberClass;
	}

	public void setResourceType(String resourceType){
		this.resourceType = resourceType;
	}

	public String getResourceType(){
		return resourceType;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}


}