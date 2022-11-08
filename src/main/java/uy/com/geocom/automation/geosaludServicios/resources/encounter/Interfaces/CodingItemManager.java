package uy.com.geocom.automation.geosaludServicios.resources.encounter.Interfaces;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders.IdentifierItemBuilder;

public interface CodingItemManager {


    IdentifierItemBuilder system(String system);
    IdentifierItemBuilder code(String code);
    IdentifierItemBuilder displayCodingItem(String display);


}
