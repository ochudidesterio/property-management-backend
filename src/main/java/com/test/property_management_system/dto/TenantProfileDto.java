package com.test.property_management_system.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantProfileDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String propertyName;
    private String houseType;
    private String houseName;
    private double rentAmount;
    private double depositAmount;
}
