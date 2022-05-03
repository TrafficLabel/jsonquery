package com.lindar.jsonquery.ast.relationship;

import com.lindar.jsonquery.ast.group.LogicalNode;
import com.lindar.jsonquery.ast.relationship.aggregate.LogicalAggregateNode;
import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RelatedRelationshipNode extends BaseRelationshipNode {

    private String field;
    private boolean negate = false;

    private LogicalNode conditions = new LogicalNode();
    private LogicalAggregateNode aggregations = new LogicalAggregateNode(LogicalAggregateNode.LogicalAggregateOperation.AND);

    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
