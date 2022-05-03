package com.lindar.jsonquery.ast.relationship.aggregate;

import com.lindar.jsonquery.ast.relationship.aggregate.NumberComparisonAggregateNode;
import com.lindar.jsonquery.visitor.JsonQueryAggregateVisitor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
public class BigDecimalComparisonAggregateNode extends NumberComparisonAggregateNode<BigDecimal> {

    @Override
    public <R, C> R accept(JsonQueryAggregateVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
