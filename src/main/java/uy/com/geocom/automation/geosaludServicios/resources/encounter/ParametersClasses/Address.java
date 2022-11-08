package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

import java.util.List;

public class Address{
	private String country;
	private String city;
	private String use;
	private List<String> line;
	private String postalCode;
	private String text;
	private String state;
	private String type;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setUse(String use){
		this.use = use;
	}

	public String getUse(){
		return use;
	}

	public void setLine(List<String> line){
		this.line = line;
	}

	public List<String> getLine(){
		return line;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}