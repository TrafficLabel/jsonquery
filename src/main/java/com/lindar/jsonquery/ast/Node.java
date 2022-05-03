package com.lindar.jsonquery.ast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.lindar.jsonquery.visitor.JsonQueryVisitor;

@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "type")
@JsonTypeIdResolver(NodeTypeResolver.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Node {
    <R, C> R accept(JsonQueryVisitor<R, C> v, C context);

    default <R, C> R accept(JsonQueryVisitor<R, C> v) {
        return accept(v, null);
    }

}
