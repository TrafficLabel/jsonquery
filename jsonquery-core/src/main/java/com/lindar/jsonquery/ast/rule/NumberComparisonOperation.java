package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.ast.rule.ComparisonOperation;

/**
 * Created by stevenhills on 26/09/2016.
 */
public enum NumberComparisonOperation implements ComparisonOperation {
    EQUALS(1),
    GREATER_THAN(1),
    LESS_THAN(1),
    GREATER_THAN_OR_EQUAL(1),
    LESS_THAN_OR_EQUAL(1),
    BETWEEN(2),
    EMPTY(0),
    IN(-1);

    private final int argumentCount;

    NumberComparisonOperation(int argumentCount) {
        this.argumentCount = argumentCount;
    }

    public int getMinArgumentCount() {
        return argumentCount;
    }

    public int getMaxArgumentCount() {
        return argumentCount;
    }
}
