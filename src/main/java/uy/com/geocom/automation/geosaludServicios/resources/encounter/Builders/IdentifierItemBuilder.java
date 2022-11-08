package uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.ParametersClasses.IdentifierItem;
import uy.com.geocom.automation.geosaludServicios.resources.encounter.Interfaces.IdentifierItemManager;

public class IdentifierItemBuilder implements IdentifierItemManager {

    //retorna una instancia del mismo builder, para que nos de el encadenamiento
    //El with() que es el método de entrada, tiene que retornar la interfaz(EncounterManager)
    public static IdentifierItemBuilder withIdentifierItem(){

        return new IdentifierItemBuilder();
    }

    private IdentifierItem identifierItem=new IdentifierItem();

    public IdentifierItemBuilder systemIdentifierContainedItem(String systemIdentifierItem){
        this.identifierItem.setSystem(systemIdentifierItem);
        return this;
    }
    public IdentifierItemBuilder useIdentifierContainedItem(String useIdentifierItem){
        this.identifierItem.setUse(useIdentifierItem);
        return this;
    }
    public IdentifierItemBuilder valueIdentifierContainedItem(String valueIdentifierItem){
        this.identifierItem.setValue(valueIdentifierItem);
        return this;
    }
    public IdentifierItem buildIdentifierItem(){
        return identifierItem;
    }
}
