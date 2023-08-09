package com.test.property_management_system.repository;

import com.test.property_management_system.model.PropertyImagesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PropertyImagesRepository extends JpaRepository<PropertyImagesModel,Long> {

}
