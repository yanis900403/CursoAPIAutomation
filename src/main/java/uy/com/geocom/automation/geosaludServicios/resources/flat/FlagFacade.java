package uy.com.geocom.automation.geosaludServicios.resources.flat;

import java.lang.reflect.Array;
import java.util.*;

public class FlagFacade {


    FlagManager flagManager;
    private String ResourceType="Flag";


  private  List<Array> listCodingItem;



    /*private FlagParameters createResourceFlag(DataTableHandler dataResourceFlag) {
        return FlagParameters.builder()
                .resourceType(dataResourceFlag.getAsString("resourceType"))
                .status(dataResourceFlag.getAsString("status"))
                .build();
    }*/


    /*public void completeJsonResourceFlag(List<Map<String, String>> jsonTable) {
        FlagParameters jsonParameters= new FlagParameters();
        jsonParameters.setResourceType(jsonTable.toString());
       // DataTableHandler handler=new DataTableHandler(jsonTable.get(0));

        flagManager.completeJsonResourceFlag(jsonParameters);
    }*/

    public List<Map<String,Object>> completeParametersJsonResourceFlag() {
        List<Map<String,Object>> jsonParametersFlag=new ArrayList<Map<String, Object>>();
        Map<String,Object> objFlag=new LinkedHashMap<String,Object>();
        objFlag.put("resourceType",ResourceType);
        objFlag.put("status","inactive");

        //   List<String> identifier= new ArrayList<String>();
        //    identifier.add("Yanisl222");

        //Nueva variante
        List<String> identifier= Arrays.asList("Yanisl222");
        objFlag.put("identifier",identifier);

        List<Map<String, Object>> categoryFlag= new LinkedList<Map<String, Object>>();
        Map<String,Object> codingFlag= new HashMap<String,Object>();
        codingFlag.put("system","http://terminology.hl7.org/CodeSystem/flag-category");
        codingFlag.put("code","clinical");
        codingFlag.put("display","Clinical");
        categoryFlag.add(codingFlag);
        objFlag.put("category",categoryFlag);


        List<Map<String, Object>> codeFlag= new LinkedList<Map<String, Object>>();
        Map<String,Object> codingCodeFlag= new HashMap<String,Object>();
        codingFlag.put("system","CodeSystem/TiposDeAviso");
        codingFlag.put("code",11);
        codingFlag.put("display","PruebaMay");
        codeFlag.add(codingCodeFlag);
        objFlag.put("code",codeFlag);

        Map<String,Object> subjectFlag= new HashMap<String,Object>();
        codingFlag.put("reference","Patient/4604");
        codingFlag.put("display","ECHAZABAL ESTEVEZ, PABLO ALBERTO");
        objFlag.put("subject",subjectFlag);

        Map<String,Object> periodFlag= new HashMap<String,Object>();
        codingFlag.put("start","2022-09-08");
        codingFlag.put("end","2022-10-10");
        objFlag.put("period",periodFlag);

        jsonParametersFlag.add(objFlag);
        return jsonParametersFlag;

     //    RestAssured.given().log().all().body(jsonParametersFlag).post();

       // flagManager.completeParametersJsonResourceFlag();

    }

    public List<Array> getListCodingItem() {
        return listCodingItem;
    }

    public void setListCodingItem(List<Array> listCodingItem) {
        this.listCodingItem = listCodingItem;
    }
}
