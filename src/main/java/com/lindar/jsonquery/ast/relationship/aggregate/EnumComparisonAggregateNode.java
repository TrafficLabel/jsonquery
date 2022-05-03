package com.lindar.jsonquery.ast.relationship.aggregate;

import com.lindar.jsonquery.visitor.JsonQueryAggregateVisitor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class EnumComparisonAggregateNode extends BasicComparisonAggregateNode<Integer, EnumAggregateOperation> {

    public <R, C> R accept(JsonQueryAggregateVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
