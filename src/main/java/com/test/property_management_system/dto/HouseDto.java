package com.test.property_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HouseDto {
    private String type;
    private String name;
    private double rentAmount;
    private double depositAmount;


}
