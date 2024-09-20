package com.my.structfactorytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortExecut {
    private String agreement;
    private String localAddress;
    private String externalAddress;
    private String status;
}
