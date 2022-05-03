package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.ast.BaseNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ComparisonNode extends BaseNode {

    private boolean negate = false;
    private String field;
}
