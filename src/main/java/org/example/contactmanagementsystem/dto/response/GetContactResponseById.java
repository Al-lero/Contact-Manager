package org.example.contactmanagementsystem.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.contactmanagementsystem.data.models.Contact;

@Getter
@Setter
@Data
public class GetContactResponseById {
    private Contact contact;
    private String message;



}
