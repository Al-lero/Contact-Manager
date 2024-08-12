package org.example.contactmanagementsystem.data.repository;

import org.example.contactmanagementsystem.data.models.Contact;
import org.example.contactmanagementsystem.dto.request.ContactDto;
import org.example.contactmanagementsystem.dto.response.CreateContactResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ContactRepository extends MongoRepository<Contact ,String> {
    Contact findContactByPhoneNumber(String phoneNumber);
    Boolean existsContactByPhoneNumber(String phoneNumber);
    Contact findContactById(String id);

}
