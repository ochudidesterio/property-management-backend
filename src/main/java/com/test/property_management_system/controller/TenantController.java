package com.test.property_management_system.controller;

import com.test.property_management_system.dto.TenantDto;
import com.test.property_management_system.dto.TenantProfileDto;
import com.test.property_management_system.model.Client;
import com.test.property_management_system.model.Tenant;
import com.test.property_management_system.response.ResponseHandler;
import com.test.property_management_system.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TenantController {
    private final TenantService tenantService;
    @PostMapping("/tenant/create")
    public ResponseEntity<Object>createTenat(@RequestBody TenantDto tenantDto){
        try{
            Tenant tenant = tenantService.createTenant(tenantDto);
            return ResponseHandler.response("tenant created", HttpStatus.OK,tenant);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
    @GetMapping("/tenant/all")
    public ResponseEntity<Object>getClients(){
        try{
            List<Tenant> tenants = tenantService.getAllTenants();
            return ResponseHandler.response("all tenants",HttpStatus.OK,tenants);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }
    @GetMapping("/tenant/profile/{id}")
    public ResponseEntity<Object>getTenantProfile(@PathVariable Long id){
        try{
            TenantProfileDto tenant = tenantService.getTenantProfile(id);
            return ResponseHandler.response("profile",HttpStatus.OK,tenant);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }
}
