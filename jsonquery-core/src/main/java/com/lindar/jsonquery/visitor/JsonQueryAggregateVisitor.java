package com.lindar.jsonquery.visitor;

import com.lindar.jsonquery.ast.relationship.aggregate.EnumComparisonAggregateNode;
import com.lindar.jsonquery.ast.relationship.aggregate.LogicalAggregateNode;
import com.lindar.jsonquery.ast.relationship.aggregate.StringComparisonAggregateNode;
import com.lindar.jsonquery.ast.relationship.aggregate.BigDecimalComparisonAggregateNode;

/**
 * Created by stevenhills on 24/09/2016.
 */
public interface JsonQueryAggregateVisitor<R, C> {
    R visit(StringComparisonAggregateNode stringComparisonAggregateNode, C context);

    R visit(LogicalAggregateNode logicalAggregateNode, C context);

    R visit(BigDecimalComparisonAggregateNode bigDecimalComparisonAggregateNode, C context);

    R visit(EnumComparisonAggregateNode enumComparisonAggregateNode, C context);
}
