package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

public class IdentifierItem{
	private String system;
	private String use;
	private String value;

	public void setSystem(String system){
		this.system = system;
	}

	public String getSystem(){
		return system;
	}

	public void setUse(String use){
		this.use = use;
	}

	public String getUse(){
		return use;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
