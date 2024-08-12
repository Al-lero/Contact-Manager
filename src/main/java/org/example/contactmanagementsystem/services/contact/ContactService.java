package org.example.contactmanagementsystem.services.contact;


import org.example.contactmanagementsystem.dto.request.ContactDto;
import org.example.contactmanagementsystem.dto.response.*;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
   CreateContactResponse createContact(ContactDto information);
   DeleteContactResponse deleteContactByPhoneNumber(String phoneNumber);


   DeleteContactResponseById deleteContactById(String id);

   GetContactResponseById getContactById(String id);
   UpdateContactResponseById updateContactById(String id, ContactDto updatedContact);

}
