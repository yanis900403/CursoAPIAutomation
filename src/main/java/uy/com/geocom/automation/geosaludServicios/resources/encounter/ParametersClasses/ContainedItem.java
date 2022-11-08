package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

import java.util.List;

public class ContainedItem{
	private String mode;
	private List<IdentifierItem> identifier;
	private Address address;
	private ManagingOrganization managingOrganization;
	private String name;
	private PhysicalType physicalType;
	private String description;
	private List<TelecomItem> telecom;
	private String id;
	private List<TypeItem> type;
	private String resourceType;
	private String status;

	public void setMode(String mode){
		this.mode = mode;
	}

	public String getMode(){
		return mode;
	}

	public void setIdentifier(List<IdentifierItem> identifier){
		this.identifier = identifier;
	}

	public List<IdentifierItem> getIdentifier(){
		return identifier;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setManagingOrganization(ManagingOrganization managingOrganization){
		this.managingOrganization = managingOrganization;
	}

	public ManagingOrganization getManagingOrganization(){
		return managingOrganization;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPhysicalType(PhysicalType physicalType){
		this.physicalType = physicalType;
	}

	public PhysicalType getPhysicalType(){
		return physicalType;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTelecom(List<TelecomItem> telecom){
		this.telecom = telecom;
	}

	public List<TelecomItem> getTelecom(){
		return telecom;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(List<TypeItem> type){
		this.type = type;
	}

	public List<TypeItem> getType(){
		return type;
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