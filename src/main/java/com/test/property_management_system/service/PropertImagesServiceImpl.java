package com.test.property_management_system.service;

import com.test.property_management_system.model.PropertyImagesModel;
import com.test.property_management_system.repository.PropertyImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertImagesServiceImpl implements PropertImagesService{
    private final PropertyImagesRepository propertyImagesRepository;
    @Override
    public void savePropertyImages(PropertyImagesModel model) {
        propertyImagesRepository.save(model);
    }
}
