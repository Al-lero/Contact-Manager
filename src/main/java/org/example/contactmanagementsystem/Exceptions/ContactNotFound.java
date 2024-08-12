package org.example.contactmanagementsystem.Exceptions;

public class ContactNotFound extends RuntimeException{
    public ContactNotFound(){
        super("contact not found");
    }
}
