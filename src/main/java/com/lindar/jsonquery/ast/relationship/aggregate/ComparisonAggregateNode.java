package com.lindar.jsonquery.ast.relationship.aggregate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ComparisonAggregateNode<E> extends BaseAggregateNode {

    private boolean negate = false;
    private String field;
    private List<E> value = new ArrayList<>();
}
