package uy.com.geocom.automation.geosaludServicios.resources.flat;

import java.util.List;

public class CategoryItem{
	private List<CodingItem> coding;

	public void setCoding(List<CodingItem> coding){
		this.coding = coding;
	}

	public List<CodingItem> getCoding(){
		return coding;
	}
}