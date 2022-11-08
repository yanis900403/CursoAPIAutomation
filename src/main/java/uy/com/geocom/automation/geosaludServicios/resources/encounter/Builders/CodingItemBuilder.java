package uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.CodingItem;

public class CodingItemBuilder {

    private CodingItem codingItem=new CodingItem();

    //retorna una instancia del mismo builder, para que nos de el encadenamiento
    //El with() que es el método de entrada, tiene que retornar la interfaz(EncounterManager)
    public static CodingItemBuilder withCodingItem(){

        return new CodingItemBuilder();
    }
/*
    public CodingItemBuilder system(String system){
        this.codingItem.setSystem(system);
        return this;
    }

    public CodingItemBuilder code(String code){
        this.codingItem.setCode(code);
        return this;
    }

    public CodingItemBuilder displayCodingItem(String display){
        this.codingItem.setDisplay(display);
        return this;
    }
    public CodingItem buildCodingItem(){
        return codingItem;
    }

*/
}