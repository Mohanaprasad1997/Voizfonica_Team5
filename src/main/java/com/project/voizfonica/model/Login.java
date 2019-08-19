package com.project.voizfonica.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
@Document
public class Login {
    @NotEmpty
    private String contact;

    @NotEmpty(message = "Provide password")
    private String password;
    private String username;
    private String email;

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
