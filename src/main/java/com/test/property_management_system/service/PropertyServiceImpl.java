package com.test.property_management_system.service;

import com.test.property_management_system.dto.PropertyDto;
import com.test.property_management_system.dto.PropertyInfoDto;
import com.test.property_management_system.dto.PropertyListDto;
import com.test.property_management_system.model.*;
import com.test.property_management_system.repository.ClientRepository;
import com.test.property_management_system.repository.PropertyImagesRepository;
import com.test.property_management_system.repository.PropertyRepository;
import com.test.property_management_system.repository.TenantRepository;
import com.test.property_management_system.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final ClientRepository clientRepository;
    private final TenantRepository tenantRepository;
    private final PropertyImagesRepository propertyImagesRepository;


    @Override
    public Property createProperty(PropertyDto propertyDto) {
        Property property = Property.builder()
                .propertyName(propertyDto.getPropertyName())
                .location(propertyDto.getLocation())
                .build();
        Property savedProperty = propertyRepository.save(property);

        try {
            uploadImages(propertyDto.getFiles(), savedProperty);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return savedProperty;
    }
    public void uploadImages(MultipartFile[]files,Property property) throws IOException {
        for(MultipartFile file: files){
            PropertyImagesModel model = new PropertyImagesModel();
            String filePath = ImageUtils.upLoadPath+file.getOriginalFilename();
            model.setName(file.getOriginalFilename());
            model.setType(file.getContentType());
            model.setImageUrl(filePath);
            model.setProperty(property);
            propertyImagesRepository.save(model);
            file.transferTo(new File(filePath));
        }
    }

    @Override
    public List<PropertyListDto> getPropertiesForClient() {
        List<Property>properties = propertyRepository.findAll();
        List<PropertyListDto>listDtos = new ArrayList<>();
        for(Property property: properties){
          PropertyListDto propertyListDto  = PropertyListDto.builder()
                    .id(property.getId())
                    .houses(property.getHouses())
                    .propertyName(property.getPropertyName())
                    .location(property.getLocation())
                    .images(getPropertyImages(property.getPropertyImages()))
                    .build();
           listDtos.add(propertyListDto);
        }
    return listDtos;
    }
    public String[] getPropertyImages(List<PropertyImagesModel>imagesModels){
        String[] imageNames = new String[imagesModels.size()];

        for (int i = 0; i < imagesModels.size(); i++) {
            PropertyImagesModel imageModel = imagesModels.get(i);
            imageNames[i] = imageModel.getImageUrl();
        }
        return imageNames;
    }

    @Override
    public Property addPropertyToClient(Long clientId, Long propId) {
        Property property = findById(propId);
        Client client = clientRepository.findById(clientId).get();
        property.setClient(client);
        return propertyRepository.save(property);
    }


    @Override
    public Property findById(Long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public PropertyInfoDto getPropertyInfo(Long propId) {
        // Property property = findById(propId);
        List<PropertyListDto> properties = getPropertiesForClient();
        List<Tenant> tenantList = tenantRepository.findAll();
        PropertyInfoDto propertyInfoDto = PropertyInfoDto.builder().build();
        List<House> houses = new ArrayList<>();
        List<Tenant> tenants = new ArrayList<>();
        propertyInfoDto.setTenants(tenants);
        propertyInfoDto.setVacants(houses);

        PropertyListDto property = properties.
                stream()
                .filter(p -> p.getId() == propId)
                .findFirst()
                .get();
        propertyInfoDto.setPropertyName(property.getPropertyName());
        propertyInfoDto.setLocation(property.getLocation());
        property.getHouses().forEach(house -> {

            if (house != null) {
                if(house.isVacant()){
                    houses.add(house);
                    propertyInfoDto.setVacants(houses);

                }
                tenantList.forEach(tenant -> {
                    if (tenant.getHouse() != null) {

                        if (tenant.getHouse().getId() == house.getId()) {
                            tenants.add(tenant);
                            propertyInfoDto.setTenants(tenants);
                        }
                    }
                });
            }
        });

        return propertyInfoDto;
    }

    @Override
    public List<Property> getPropetiesWithImages() {
        return null;
    }
}
