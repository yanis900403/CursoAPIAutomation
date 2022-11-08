package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

public class CodingItem{
	private String system;
	private String code;
	private String display;

	public void setSystem(String system){
		this.system = system;
	}

	public String getSystem(){
		return system;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setDisplay(String display){
		this.display = display;
	}

	public String getDisplay(){
		return display;
	}
}
