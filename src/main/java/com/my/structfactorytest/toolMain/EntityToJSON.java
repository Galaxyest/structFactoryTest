package com.my.structfactorytest.toolMain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.structfactorytest.entity.SafetyWarning;
import com.my.structfactorytest.importExcel.CellRC;

//实体类转JSON
public class EntityToJSON {
    public static void main(String[] args) {

        //将Object替换成自己的实体类
        Object o ;
        o = new SafetyWarning();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(o);

            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
