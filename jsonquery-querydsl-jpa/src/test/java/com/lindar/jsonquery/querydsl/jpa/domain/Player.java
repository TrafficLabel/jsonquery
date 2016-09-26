package com.lindar.jsonquery.querydsl.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by stevenhills on 25/09/2016.
 */
@Entity
@Data
public class Player {
    @Id
    private long id;
    private String username;
    private BigDecimal deposits;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerAttrition> attritions;
}