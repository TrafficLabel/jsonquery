package com.lindar.jsonquery.ast.relationship.aggregate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.lindar.jsonquery.ast.NodeTypeResolver;
import com.lindar.jsonquery.visitor.JsonQueryAggregateVisitor;

/**
 * Created by stevenhills on 24/09/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "type")
@JsonTypeIdResolver(NodeTypeResolver.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface AggregateNode {
    <R, C> R accept(JsonQueryAggregateVisitor<R, C> v, C context);
}
