package uy.com.geocom.automation.geosaludServicios.resources.flat;

import lombok.Data;
import lombok.experimental.Builder;

import java.util.List;


@Data
@Builder
public class FlagParameters{
	
	private List<IdentifierItem> identifier;
	private Period period;
	private Code code;
	private Subject subject;
	private Encounter encounter;
	private List<CategoryItem> category;
	private String resourceType;
	private String status;


	/*

	public void setIdentifier(List<IdentifierItem> identifier){
		this.identifier = identifier;
	}

	public List<IdentifierItem> getIdentifier(){
		return identifier;
	}


	public void setPeriod(Period period){
		this.period = period;
	}

	public Period getPeriod(){
		return period;
	}


	public void setCode(Code code){
		this.code = code;
	}

	public Code getCode(){
		return code;
	}


	public void setSubject(Subject subject){
		this.subject = subject;
	}

	public Subject getSubject(){
		return subject;
	}


	public void setEncounter(Encounter encounter){
		this.encounter = encounter;
	}

	public Encounter getEncounter(){
		return encounter;
	}


	public void setCategory(List<CategoryItem> category){
		this.category = category;
	}

	public List<CategoryItem> getCategory(){
		return category;
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

	 */
}