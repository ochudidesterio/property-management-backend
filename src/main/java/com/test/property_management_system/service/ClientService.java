package com.test.property_management_system.service;

import com.test.property_management_system.dto.ClientDto;
import com.test.property_management_system.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient(ClientDto clientDto);
    List<Client>getAllClients();
    Client getClientById(Long clientId);
}
