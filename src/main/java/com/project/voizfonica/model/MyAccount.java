package com.project.voizfonica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MyAccount {
    @Id
    private String id;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
