package org.example.contactmanagementsystem.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

}
