package org.example.contactmanagementsystem.services.contact;

import org.example.contactmanagementsystem.dto.request.ContactDto;
import org.example.contactmanagementsystem.data.models.Contact;
import org.example.contactmanagementsystem.data.repository.ContactRepository;
import org.example.contactmanagementsystem.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
//@NoArgsConstructor*/
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public CreateContactResponse createContact(ContactDto information) {
        Contact contact = new Contact();
        contact.setFirstName(information.getFirstName());
        contact.setLastName(information.getLastName());
        contact.setEmail(information.getEmail());
        contact.setAddress(information.getAddress());
        contact.setPhoneNumber(information.getPhoneNumber());
        Contact save = contactRepository.save(contact);

        CreateContactResponse response = new CreateContactResponse();
        response.setMessage("Contact created Successfully");
        return response;
    }

    @Override
    public DeleteContactResponse deleteContactByPhoneNumber(String phoneNumber) {
        boolean doesContactExist = contactRepository.existsContactByPhoneNumber(phoneNumber);
        if (doesContactExist){
            Contact foundContact = contactRepository.findContactByPhoneNumber(phoneNumber);
            contactRepository.delete(foundContact);
        }

        DeleteContactResponse responseDelete = new DeleteContactResponse();
        responseDelete.setMessage("Contact deleted successfully");

        return responseDelete;
    }

    @Override
    public DeleteContactResponseById deleteContactById(String id) {
        boolean doesContactExist = contactRepository.existsById(id);
        if(doesContactExist){
            Contact foundContact = contactRepository.findContactById(id);
            contactRepository.delete(foundContact);

            }

            DeleteContactResponseById deleteContactResponseById = new DeleteContactResponseById();
            deleteContactResponseById.setMessage("Contact deleted by Id");

            return deleteContactResponseById;
    }

    @Override
    public GetContactResponseById getContactById(String id) {
        boolean doesContactExist = contactRepository.existsById(id);
        if(doesContactExist){
            Contact foundContact = contactRepository.findContactById(id);
            contactRepository.findAll();
        }

        GetContactResponseById getContactResponseById = new GetContactResponseById();
        getContactResponseById.setMessage("Contact found by Id");

        return getContactResponseById;
    }

    @Override
    public UpdateContactResponseById updateContactById(String id, ContactDto updatedContact) {
        UpdateContactResponseById updateContactResponseById = new UpdateContactResponseById();

        boolean doesContactExist = contactRepository.existsById(id);

        if(doesContactExist){
            Contact existingContact = contactRepository.findContactById(id);
            existingContact.setEmail(updatedContact.getEmail());
            existingContact.setLastName(updatedContact.getLastName());

            contactRepository.save(existingContact);
            updateContactResponseById.setMessage("Contact updated successsfully");

        }
        else {
            updateContactResponseById.setMessage("Contact not found");

        }

        return  updateContactResponseById;
    }

//    @Override
//    public UpdateContactResponseById findContact() {
//        return null;
//    }


}
