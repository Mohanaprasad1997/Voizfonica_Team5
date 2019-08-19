package com.project.voizfonica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Plan {
    @Id
    private String id;
    private final String name;
    private final String validity;
    private final String amount;
    private final String type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValidity() {
        return validity;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
