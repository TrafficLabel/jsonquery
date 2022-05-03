package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Steven on 26/09/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BooleanComparisonNode extends ComparisonNode {

    private Boolean value;

    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
