package org.example.contactmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
