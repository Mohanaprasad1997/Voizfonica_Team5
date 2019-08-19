package com.project.voizfonica.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Order {
    @Id
    private String id;
    private String userid;
    private String planId;
    private Payment payment;
    private SignUp user;
    private Plan plan;

}
