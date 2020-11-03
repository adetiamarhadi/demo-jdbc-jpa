package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {

    private String line1;
    private String line2;
    private String city;

}
