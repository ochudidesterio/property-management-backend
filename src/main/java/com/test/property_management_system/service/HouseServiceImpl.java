package com.test.property_management_system.service;

import com.test.property_management_system.dto.HouseDto;
import com.test.property_management_system.model.House;
import com.test.property_management_system.model.Property;
import com.test.property_management_system.model.Tenant;
import com.test.property_management_system.repository.HouseRepository;
import com.test.property_management_system.repository.PropertyRepository;
import com.test.property_management_system.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService{
    private final HouseRepository houseRepository;
    private final PropertyRepository propertyRepository;
    private final TenantRepository tenantRepository;
    @Override
    public House createHouse(HouseDto houseDto) {
        House house = House.builder()
                .type(houseDto.getType())
                .depositAmount(houseDto.getDepositAmount())
                .rentAmount(houseDto.getRentAmount())
                .name(houseDto.getName())
                .isVacant(true)
                .build();
        return houseRepository.save(house);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public House findById(Long id) {
        return houseRepository.findById(id).get();
    }

    @Override
    public House addToPropert(Long houseId, Long propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
        House house = houseRepository.findById(houseId).get();
        house.setProperty(property);
        return houseRepository.save(house);
    }

    @Override
    public House addTenant(Long houseId, Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId).get();
        House house = houseRepository.findById(houseId).get();
        house.setTenant(tenant);
        house.setVacant(false);
        return houseRepository.save(house);
    }
}
