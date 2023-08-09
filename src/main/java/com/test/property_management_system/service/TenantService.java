package com.test.property_management_system.service;

import com.test.property_management_system.dto.TenantDto;
import com.test.property_management_system.dto.TenantProfileDto;
import com.test.property_management_system.model.Tenant;

import java.util.List;

public interface TenantService {
    Tenant createTenant(TenantDto tenantDto);
    List<Tenant>getAllTenants();
    TenantProfileDto getTenantProfile(Long tenantId);
}
