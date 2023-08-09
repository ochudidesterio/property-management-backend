package com.test.property_management_system.controller;

import com.test.property_management_system.dto.PropertyDto;
import com.test.property_management_system.dto.PropertyInfoDto;
import com.test.property_management_system.dto.PropertyListDto;
import com.test.property_management_system.model.Client;
import com.test.property_management_system.model.House;
import com.test.property_management_system.model.Property;
import com.test.property_management_system.response.ResponseHandler;
import com.test.property_management_system.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    @PostMapping(value = "/property/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object>createProperty(@ModelAttribute PropertyDto propertyDto){
        try{
            Property property = propertyService.createProperty(propertyDto);
            return ResponseHandler.response("property created", HttpStatus.OK,property);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
    @PostMapping("/property/{propId}/add/client/{clientId}")
    public ResponseEntity<Object>addHouse(@PathVariable Long propId, @PathVariable Long clientId){
        try{
            Property property = propertyService.addPropertyToClient(clientId,propId);
            return ResponseHandler.response("added",HttpStatus.OK,property);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
    @GetMapping("/property/all")
    public ResponseEntity<Object>getAllProperty(){
        try{
            List<PropertyListDto> properties = propertyService.getPropertiesForClient();
            return ResponseHandler.response("all properties",HttpStatus.OK,properties);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }
    @GetMapping("/property/get/{propId}")
    public ResponseEntity<Object>getById(@PathVariable Long propId){
        try{
           Property property = propertyService.findById(propId);
           return ResponseHandler.response("found",HttpStatus.OK,property);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.OK,null);

        }
    }
    @GetMapping("/property/info/{propId}")
    public ResponseEntity<Object>getPropertInfo(@PathVariable Long propId){
        try{
            PropertyInfoDto property = propertyService.getPropertyInfo(propId);
            return ResponseHandler.response("found",HttpStatus.OK,property);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.OK,null);

        }
    }
}
