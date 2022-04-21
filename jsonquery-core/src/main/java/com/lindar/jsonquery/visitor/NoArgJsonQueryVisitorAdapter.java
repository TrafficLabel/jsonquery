package com.lindar.jsonquery.visitor;

import com.lindar.jsonquery.ast.group.LogicalNode;
import com.lindar.jsonquery.ast.rule.StringComparisonNode;

/**
 * Created by stevenhills on 24/09/2016.
 */
public abstract class NoArgJsonQueryVisitorAdapter<R> implements JsonQueryVisitor<R, Void> {

    public abstract R visit(LogicalNode logicalNode);
    public abstract R visit(StringComparisonNode andNode);

    public R visit(LogicalNode logicalNode, Void context) {
        return visit(logicalNode);
    }

    public R visit(StringComparisonNode stringComparisonNode, Void context) {
        return visit(stringComparisonNode);
    }
}
