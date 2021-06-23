package com.example.mongo_demo.service;

import com.example.mongo_demo.dto.AddressDTO;
import com.example.mongo_demo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void createAdresses(List<AddressDTO> addresses) {
        addressRepository.saveAll(addresses);
    }

    public void deleteAddresses(List<AddressDTO> addressList) {
        addressRepository.deleteAll(addressList);
    }
}
