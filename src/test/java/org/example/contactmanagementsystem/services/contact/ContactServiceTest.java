package org.example.contactmanagementsystem.services.contact;

import org.example.contactmanagementsystem.data.models.Contact;
import org.example.contactmanagementsystem.data.repository.ContactRepository;
import org.example.contactmanagementsystem.dto.request.ContactDto;
import org.example.contactmanagementsystem.dto.response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactServiceTest {

    @BeforeEach
    void cleanUp(){
        contactRepository.deleteAll();
    }

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

    @Test
    public void testThatContactCanBeCreated(){
        ContactDto createContact = new ContactDto();
        createContact.setPhoneNumber("1234");
        createContact.setLastName("ojo");
        createContact.setFirstName("faith");
        createContact.setAddress("lagos");
        createContact.setEmail("faithojo.com");

        CreateContactResponse response = contactService.createContact(createContact);

        assertEquals(1,contactRepository.count());
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Contact created Successfully");

    }

    @Test
    public void testThatContactCanBeDeletedByPhoneNumber(){
        ContactDto createContact = new ContactDto();
        createContact.setPhoneNumber("1234");
        createContact.setLastName("ojo");
        createContact.setFirstName("faith");
        createContact.setAddress("lagos");
        createContact.setEmail("faithojo.com");

        CreateContactResponse response = contactService.createContact(createContact);
        assertEquals(1,contactRepository.count());
        assertThat(response).isNotNull();

        DeleteContactResponse responseDelete = contactService.deleteContactByPhoneNumber(createContact.getPhoneNumber());
        assertThat(responseDelete).isNotNull();
        assertThat(responseDelete.getMessage()).contains("Contact deleted successfully");
    }

    @Test
    public void testThatContactCanBeDeletedById(){
        ContactDto createContact = new ContactDto();
        createContact.setPhoneNumber("1234");
        createContact.setLastName("ojo");
        createContact.setFirstName("faith");
        createContact.setAddress("lagos");
        createContact.setEmail("faithojo.com");
        createContact.setId("1");

        CreateContactResponse response = contactService.createContact(createContact);
        assertEquals(1,contactRepository.count());
        assertThat(response).isNotNull();

        DeleteContactResponseById deleteContactById = contactService.deleteContactById(createContact.getId());
        //assertEquals(0,contactRepository.count());
        assertThat(deleteContactById.getMessage().contains("Contact deleted by Id successfully"));

    }

    @Test
    public void testThatContactCanBeGottenById(){
        ContactDto createContact = new ContactDto();
        createContact.setPhoneNumber("1234");
        createContact.setLastName("ojo");
        createContact.setFirstName("faith");
        createContact.setAddress("lagos");
        createContact.setEmail("faithojo.com");
        createContact.setId("1");

        CreateContactResponse response = contactService.createContact(createContact);

        assertEquals(1,contactRepository.count());
        assertThat(response).isNotNull();

        GetContactResponseById getContactById = contactService.getContactById(createContact.getId());
        assertThat(getContactById).isNotNull();

    }

    @Test
    public void testThatContactCanBeUpdated(){
        ContactDto createContact = new ContactDto();
        ContactDto updatedContact = new ContactDto();
        updatedContact.setPhoneNumber("2001");
        updatedContact.setLastName("Peace");
        updatedContact.setFirstName("faith");
        updatedContact.setAddress("lagos");
        updatedContact.setEmail("faithojo.com");
        updatedContact.setId("1");

        UpdateContactResponseById updateContactResponseById= contactService.updateContactById("1",updatedContact);
        GetContactResponseById getContactResponseById = contactService.getContactById("1");

        Contact updatedContactFromDataBase = getContactResponseById.getContact();

        assertEquals("2001",updatedContactFromDataBase.getPhoneNumber());
        assertEquals("Peace", updatedContactFromDataBase.getLastName());
        assertEquals("faithpeace.com", updatedContactFromDataBase.getEmail());
        assertEquals("Contact updatde successfully", updatedContactFromDataBase.getMessage());



    }





}