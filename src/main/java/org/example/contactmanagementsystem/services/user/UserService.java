package org.example.contactmanagementsystem.services.user;

import org.example.contactmanagementsystem.dto.request.UserDto;
import org.example.contactmanagementsystem.data.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(UserDto information);
    void deleteUserByPhoneNumber(String phoneNumber);
    void deleteUserById(Long id);
    User getUserById(Long id);
    User updateUserById(UserDto information);
    List<User> getAllUsers();

}
