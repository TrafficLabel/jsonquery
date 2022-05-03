package com.lindar.jsonquery.visitor;

import com.lindar.jsonquery.ast.relationship.RelatedRelationshipNode;
import com.lindar.jsonquery.ast.rule.LogicalRelationshipNode;

public interface JsonQueryRelationshipVisitor<R, C> {
    R visit(LogicalRelationshipNode logicalRelationshipNode, C context);
    R visit(RelatedRelationshipNode relatedRelationshipNode, C context);
}
