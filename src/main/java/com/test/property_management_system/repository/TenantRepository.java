package com.test.property_management_system.repository;

import com.test.property_management_system.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
}
