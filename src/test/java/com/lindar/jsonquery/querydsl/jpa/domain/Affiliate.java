package com.lindar.jsonquery.querydsl.jpa.domain;

import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Affiliate {
    @Id
    private long id;

    @Convert(converter = AffiliateTypeConverter.class)
    private AffiliateType type;
}