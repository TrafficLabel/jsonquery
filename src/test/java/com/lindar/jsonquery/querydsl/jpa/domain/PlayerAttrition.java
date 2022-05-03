package com.lindar.jsonquery.querydsl.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by stevenhills on 25/09/2016.
 */
@Entity
@Data
public class PlayerAttrition {
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", referencedColumnName="id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brand_id", referencedColumnName="id")
    private Brand brand;

    @Temporal(value = TemporalType.DATE)
    private Date period;

    private BigDecimal deposits;

    private String promocode;

}
