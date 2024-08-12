package org.example.contactmanagementsystem.services.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.contactmanagementsystem.dto.request.UserDto;
import org.example.contactmanagementsystem.data.models.User;
import org.example.contactmanagementsystem.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDto information) {
        User user =  new User();
        user.setUserName(information.getUserName());
        user.setEmail(information.getEmail());
        user.setPhoneNumber(information.getPhoneNumber());
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByPhoneNumber(String phoneNumber) {
      boolean doesUserExist =  userRepository.existsUserByPhoneNumber(phoneNumber);
      if (doesUserExist){
         User foundUser = userRepository.findUserByPhoneNumber(phoneNumber);
         userRepository.delete(foundUser);
      }
    }

    @Override
    public void deleteUserById(Long id) {
        boolean doesUserExist = userRepository.existsById(id);
        if (doesUserExist){
            User foundUser = userRepository.findUserById(id);
            userRepository.delete(foundUser);
        }

    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        else {
            throw new RuntimeException("User Not Found");
        }

    }

    @Override
    public User updateUserById(UserDto information) {
        Optional<User> optionalUser = userRepository.findById(information.getId());
        if(optionalUser.isPresent()){
           User updatedUser =  optionalUser.get();
           updatedUser.setUserName(information.getUserName());
           updatedUser.setPhoneNumber(information.getPhoneNumber());
           updatedUser.setEmail(information.getEmail());
           return userRepository.save(updatedUser);
        }
        else {
            throw new RuntimeException("User Not Found");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
