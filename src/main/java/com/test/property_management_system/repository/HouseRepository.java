package com.test.property_management_system.repository;

import com.test.property_management_system.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Long> {
}
