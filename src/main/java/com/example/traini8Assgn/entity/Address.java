package com.example.traini8Assgn.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}
