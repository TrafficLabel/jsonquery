package com.lindar.jsonquery.ast.relationship.aggregate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.lindar.jsonquery.ast.NodeTypeResolver;
import com.lindar.jsonquery.visitor.JsonQueryAggregateVisitor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "type")
@JsonTypeIdResolver(NodeTypeResolver.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogicalAggregateNode extends BaseAggregateNode {

    private LogicalAggregateOperation operation;
    private List<AggregateNode> items = new ArrayList<>();

    public LogicalAggregateNode(LogicalAggregateOperation operation) {
        this.operation = operation;
    }

    public <R, C> R accept(JsonQueryAggregateVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }

    public <R, C> R accept(JsonQueryAggregateVisitor<R, C> v) {
        return v.visit(this, null);
    }

    public enum LogicalAggregateOperation {
        AND, OR
    }
}
