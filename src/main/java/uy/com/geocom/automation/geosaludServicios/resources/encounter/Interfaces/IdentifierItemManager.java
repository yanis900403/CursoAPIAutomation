package uy.com.geocom.automation.geosaludServicios.resources.encounter.Interfaces;

import uy.com.geocom.automation.geosaludServicios.resources.encounter.Builders.IdentifierItemBuilder;

public interface IdentifierItemManager {

    IdentifierItemBuilder systemIdentifierContainedItem(String systemIdentifierItem);
    IdentifierItemBuilder useIdentifierContainedItem(String useIdentifierItem);
    IdentifierItemBuilder valueIdentifierContainedItem(String valueIdentifierItem);
}
