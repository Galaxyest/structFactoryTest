package com.my.structfactorytest.importExcel;

import javafx.scene.control.Cell;
import lombok.Data;

@Data
public class CellRC {
    private Integer firstRow;
    private Integer lastRow;
    private Integer firstColumn;
    private Integer lastColumn;
    private String cellContent;




}
