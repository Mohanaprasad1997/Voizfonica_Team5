package com.project.voizfonica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document
@RequiredArgsConstructor
public class Invoice {


    @NotBlank
    @Digits(integer=10,message="Invalid no",fraction=0)
    @Id
    private String contact;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;

}


