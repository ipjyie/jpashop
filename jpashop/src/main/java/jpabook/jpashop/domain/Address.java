package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter@Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    
}