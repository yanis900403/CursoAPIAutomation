package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.CodingItem;

import java.util.List;

public class ReasonCodeItem{
	private List<CodingItem> coding;
	private String text;

	public void setCoding(List<CodingItem> coding){
		this.coding = coding;
	}

	public List<CodingItem> getCoding(){
		return coding;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}
}