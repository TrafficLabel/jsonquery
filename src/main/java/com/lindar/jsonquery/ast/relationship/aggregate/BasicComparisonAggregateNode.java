package com.lindar.jsonquery.ast.relationship.aggregate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasicComparisonAggregateNode<E, A extends Enum<A>> extends ComparisonAggregateNode<E> {
    private AggregateComparisonOperation operation;
    private A aggregateOperation;

}
