package com.lindar.jsonquery.ast.relationship.aggregate;

import com.lindar.jsonquery.visitor.JsonQueryAggregateVisitor;
import lombok.EqualsAndHashCode;

/**
 * Created by stevenhills on 24/09/2016.
 */
@EqualsAndHashCode(callSuper = true)
public class StringComparisonAggregateNode extends BasicComparisonAggregateNode<Integer, StringAggregateOperation> {

    public <R, C> R accept(JsonQueryAggregateVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
