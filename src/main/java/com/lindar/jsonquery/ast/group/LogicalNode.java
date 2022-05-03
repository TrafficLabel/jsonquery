package com.lindar.jsonquery.ast.group;

import com.lindar.jsonquery.ast.BaseNode;
import com.lindar.jsonquery.ast.Node;
import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevenhills on 24/09/2016.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LogicalNode extends BaseNode {

    private LogicalOperation operation = LogicalOperation.AND;
    private List<Node> items = new ArrayList<>();

    public LogicalNode(LogicalOperation operation) {
        this.operation = operation;
    }

    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }

    public enum LogicalOperation {
        AND, OR
    }
}
