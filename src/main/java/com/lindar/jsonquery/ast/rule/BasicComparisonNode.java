package com.lindar.jsonquery.ast.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasicComparisonNode<E, T extends ComparisonOperation> extends ComparisonNode {
    private T operation;
    private List<E> value = new ArrayList<>();
}
