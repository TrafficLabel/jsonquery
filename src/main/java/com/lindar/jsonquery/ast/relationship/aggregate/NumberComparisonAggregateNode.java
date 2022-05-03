package com.lindar.jsonquery.ast.relationship.aggregate;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class NumberComparisonAggregateNode<E extends Number & Comparable<E>> extends BasicComparisonAggregateNode<E, NumberComparisonAggregateNode.NumberAggregateOperation> {

    public enum NumberAggregateOperation {
        SUM, COUNT, COUNT_DISTINCT, AVG, MAX, MIN
    }
}
