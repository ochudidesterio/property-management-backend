package com.test.property_management_system.dto;

import com.test.property_management_system.model.House;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PropertyListDto {
   private Long id;
   private String propertyName;
   private String location;
   private List<House>houses;
   private String [] images;
}
