package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class StringComparisonNode extends BasicComparisonNode<String, StringComparisonOperation> {

    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
