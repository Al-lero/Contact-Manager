package org.example.contactmanagementsystem.web;

import lombok.AllArgsConstructor;
import org.example.contactmanagementsystem.dto.request.UserDto;
import org.example.contactmanagementsystem.data.models.User;
import org.example.contactmanagementsystem.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping("/create")
    public ResponseEntity <User> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/phone-number")
    public void deleteUserByPhoneNumber(String phoneNumber){
        userService.deleteUserByPhoneNumber(phoneNumber);
    }

    @DeleteMapping("/delete-id")
    public void deleteUserById(Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/getUser-id")
    public User getUserById(Long id){
       return userService.getUserById(id);

    }

    @PutMapping("/updateUser-id")
    public User updateUserById(UserDto information){
        return userService.updateUserById(information);
    }

    @GetMapping("/getAllUsers")
   public List<User> getAllUsers(){
        return userService.getAllUsers();
    }




}
