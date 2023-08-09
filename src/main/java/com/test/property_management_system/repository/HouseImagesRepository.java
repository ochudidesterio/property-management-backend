package com.test.property_management_system.repository;

import com.test.property_management_system.model.HouseImagesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseImagesRepository extends JpaRepository<HouseImagesModel,Long> {
}
