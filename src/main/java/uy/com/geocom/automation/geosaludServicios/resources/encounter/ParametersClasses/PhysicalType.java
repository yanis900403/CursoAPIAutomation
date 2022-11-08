package uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.CodingItem;

import java.util.List;

public class PhysicalType{
	private List<CodingItem> coding;

	public void setCoding(List<CodingItem> coding){
		this.coding = coding;
	}

	public List<CodingItem> getCoding(){
		return coding;
	}
}