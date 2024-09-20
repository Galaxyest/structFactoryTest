package com.my.structfactorytest.importExcel;

import lombok.Data;

import java.util.List;

@Data
public class Timeee {
    private String clazz;
    private List<String> name;
    private List<String> type;
    private List<String> value;
}
