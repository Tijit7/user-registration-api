package com.userregistration.repository;

import com.userregistration.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByEmail(String email);
}
