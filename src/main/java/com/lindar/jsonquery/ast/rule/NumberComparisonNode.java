package com.lindar.jsonquery.ast.rule;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class NumberComparisonNode<E extends Number & Comparable<E>> extends BasicComparisonNode<E, NumberComparisonOperation> {

}
