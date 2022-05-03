package com.lindar.jsonquery.querydsl.jpa.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Brand {
    @Id
    private long id;
    private String type;
}