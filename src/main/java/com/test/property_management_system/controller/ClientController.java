package com.test.property_management_system.controller;

import com.test.property_management_system.dto.ClientDto;
import com.test.property_management_system.model.Client;
import com.test.property_management_system.response.ResponseHandler;
import com.test.property_management_system.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/client/create")
    public ResponseEntity<Object>createClient(@RequestBody ClientDto clientDto){
        try{
            Client client = clientService.createClient(clientDto);
            return ResponseHandler.response("client created", HttpStatus.OK,client);

        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
    @GetMapping("/client/all")
    public ResponseEntity<Object>getClients(){
        try{
            List<Client>clients = clientService.getAllClients();
            return ResponseHandler.response("all clients",HttpStatus.OK,clients);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<Object>getClientById(@PathVariable Long id){
        try{
            Client clients = clientService.getClientById(id);
            return ResponseHandler.response("client found",HttpStatus.OK,clients);
        }catch (Exception e){
            return ResponseHandler.response(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }

}
