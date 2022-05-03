package com.lindar.jsonquery.ast.custom;

import com.lindar.jsonquery.ast.BaseNode;
import com.lindar.jsonquery.ast.Node;
import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.Data;

@Data
public abstract class CustomNode extends BaseNode {
    private boolean negate = false;

    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return explode().accept(v, context);
    }

    /**
     * Returns a node that will replace this node with something more complex but not using any CustomNode
     * so that the query can be processed normally after the change
     */
    public abstract Node explode();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
