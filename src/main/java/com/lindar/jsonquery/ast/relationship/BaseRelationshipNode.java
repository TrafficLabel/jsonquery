package com.lindar.jsonquery.ast.relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode(of="reference")
public abstract class BaseRelationshipNode implements RelationshipNode, Serializable {
    private String reference = UUID.randomUUID().toString();
    private boolean enabled = true;
}
