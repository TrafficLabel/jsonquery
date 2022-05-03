package com.lindar.jsonquery.ast;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.lindar.jsonquery.ast.custom.CustomNode;
import com.lindar.jsonquery.ast.group.LogicalNode;
import com.lindar.jsonquery.ast.relationship.RelatedRelationshipNode;
import com.lindar.jsonquery.ast.relationship.aggregate.BigDecimalComparisonAggregateNode;
import com.lindar.jsonquery.ast.relationship.aggregate.EnumComparisonAggregateNode;
import com.lindar.jsonquery.ast.relationship.aggregate.LogicalAggregateNode;
import com.lindar.jsonquery.ast.relationship.aggregate.StringComparisonAggregateNode;
import com.lindar.jsonquery.ast.rule.*;

public class NodeTypeResolver implements TypeIdResolver {

    private String basePackage;
    private JavaType superType;

    @Override
    public void init(JavaType javaType) {
        this.superType = javaType;
        String baseClassName = superType.toCanonical();
        basePackage = baseClassName.substring(baseClassName.lastIndexOf('.') + 1);
    }

    @Override
    public String idFromValue(Object o) {
        return idFromValueAndType(o, o.getClass());
    }

    @Override
    public String idFromValueAndType(Object o, Class<?> subType) {
        // TODO for custom nodes we'll need to either return
        //      the full path or have a method of registering custom types
        //       - to avoid singletons we may need to require an instance of
        //         some new 'JsonQueryHelper' to parse and 'visit' nodes
        String name = subType.getName();
        if (name.startsWith(basePackage)) {
            // we don't return the part of package between the Node and the specific class
            return "." + subType.getSimpleName();
        }
        return name;
    }

    @Override
    public String idFromBaseType() {
        return "." + Node.class.getSimpleName();
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String value) {
        Class<?> subType = getKnownType(value);
        if (subType == null) {
            throw new IllegalStateException("Unsupported Node type [" + value + "]");
        }
        return context.constructSpecializedType(superType, subType);
    }

    private Class<?> getKnownType(String value) {
        switch (value) {
            case ".CustomNode": return CustomNode.class;
            case ".LookupComparisonNode": return LookupComparisonNode.class;
            case ".BigDecimalComparisonNode": return BigDecimalComparisonNode.class;
            case ".BooleanComparisonNode": return BooleanComparisonNode.class;
            case ".EnumComparisonNode": return EnumComparisonNode.class;
            case ".DateComparisonNode": return DateComparisonNode.class;
            case ".StringComparisonNode": return StringComparisonNode.class;
            case ".LogicalNode": return LogicalNode.class;
            case ".RelatedRelationshipNode": return RelatedRelationshipNode.class;
            case ".LogicalAggregateNode": return LogicalAggregateNode.class;
            case ".BigDecimalComparisonAggregateNode": return BigDecimalComparisonAggregateNode.class;
            case ".StringComparisonAggregateNode": return StringComparisonAggregateNode.class;
            case ".EnumComparisonAggregateNode": return EnumComparisonAggregateNode.class;
        }
        return null;
    }

    @Override
    public String getDescForKnownTypeIds() {
        return "See implementation for know type IDs";
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
