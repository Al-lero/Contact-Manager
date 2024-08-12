package org.example.contactmanagementsystem.data.repository;

import org.example.contactmanagementsystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findUserByPhoneNumber(String phoneNumber);
    Boolean existsUserByPhoneNumber(String phoneNumber);
    User findUserById(Long id);


}
