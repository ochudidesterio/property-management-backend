package com.test.property_management_system.service;

import com.test.property_management_system.dto.HouseDto;
import com.test.property_management_system.model.House;

import java.util.List;

public interface HouseService {
    House createHouse(HouseDto houseDto);
    List<House> getAllHouses();
    House findById(Long id);
    House addToPropert(Long houseId,Long propertyId);
    House addTenant(Long houseId, Long tenantId);
}
