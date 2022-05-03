package com.lindar.jsonquery.ast.relationship.aggregate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode(of="reference")
public abstract class BaseAggregateNode implements AggregateNode, Serializable {
    private String reference = UUID.randomUUID().toString();
    private boolean enabled = true;
}
