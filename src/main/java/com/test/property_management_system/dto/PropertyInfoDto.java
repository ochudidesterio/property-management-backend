package com.test.property_management_system.dto;

import com.test.property_management_system.model.House;
import com.test.property_management_system.model.Tenant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PropertyInfoDto {
    private String propertyName;
    private String location;
    private List<House> vacants;
    private List<Tenant> tenants;
}
