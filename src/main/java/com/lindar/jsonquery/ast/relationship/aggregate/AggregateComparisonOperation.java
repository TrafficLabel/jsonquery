package com.lindar.jsonquery.ast.relationship.aggregate;

import com.lindar.jsonquery.ast.rule.ComparisonOperation;

public enum AggregateComparisonOperation implements ComparisonOperation {
    EQUALS(1),
    GREATER_THAN(1),
    LESS_THAN(1),
    GREATER_THAN_OR_EQUAL(1),
    LESS_THAN_OR_EQUAL(1),
    BETWEEN(2),
    EMPTY(0);

    private final int argumentCount;

    AggregateComparisonOperation(int argumentCount) {
        this.argumentCount = argumentCount;
    }

    public int getMinArgumentCount() {
        return argumentCount;
    }

    public int getMaxArgumentCount() {
        return argumentCount;
    }
}
