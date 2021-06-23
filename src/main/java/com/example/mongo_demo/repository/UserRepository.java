package com.example.mongo_demo.repository;

import com.example.mongo_demo.dto.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {
    UserDTO deleteByLogin(String login);
    UserDTO findByLogin(String login);
}
