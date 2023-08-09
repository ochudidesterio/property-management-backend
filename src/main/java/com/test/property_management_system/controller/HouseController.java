package com.test.property_management_system.controller;

import com.test.property_management_system.dto.HouseDto;
import com.test.property_management_system.model.Client;
import com.test.property_management_system.model.House;
import com.test.property_management_system.model.Property;
import com.test.property_management_system.response.ResponseHandler;
import com.test.property_management_system.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;

    @PostMapping("/house/create")
    public ResponseEntity<Object>createHouse(@RequestBody HouseDto houseDto){
        try{
            House house = houseService.createHouse(houseDto);
            return ResponseHandler.response("house created", HttpStatus.OK,house);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(), HttpStatus.OK,null);
        }
    }
    @PostMapping("/house/{houseId}/add/property/{propId}")
    public ResponseEntity<Object>addHouse(@PathVariable Long houseId, @PathVariable Long propId){
        try{
            House house = houseService.addToPropert(houseId, propId);
            return ResponseHandler.response("added to "+house.getProperty().getPropertyName(),HttpStatus.OK,house);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
    @PostMapping("/house/{houseId}/add/tenant/{tenId}")
    public ResponseEntity<Object>addTenant(@PathVariable Long houseId, @PathVariable Long tenId){
        try{
            House house = houseService.addTenant(houseId, tenId);
            return ResponseHandler.response("Tenant added ",HttpStatus.OK,house);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
    @GetMapping("/house/all")
    public ResponseEntity<Object>getHouses(){
        try{
            List<House> houses = houseService.getAllHouses();
            return ResponseHandler.response("all houses",HttpStatus.OK,houses);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }
}
