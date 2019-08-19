package com.project.voizfonica.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document
@Data
public class Payment {
    @Id
    private String id;
    @NotBlank
    @Size(min = 4,message = "Enter atleast 4 characters")
    private String Name;
    @NotBlank
    @Digits(integer=3,message="Invalid cvv number", fraction = 0)
    private String CVV;
    @NotBlank
    @CreditCardNumber(message="Invalid card number")
    private String CardNumber;
    private String month;
    private String year;
   /* @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
              message="Must be formatted MM/YY")
      private String ExpiryDate;*/

}





