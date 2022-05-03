package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
public class BigDecimalComparisonNode extends NumberComparisonNode<BigDecimal> {
    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }

    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v) {
        return null;
    }
}
