package com.lindar.jsonquery.ast.relationship.aggregate;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by stevenhills on 24/09/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasicComparisonAggregateNode<E, A extends Enum<A>> extends ComparisonAggregateNode<E> {
    private AggregateComparisonOperation operation;
    private A aggregateOperation;

}
