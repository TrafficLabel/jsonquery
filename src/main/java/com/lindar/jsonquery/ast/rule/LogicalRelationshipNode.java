package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.ast.relationship.BaseRelationshipNode;
import com.lindar.jsonquery.ast.relationship.RelatedRelationshipNode;
import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LogicalRelationshipNode extends BaseRelationshipNode {

    private final LogicalOperation operation;
    private List<RelatedRelationshipNode> items = new ArrayList<>();

    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }

    public enum LogicalOperation {
        AND, OR
    }
}