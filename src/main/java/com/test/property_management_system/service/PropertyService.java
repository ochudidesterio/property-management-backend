package com.test.property_management_system.service;

import com.test.property_management_system.dto.PropertyDto;
import com.test.property_management_system.dto.PropertyInfoDto;
import com.test.property_management_system.dto.PropertyListDto;
import com.test.property_management_system.model.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(PropertyDto propertyDto);
    List<PropertyListDto>getPropertiesForClient();
    Property addPropertyToClient(Long clientId,Long propId);
    Property findById(Long id);
    PropertyInfoDto getPropertyInfo(Long propId);
    List<Property>getPropetiesWithImages();
}
