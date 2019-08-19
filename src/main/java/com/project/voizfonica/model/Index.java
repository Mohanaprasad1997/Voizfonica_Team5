package com.project.voizfonica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@Document
public class Index {

    @NotBlank
    @Digits(integer = 10, message = "Invalid mobile number", fraction = 0)
    @Id
    private String mobile_no;
    @NotBlank
    @Size(min =5,message = "Enter at least 5 characters")
    private  String name;
    @NotBlank
    @Size(min = 7,message = "Invalid email")
    private String email;
    @NotBlank
    private String message;

}