package org.example.contactmanagementsystem.web;

import lombok.AllArgsConstructor;
import org.example.contactmanagementsystem.dto.request.ContactDto;
import org.example.contactmanagementsystem.data.models.Contact;
import org.example.contactmanagementsystem.dto.response.DeleteContactResponseById;
import org.example.contactmanagementsystem.services.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    public ResponseEntity <?> createContact(@RequestBody ContactDto contactDto){
        return new ResponseEntity<>(contactService.createContact(contactDto), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/phone-number")
    public void deleteContactByPhoneNumber(String phoneNumber){
        contactService.deleteContactByPhoneNumber(phoneNumber);
    }

    @DeleteMapping("/delete-id")
    public void deleteUserById(String id){
        contactService.deleteContactById(id);
    }

    @GetMapping("/getUser-id")
    private DeleteContactResponseById deleteContactById(String id){
        return contactService.deleteContactById(id);
    }

   // public Contact updateById(ContactDto information){
     //   return contactService.updateContactById(information);
    //}

    //public List<Contact> getAllContact(){
      //  return contactService.getAllContact();
   // }
}
