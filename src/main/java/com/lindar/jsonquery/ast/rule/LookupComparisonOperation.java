package com.lindar.jsonquery.ast.rule;

public enum LookupComparisonOperation implements ComparisonOperation {
    EQUALS(1),
    EMPTY(0),
    IN(1, 99);

    private final int maxArgumentCount;
    private final int minArgumentCount;

    LookupComparisonOperation(int argumentCount) {
        this(argumentCount, argumentCount);
    }

    LookupComparisonOperation(int minArgumentCount, int maxArgumentCount) {
        this.minArgumentCount = minArgumentCount;
        this.maxArgumentCount = maxArgumentCount;
    }

    public int getMinArgumentCount() {
        return minArgumentCount;
    }

    public int getMaxArgumentCount() {
        return maxArgumentCount;
    }

}
