package com.test.property_management_system.service;

import com.test.property_management_system.dto.TenantDto;
import com.test.property_management_system.dto.TenantProfileDto;
import com.test.property_management_system.model.Property;
import com.test.property_management_system.model.Tenant;
import com.test.property_management_system.repository.PropertyRepository;
import com.test.property_management_system.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService{
    private final TenantRepository tenantRepository;
    private final PropertyRepository propertyRepository;
    private TenantProfileDto profileDto;

    @Override
    public Tenant createTenant(TenantDto tenantDto) {
        Tenant tenant = Tenant.builder()
                .firstName(tenantDto.getFirstName())
                .lastName(tenantDto.getLastName())
                .phoneNumber(tenantDto.getPhoneNumber())
                .build();
        return tenantRepository.save(tenant);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public TenantProfileDto getTenantProfile(Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId).get();
        List<Property>propertyList = propertyRepository.findAll();
        propertyList
                .forEach(property -> property.getHouses()
                        .forEach(house -> {
                            if(house.getTenant() != null){
                                if (house.getTenant().getId() == tenantId) {
                                    profileDto = TenantProfileDto
                                            .builder()
                                            .propertyName(property.getPropertyName())
                                            .houseType(house.getType())
                                            .depositAmount(house.getDepositAmount())
                                            .rentAmount(house.getRentAmount())
                                            .houseName(house.getName())
                                            .firstName(tenant.getFirstName())
                                            .lastName(tenant.getLastName())
                                            .phoneNumber(tenant.getPhoneNumber())
                                            .build();
                                }
                            }
                        }) );
        return profileDto;
    }
}
