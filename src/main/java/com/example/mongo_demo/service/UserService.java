package com.example.mongo_demo.service;

import com.example.mongo_demo.dto.UserDTO;
import com.example.mongo_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;
    final AddressService addressService;

    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    public UserDTO createUser(UserDTO userDTO) {
        addressService.createAdresses(userDTO.getAddresses());
        return userRepository.save(userDTO);
    }

    public List<UserDTO> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByLogin(String login) {
        UserDTO userDTO = userRepository.findByLogin(login);
        addressService.deleteAddresses(userDTO.getAddresses());
        userRepository.delete(userDTO);
    }

    public void updateUser(UserDTO userDTO) {
        UserDTO user = this.userRepository.findByLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }
}
